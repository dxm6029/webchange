(ns webchange.editor-v2.diagram.diagram-utils.utils
  (:require
    [webchange.editor-v2.diagram.diagram-utils.arranger :refer [arrange-items]]))

(defn reorder
  [engine]
  (let [model (.getDiagramModel engine)]
    (arrange-items model engine)
    (.repaintCanvas engine)))

(defn zoom-to-fit
  [engine]
  (.zoomToFit engine))