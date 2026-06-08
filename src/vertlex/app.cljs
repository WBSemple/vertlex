(ns vertlex.app
  (:require [replicant.dom :as r]
            [vertlex.icons :as icons]))

(defn app []
  (doto [:div.max-w-6xl.mx-auto.p-4
    [:h1.text-8xl.font-serif.text-center "Vertlex"]
    [:div "hello :)"]
    (icons/search "size-5 text-primary")]
    prn))

(defn ^:dev/after-load render! []
  (r/render
    (js/document.getElementById "app")
    (app)))

(defn ^:export init! []
  (render!))
