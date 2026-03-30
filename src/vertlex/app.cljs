(ns vertlex.app
  (:require [helix.core :refer [$ <>]]
            [helix.dom :as d]
            [refx.alpha :as r]
            [vertlex.macros :refer [defnc]]
            [vertlex.routing :as routing]))

(defnc app []
  (let [current-route (r/use-sub [::routing/current-route])]
    (d/div {:className "max-w-5xl mx-auto px-4 pb-6"}
     (when current-route
       (-> current-route :data :view $)))))
