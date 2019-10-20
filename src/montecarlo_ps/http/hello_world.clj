(ns montecarlo-ps.http.hello-world
  (:require [compojure.core :refer [GET, defroutes]]))

(defn get-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "<h1>Hello World!</h1>"})

(defroutes routes
   (GET "/" [] get-handler))
