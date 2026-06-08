(ns vertlex.ui
  (:require [nexus.registry :as nxr]
            [vertlex.icons :as icons]))

(nxr/register-effect! :effects/save
  (fn save [_ store path value]
    (swap! store assoc-in path value)))

(nxr/register-action! :actions/inc
  (fn increment [state path]
    [[:effects/save path (inc (get-in state path))]]))

(defn view
  [state]
  [:div.max-w-6xl.mx-auto.p-4
   [:h1.text-8xl.font-serif.text-center "Vertlex"]
   [:div "hello :)"]
   [:div (str (:counter state))]
   [:div (pr-str state)]
   [:button.btn {:on {:click [[:actions/inc [:counter]]]}}
    "inc"]
   (icons/search "size-5 text-primary")])
