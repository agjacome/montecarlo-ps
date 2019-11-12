(ns montecarlo-ps.main
  (:require [environ.core :refer [env]]
            [montecarlo-ps.endpoints.routes :refer [routes]]
            [org.httpkit.server :as server]))

(defn -main [& args]
  (let [port (Integer/parseInt (or (env :port) "8080"))]
    (server/run-server #'routes {:port port})
    (println (str "Webserver started at http://localhost:" port "/"))))
