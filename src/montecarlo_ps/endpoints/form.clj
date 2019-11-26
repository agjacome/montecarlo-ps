(ns montecarlo-ps.endpoints.form
  (:require [compojure.core :refer [GET, POST, defroutes]]
            [selmer.parser :refer [render-file]]))

(defn get-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/pages/form.html" {})})

(defn post-handler [request]
  (let [start-date  (-> request :params :startDate)
        csv-content (-> request :params :csv :tempfile slurp)]
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    (render-file "montecarlo_ps/pages/results.html" {:content csv-content :startDate start-date})}))

(defroutes routes
  (GET "/" [] get-handler)
  (POST "/" [] post-handler))
