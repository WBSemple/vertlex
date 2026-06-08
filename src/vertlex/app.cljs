(ns vertlex.app
  (:require [replicant.dom :as r]))

(defn app []
  [:div.max-w-6xl.mx-auto.p-4
   [:h1.text-8xl.font-serif.text-center "Vertlex"]
   [:div "hello :)"]])

(defn ^:dev/after-load render! []
  (r/render
    (js/document.getElementById "app")
    (app)))

(defn ^:export init! []
  (render!))
