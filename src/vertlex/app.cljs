(ns vertlex.app
  (:require [helix.core :refer [$ <>]]
            [refx.alpha :as r]
            [vertlex.macros :refer [defnc]]
            [vertlex.routing :as routing]))

(defnc app []
  (let [current-route (r/use-sub [::routing/current-route])]
    (when current-route
      (-> current-route :data :view $))))
