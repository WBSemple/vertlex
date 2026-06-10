(ns vertlex.ui
  (:require [vertlex.dictionary :as-alias dictionary]
            [vertlex.icons :as icons]
            [vertlex.wiktionary :as-alias wiktionary]))

(defn dictionary-definition
  [{:keys [definition example]}]
  [:div
   [:p definition]
   [:i example]])

(defn dictionary-meaning
  [{:keys [definitions partOfSpeech]}]
  [:div
   [:strong partOfSpeech]
   (map dictionary-definition definitions)])

(defn dictionary-entry
  [{:keys [meanings]}]
  (map dictionary-meaning meanings))

(defn view
  [state]
  (let [wotd (::wiktionary/wotd state)
        entries (::dictionary/entries state)]
    [:div.flex.flex-col.h-screen
     [:div.navbar.bg-base-200
      [:div.max-w-6xl.mx-auto.w-full.px-1.flex
       [:h1.text-4xl.font-serif "Vertlex"]
       [:a.link.link-accent.ms-auto.my-auto
        {:href "https://github.com/WBSemple/vertlex"
         :target "_blank"}
        (icons/code-xml ["size-8"])]]]
     [:div.max-w-6xl.mx-auto.w-full.p-4
      (if entries
        (map dictionary-entry entries)
        [:div.text-center [:span.loading.loading-dots.loading-xl]])]
     [:div.mt-auto.text-center.p-2.text-lg.text-neutral
      "With thanks to "
      [:a.link.link-accent {:href "https://www.wiktionary.org/"
                            :target "_blank"}
       "wiktionary.org"]
      " and "
      [:a.link.link-accent {:href "https://dictionaryapi.dev/"
                            :target "_blank"}
       "dictionaryapi.dev"]
      " "
      (icons/heart ["inline" "align-top" "size-6"])]]))
