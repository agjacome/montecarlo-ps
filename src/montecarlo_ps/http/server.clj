(ns montecarlo-ps.http.server
  (:require [compojure.core :refer [context, defroutes]]
            [compojure.route :refer [not-found]]
            [org.httpkit.server :as server]
            [environ.core :refer [env]]
            [montecarlo-ps.http.monte-carlo :as monte-carlo]))

(defroutes routes
  (context   "/" [] monte-carlo/routes)
  (not-found "Resource Not Found"))

(defn run []
  (let [port (Integer/parseInt (or (env :port) "8080"))]
    (server/run-server #'routes {:port port})
    (println (str "Webserver started at http://localhost:" port "/"))))
