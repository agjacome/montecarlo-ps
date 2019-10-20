(ns montecarlo-ps.main
  (:require [montecarlo-ps.http.server :as server]))

(defn -main [& args] (server/run))
