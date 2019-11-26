(ns montecarlo-ps.endpoints.form-test
  (:require [midje.sweet :refer :all]
            [selmer.parser :refer [render-file]]
            [clojure.java.io :as io]
            [montecarlo-ps.endpoints.form :as form]))

(facts "about `form/get-handler`"
       (fact "it always returns an OK response"
             (let [response (form/get-handler {})]
               (:status  response) => 200
               (:headers response) => {"Content-Type" "text/html"}
               (:body    response) => (render-file "montecarlo_ps/pages/form.html" {}))))

(facts "about `form/post-handler`"
       (fact "it returns an OK response if the request contains the expected fields"
             (let [csv-file (io/resource "montecarlo_ps/example.csv")
                   request  {:params {"startDate" "test" "csv" {:tempfile csv-file}}}
                   response (form/post-handler request)]
               (:status  response) => 200
               (:headers response) => {"Content-Type" "text/html"}
               (:body    response) => (str "<h1>Start date: test</h1>\n<div>CSV FILE:<br>" (slurp csv-file) "</div>"))))
