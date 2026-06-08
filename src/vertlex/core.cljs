(ns vertlex.core
  (:require [replicant.dom :as r]))

(defn ^:export init []
  (r/render
    (js/document.getElementById "app")
    [:div "hello :)"]))
