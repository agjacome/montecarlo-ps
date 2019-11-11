(ns montecarlo-ps.http.monte-carlo-test
  (:use midje.sweet)
  (:require [montecarlo-ps.http.monte-carlo :as monte-carlo]
            [selmer.parser :refer [render-file]]))

(defn- request
  ([]                 (request :get "/" ""))
  ([method]           (request method "/" ""))
  ([method path]      (request method path ""))
  ([method path body] {:request-method method :uri path :body body}))

(facts "about `monte-carlo/form-page`"
   (fact "it always returns an OK response"
       (let [response (monte-carlo/form-page request)]
          (:status response)  => 200
          (:headers response) => {"Content-Type" "text/html"}
          (:body response)    => (render-file "montecarlo_ps/http/form.html" {}))))


(facts "about `monte-carlo/submit`"
   (fact "it returns the correct html"
       (let [response (monte-carlo/form-page-submission (request :post "/submit" "startDate=wefwef"))]
           (:status response)  => 200
           (:headers response) => {"Content-Type" "text/html"}
           (:body response)    => "<h1>Start date: wefwef</h1>")))