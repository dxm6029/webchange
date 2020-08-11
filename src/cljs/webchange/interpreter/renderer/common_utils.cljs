(ns webchange.interpreter.renderer.common-utils
  (:require
    [clojure.data :refer [diff]]
    [clojure.pprint :as p]
    [webchange.logger :as logger]))

(defn remove-nil-fields [object]
  (apply merge (for [[k v] object :when (not (nil? v))] {k v})))

(defn get-position
  [spine-object]
  (let [position (.-position spine-object)]
    {:x (.-x position)
     :y (.-y position)}))

(defn set-position
  [spine-object position]
  (let [{:keys [x y]} (merge (get-position spine-object)
                             (remove-nil-fields position))]
    (-> (.-position spine-object)
        (.set x y))))

(defn get-scale
  [spine-object]
  (let [scale (.-scale spine-object)]
    {:x (.-x scale)
     :y (.-y scale)}))

(defn set-scale
  [spine-object scale]
  (let [{:keys [x y]} (merge (get-scale spine-object)
                             (remove-nil-fields (if (number? scale)
                                                  {:x scale
                                                   :y scale}
                                                  scale)))]
    (-> (.-scale spine-object)
        (.set x y))))

(defn set-handler
  [object event-name event-handler]
  (let [synonyms {"click" ["click" "tap"]}]
    (aset object "interactive" true)
    (doseq [event (get synonyms event-name)]
      (.on object event event-handler))))

(defn get-specific-params
  [props params]
  (reduce (fn [result param]
            (let [[param-name param-alias default-value] (if (map? param)
                                                           [(:name param)
                                                            (if (contains? param :alias) (:alias param) (:name param))
                                                            (if (contains? param :default) (:default param) nil)]
                                                           [param param nil])]
              (assoc result param-name (get props param-alias default-value))))
          {}
          params))

(defn check-rest-props
  [entity-id props & known-params-list]
  (let [rest-props (->> known-params-list
                        (reduce (fn [rest-params ignore-params]
                                  (let [ignore-aliases (map (fn [param]
                                                              (if (map? param)
                                                                (if (contains? param :alias) (:alias param) (:name param))
                                                                param))
                                                            ignore-params)]
                                    (clojure.set/difference rest-params (set ignore-aliases))))
                                (set (keys props)))
                        (select-keys props))]
    (when-not (empty? rest-props)
      ;(print "--")
      ;(print "known-params-list" known-params-list)
      ;(print "props" props)

      (logger/warn "There are extra props for" entity-id)
      (logger/debug-folded (str entity-id " extra props") rest-props))))

(defn check-not-updated-props
  [entity-id old-props new-props updated-props-names]
  (let [diff-result (diff old-props new-props)
        not-updated-props (-> (clojure.set/union (-> diff-result (first) (keys) (set))
                                                 (-> diff-result (second) (keys) (set)))
                              (clojure.set/difference (set updated-props-names))
                              (vec))
        fully-updated? (empty? not-updated-props)]
    (when-not fully-updated?
      (logger/warn "There are not updated props for" entity-id)
      (logger/debug-folded (str entity-id " not updated props") not-updated-props))
    fully-updated?))
