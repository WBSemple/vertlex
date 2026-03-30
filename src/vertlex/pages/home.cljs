(ns vertlex.pages.home
  (:require ["@fontsource-variable/league-spartan/wght.css" :as _spartan]
            [helix.core :refer [$ <>]]
            [helix.dom :as d]
            [vertlex.macros :refer [defnc]]))


(defnc search []
  (d/label {:className "input"}
    (d/svg {:className "h-[1em] opacity-50"
            :xmlns "http://www.w3.org/2000/svg"
            :viewBox "0 0 24 24"}
      (d/g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
        (d/circle {:cx "11" :cy "11" :r "8"})
        (d/path {:d "m21 21-4.3-4.3"})))
    (d/input {:className "grow"
              :type "search"
              :placeholder "Search"})))

(defnc view []
  (<>
    (d/h1 {:className "text-8xl mt-6 text-center font-serif"} "Vertlex")
    (d/div {:className "flex justify-center mt-12"}
      ($ search))))
