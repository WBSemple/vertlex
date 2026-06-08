(ns vertlex.app
  (:require [applied-science.js-interop :as j]
            [dataspex.core :as dataspex]
            [nexus.registry :as nxr]
            [replicant.dom :as r]
            [vertlex.ui :as ui]
            [vertlex.wiktionary :as wiktionary]))

(defonce store (atom {}))

(nxr/register-system->state!
  (fn [store*]
    (assoc @store* :now (js/Date.))))

(r/set-dispatch! #(nxr/dispatch store %1 %2))

(defn render!
  [state]
  (r/render (j/call js/document :getElementById "app")
            (ui/view state)))

(add-watch store ::render #(render! %4))

(defn ^:dev/after-load refresh! []
  (render! @store))

(defn ^:export init! []
  (reset! store {:counter 1})
  (nxr/dispatch store {} [[::wiktionary/get-wotd]])
  (dataspex/inspect "App state" store))
