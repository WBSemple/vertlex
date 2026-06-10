(ns vertlex.dictionary
  (:require [clojure.string :as str]
            [com.rpl.specter :as sp]
            [goog.string :as gstr]
            [lambdaisland.fetch :as fetch]
            [nexus.registry :as nxr]))

(defn elide
  [word text]
  (when text
    (let [redacted (apply str (repeat (count word) \_))]
      (str/replace text word redacted))))

(nxr/register-effect! ::get-entries
  (fn ^:async get-wotd
    [_ store word]
    (let [{:keys [status body]} (js->clj (await (fetch/get (str "https://api.dictionaryapi.dev/api/v2/entries/en/"
                                                                (gstr/urlEncode word))))
                                         {:keywordize-keys true})]
      (when (= status 200)
        (->> (sp/transform [sp/ALL :meanings sp/ALL :definitions sp/ALL (sp/multi-path :definition :example)]
                           (partial elide word)
                           body)
             (swap! store assoc ::entries))))))
