(ns montecarlo-ps.http.hello-world
  (:require [compojure.core :refer [GET, defroutes]]
            [selmer.parser :refer [render-file]]))


(defn get-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/http/hello_world.html" {})})

(defroutes routes
   (GET "/" [] get-handler))
