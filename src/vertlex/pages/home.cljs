(ns vertlex.pages.home
  (:require ["@fontsource-variable/league-spartan/wght.css" :as _spartan]
            [helix.dom :as d]
            [vertlex.macros :refer [defnc]]))

(defnc view []
  (d/h3 {:className "text-3xl font-black"} "Sphinx of black quartz, judge my vow."))
