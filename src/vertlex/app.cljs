(ns vertlex.app
  (:require [dataspex.core :as dataspex]
            [nexus.registry :as nxr]
            [replicant.dom :as r]
            [vertlex.ui :as ui]))

(defonce store (atom {}))

(nxr/register-system->state! deref)

(r/set-dispatch! #(nxr/dispatch store %1 %2))

(defn render!
  [state]
  (r/render (js/document.getElementById "app")
            (ui/view state)))

(add-watch store ::render #(render! %4))

(defn ^:dev/after-load refresh! []
  (render! @store))

(defn ^:export init! []
  (reset! store {:counter 1})
  (dataspex/inspect "App state" store))
