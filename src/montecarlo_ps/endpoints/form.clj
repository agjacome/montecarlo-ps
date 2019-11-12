(ns montecarlo-ps.endpoints.form
  (:require [compojure.core :refer [GET, POST, defroutes]]
            [selmer.parser :refer [render-file]]
            [clojure.walk :refer [keywordize-keys]]
            [ring.util.codec :refer [form-decode]]
            [ring.util.request :refer [body-string]]))

(defn- parse-form-data [request]
  (keywordize-keys (form-decode (body-string request))))

(defn get-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/pages/form.html" {})})

(defn post-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/pages/results.html" (parse-form-data request))})

(defroutes routes
  (GET  "/" [] get-handler)
  (POST "/" [] post-handler))
