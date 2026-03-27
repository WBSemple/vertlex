(ns vertlex.core
  (:require [helix.core :refer [$]]
            ["react-dom/client" :as rdom]
            [vertlex.app :as app]
            [vertlex.pages.home :as home]
            [vertlex.pages.not-found :as not-found]
            [vertlex.routing :as routing]
            [refx.alpha :as r]
            [reitit.frontend :as rf]))

(def routes
  ["/"
   [""
    {:name ::routing/home
     :title "Vertlex"
     :view home/view
     :controllers [{:start (fn [_]
                             (r/dispatch [::home/refresh]))}]}]
   
   ["not-found"
    {:name ::routing/not-found
     :title "Vertlex - 404"
     :view not-found/view}]])

(defn ^:export init []
  (r/clear-subscription-cache!)
  (let [router (rf/router routes)]
    (routing/start-routing! router)
    (doto (rdom/createRoot (js/document.getElementById "app"))
      (.render ($ app/app)))))
