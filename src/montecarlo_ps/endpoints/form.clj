(ns montecarlo-ps.endpoints.form
  (:require [compojure.core :refer [GET, POST, defroutes]]
            [selmer.parser :refer [render-file]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.multipart-params :refer [wrap-multipart-params]]))

(defn get-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/pages/form.html" {})})

(defn post-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/pages/results.html" {:content (slurp (:tempfile (get (:params request) "csv"))) :startDate (get (:params request) "startDate")})})

(defroutes routes
  (GET "/" [] get-handler)
  (wrap-multipart-params (wrap-params (POST "/" [] post-handler))))