(ns vertlex.pages.not-found
  (:require [helix.dom :as d]
            [vertlex.macros :refer [defnc]]))

(defnc view []
  (d/h3 "404"))
