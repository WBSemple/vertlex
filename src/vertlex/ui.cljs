(ns vertlex.ui
  (:require [nexus.registry :as nxr]
            [vertlex.icons :as icons]
            [vertlex.wiktionary :as-alias wiktionary]))

(nxr/register-effect! :effects/save
  (fn save [_ store path value]
    (swap! store assoc-in path value)))

(nxr/register-action! :actions/inc
  (fn increment [state path]
    [[:effects/save path (inc (get-in state path))]]))

(defn view
  [state]
  (let [wotd (::wiktionary/wotd state)]
    [:div.flex.flex-col.h-screen
     [:div.navbar.bg-base-200
      [:div.max-w-6xl.mx-auto.w-full.px-1.flex
       [:h1.text-4xl.font-serif "Vertlex"]
       [:a.ms-auto.my-auto.text-neutral
        {:href "https://github.com/WBSemple/vertlex"
         :target "_blank"}
        (icons/code-xml ["size-8"])]]]
     [:div.max-w-6xl.mx-auto.w-full.p-4
      (if wotd
        [:div wotd]
        [:div.text-center [:span.loading.loading-dots.loading-xl]])
      [:div (str (:counter state))]
      [:button.btn {:on {:click [[:actions/inc [:counter]]]}}
       "inc"]]
     [:div.mt-auto.text-center.p-2.text-lg.text-neutral
      "With thanks to "
      [:a.link {:href "https://www.wiktionary.org/"
                :target "_blank"}
       "wiktionary.org"]
      " and "
      [:a.link {:href "https://dictionaryapi.dev/"
                :target "_blank"}
       "dictionaryapi.dev"]]]))
