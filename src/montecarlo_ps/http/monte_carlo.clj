(ns montecarlo-ps.http.monte-carlo
  (:require [compojure.core :refer [GET, POST, defroutes]]
            [selmer.parser :refer [render-file]]
            [clojure.walk :refer [keywordize-keys]]
            [ring.util.codec :refer [form-decode]]))

(defn- parse-form-data [request]
  (keywordize-keys (form-decode (:body request))))

(defn form-page [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/http/form.html" {})})

(defn form-page-submission [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/http/submitted_page.html" (parse-form-data request))})

(defroutes routes
  (GET  "/"       [] form-page)
  (POST "/submit" [] form-page-submission))
