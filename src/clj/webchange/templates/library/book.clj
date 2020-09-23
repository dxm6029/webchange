(ns webchange.templates.library.book
  (:require
    [webchange.templates.core :as core]
    [clojure.string :refer [index-of]]))

(def m {:id          5
        :name        "book"
        :description "Simple book"
        :options     {:title {:label "Title"
                              :type "string"}
                      :pages {:label "Pages"
                              :type  "pages"
                              :max   10}}})

(def t {:assets        [{:url "/raw/img/book/books_02.jpg", :size 10, :type "image"}
                        {:url "/raw/img/ui/back_button_01.png" :size 1 :type "image"}
                        {:url "/raw/img/demo/book1/2-fawn-running.jpg" :size 5 :type "image"}
                        {:url "/raw/img/demo/book1/3-fawn-and-rabbit-running.jpg" :size 5 :type "image"}
                        {:url "/raw/img/demo/book1/4-fawn-and-elephant-running.jpg" :size 5 :type "image"}
                        {:url "/raw/img/demo/book1/5-fawn-leaping-across-stream.jpg" :size 5 :type "image"}]
        :objects       {:background      {:type "background"
                                          :src  "/raw/img/book/books_02.jpg"}
                        :next-page-arrow {:type    "image",
                                          :x 1770
                                          :y 500
                                          :width   97,
                                          :height  99,
                                          :actions {:click {:id "next-page", :on "click", :type "action"}},
                                          :scale-x -1,
                                          :src     "/raw/img/ui/back_button_01.png"},}
        :scene-objects [["background" "next-page-arrow"]],
        :actions       {:dialog-1-title {:type               "sequence-data",
                                         :concept-var        "current-word",
                                         :data               [{:type "sequence-data"
                                                               :data [{:type "empty" :duration 0}
                                                                      {:data        [],
                                                                       :type        "text-animation",
                                                                       :audio       nil,
                                                                       :target      "title",
                                                                       :animation   "bounce",
                                                                       :phrase-text nil}]}],
                                         :phrase             "dialog-title",
                                         :phrase-description "Dialog title",
                                         :dialog-track       "1 Title"}

                        :next-page      {:type "sequence-data"
                                         :data [{:type     "set-attribute" :attr-name "visible", :attr-value false
                                                 :from-var [{:template "group-%", :var-name "current-page", :action-property "target"}]}
                                                {:type "counter", :counter-id "current-page", :counter-action "increase"}
                                                {:type     "set-attribute" :attr-name "visible", :attr-value true
                                                 :from-var [{:template "group-%", :var-name "current-page", :action-property "target"}]}
                                                {:type     "action"
                                                 :from-var [{:template "dialog-%-page", :var-name "current-page", :action-property "id"}]}]}
                        :intro
                                        {:type "sequence-data",
                                         :data [{:type "start-activity"}
                                                {:type "set-variable", :var-name "current-page", :var-value 0}
                                                {:type "set-variable", :var-name "max-page", :var-value 4}
                                                {:type "empty" :duration 1000}
                                                {:type "action" :id "dialog-1-title"}]}}
        :triggers
                       {:start {:on "start", :action "intro"}}})

(defn- group-name
  [idx]
  (str "group-" idx))

(defn- part->chunk
  [phrase part start]
  (let [start (index-of phrase part start)
        end (+ start (count part))]
    {:start start :end end}))

(defn parts->chunks
  [phrase parts]
  (loop [idx 0
         tail parts
         chunks []]
    (if (empty? tail)
      chunks
      (let [chunk (part->chunk phrase (first tail) idx)]
        (recur (:end chunk)
               (rest tail)
               (conj chunks chunk))))))

(defn- text->chunks
  [text]
  []
  (parts->chunks text (clojure.string/split text #" ")))

(defn- create-page
  [idx {:keys [img text]}]
  (let [group-name (group-name idx)
        image-name (str "image-" idx)
        text-name (str "text-" idx)]
    {(keyword group-name) {:type "group" :children [image-name text-name] :visible false :x 370 :y 130 }
     (keyword image-name) {:type "image" :src img :x 590 :y 320 :origin {:type "center-center"} :max-width 1180 :max-height 640}
     (keyword text-name)  {:type "text" :x 0 :y 670 :width 1180 :vertical-align "top" :font-family "Lexend Deca" :font-size 80
                           :text text :chunks (text->chunks text)}}))

(defn- create-page-dialog
  [idx {:keys [text]}]
  (let [dialog {:type               "sequence-data",
                :concept-var        "current-word",
                :data               [{:type "sequence-data"
                                      :data [{:type "empty" :duration 0}
                                             {:data        [],
                                              :type        "text-animation",
                                              :audio       nil,
                                              :target      (str "text-" idx),
                                              :animation   "bounce",
                                              :phrase-text text}]}],
                :phrase             (str "dialog-page-" idx),
                :phrase-description (str "Page dialog " idx),
                :dialog-track       "2 Pages"}
        name (str "dialog-" idx "-page")]
    {(keyword name) dialog}))

(defn- add-pages
  [t pages]
  (let [page-container (->> pages
                            (map-indexed (fn [idx p] (create-page (inc idx) p)))
                            (reduce merge))
        dialog-container (->> pages
                              (map-indexed (fn [idx p] (create-page-dialog (inc idx) p)))
                              (reduce merge))
        group-names (->> (count pages) (range) (map inc) (map group-name) (into []))]
    (-> t
        (update :objects merge page-container)
        (update :actions merge dialog-container)
        (update :scene-objects conj group-names))))

(defn- add-title
  [t title]
  (let [title-name "title"
        group-object {:type "group" :children [title-name] :x 370 :y 400}
        text-object {:type "text" :width 1180 :align "center":vertical-align "top" :font-family "Lexend Deca" :font-size 120
                     :text title :chunks (text->chunks title)}]
    (-> t
        (assoc-in [:objects :group-0] group-object)
        (assoc-in [:objects :title] text-object)
        (assoc-in [:actions :dialog-1-title :data 0 :data 1 :phrase-text] title)
        (update :scene-objects conj ["group-0"]))))

(defn f
  [args]
  (-> t
      (add-title (:title args))
      (add-pages (:pages args))))

(core/register-template
  (:id m)
  m
  f)
