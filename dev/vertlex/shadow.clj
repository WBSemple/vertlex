(ns vertlex.shadow
  (:require [shadow.cljs.devtools.api :as shadow]))

(defn watch
  {:shadow/requires-server true}
  []
  (shadow/watch :app))
