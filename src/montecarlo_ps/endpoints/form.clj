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
  (let [request-params (:params request)
        start-date     (request-params "startDate")
        csv-content    (slurp (:tempfile (request-params "csv")))]
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    (render-file "montecarlo_ps/pages/results.html" {:content csv-content :startDate start-date})}))

(defroutes routes
  (GET "/" [] get-handler)
  (wrap-multipart-params (wrap-params (POST "/" [] post-handler))))
