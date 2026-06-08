(ns vertlex.icons
  (:require ["lucide/dist/esm/icons/code-xml$default" :as CodeXml]))

(defn icon
  [elements]
  (let [hiccup (map (fn [[tag attrs]]
                      [(keyword tag) attrs])
                    (js->clj elements {:keywordize-keys true}))]
    (fn [class]
      [:svg {:stroke "currentColor"
             :fill "none"
             :stroke-linejoin "round"
             :width "24"
             :xmlns "http://www.w3.org/2000/svg"
             :stroke-linecap "round"
             :stroke-width "2"
             :class class
             :viewBox "0 0 24 24"
             :height "24"}
       hiccup])))

(def code-xml (icon CodeXml))
