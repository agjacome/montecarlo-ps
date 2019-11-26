(ns montecarlo-ps.main
  (:require [environ.core :refer [env]]
            [org.httpkit.server :as server]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.multipart-params :refer [wrap-multipart-params]]
            [montecarlo-ps.endpoints.routes :refer [routes]]))

(def application (-> routes (wrap-keyword-params) (wrap-params) (wrap-multipart-params)))

(defn -main [& args]
  (let [port (Integer/parseInt (or (env :port) "8080"))]
    (server/run-server #'application {:port port})
    (println (str "Webserver started at http://localhost:" port "/"))))
