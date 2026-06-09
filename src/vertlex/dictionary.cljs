(ns vertlex.dictionary
  (:require [goog.string :as gstr]
            [lambdaisland.fetch :as fetch]
            [nexus.registry :as nxr]))

(nxr/register-effect! ::get-entries
  (fn ^:async get-wotd
    [_ store word]
    (let [{:keys [status body]} (js->clj (await (fetch/get (str "https://api.dictionaryapi.dev/api/v2/entries/en/"
                                                                (gstr/urlEncode word))))
                                         {:keywordize-keys true})]
      (when (= status 200)
        (swap! store assoc ::entries body)))))
