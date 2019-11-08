(ns montecarlo-ps.http.monte-carlo
  (:require [compojure.core :refer [GET, POST, defroutes]]
            [selmer.parser :refer [render-file]]))


(defn form-page [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (render-file "montecarlo_ps/http/form.html" {})})

(defn form-page-submission [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "<h1>It has worked</h1>"})

(defroutes routes
  (GET  "/" [] form-page            )
  (POST "/submit"    [] form-page-submission))
