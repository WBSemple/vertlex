(ns vertlex.pages.home
  (:require [helix.dom :as d]
            [vertlex.macros :refer [defnc]]))

(defnc view []
  (d/h3 "Hello :)"))
