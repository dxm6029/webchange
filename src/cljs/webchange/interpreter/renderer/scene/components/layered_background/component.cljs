(ns webchange.interpreter.renderer.scene.components.layered-background.component
  (:require
    [webchange.interpreter.pixi :refer [Container Sprite]]
    [webchange.resources.manager :as resources]
    [webchange.interpreter.renderer.scene.filters.filters :refer [apply-filters]]
    [webchange.interpreter.renderer.scene.components.layered-background.wrapper :refer [wrap]]))

(def default-props {:name       {}
                    :background {:default nil}
                    :decoration {:default nil}
                    :surface    {:default nil}
                    :filters    {:default []}})

(defn- create-container
  [{:keys [name]}]
  (doto (Container.)
    (aset "name" (str name "-sprite-container"))))

(defn- create-sprite
  [layer-name {:keys [filters] :as props}]
  (if-let [src (get-in props [layer-name :src])]
    (let [resource (resources/get-resource src)]
      (when (and (-> resource nil?)
                 (-> src nil? not))
        (throw (js/Error. (str "Resources for '" src "' were not loaded"))))
      (let [sprite (if (-> resource nil? not)
                     (Sprite. (.-texture resource))
                     (Sprite.))]
        (apply-filters sprite filters)
        sprite))))

(def component-type "layered-background")

(defn create
  [{:keys [parent type object-name] :as props}]
  (let [container (create-container props)]
    (if-let [background (create-sprite :background props)]
      (.addChild container background))
    (if-let [background (create-sprite :surface props)]
      (.addChild container background))
    (if-let [background (create-sprite :decoration props)]
      (.addChild container background))
    (.addChild parent container)
    (wrap type object-name container)))
