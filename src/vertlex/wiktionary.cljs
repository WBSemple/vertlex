(ns vertlex.wiktionary
  (:require [applied-science.js-interop :as j]
            [goog.string :as gstr]
            [goog.string.format]
            [lambdaisland.fetch :as fetch]
            [nexus.registry :as nxr]))

(nxr/register-effect! ::get-wotd
  (fn ^:async get-wotd
    [{{:keys [now]} :state} store]
    (let [page (gstr/format "Wiktionary:Word_of_the_day/%s/%s_%s"
                            (j/call now :getFullYear)
                            (j/call now :toLocaleString "en" #js {:month "long"})
                            (j/call now :getDate))
          {:keys [status body]} (js->clj (await (fetch/get "https://en.wiktionary.org/w/api.php"
                                                           {:query-params {:action "parse"
                                                                           :page page
                                                                           :prop "wikitext"
                                                                           :format "json"
                                                                           :origin "*"}}))
                                         {:keywordize-keys true})]
      (when (= status 200)
        (swap! store assoc ::wotd (->> (get-in body [:parse :wikitext :*])
                                       (re-find #"(?<=\{\{WOTD\|)[^\|]+")))))))
