(ns montecarlo-ps.endpoints.form-test
  (:require [midje.sweet :refer :all]
            [selmer.parser :refer [render-file]]
            [montecarlo-ps.endpoints.form :as form]))

(facts "about `form/get-handler`"
       (fact "it always returns an OK response"
             (let [response (form/get-handler {})]
               (:status response) => 200
               (:headers response) => {"Content-Type" "text/html"}
               (:body response) => (render-file "montecarlo_ps/pages/form.html" {}))))

(facts "about `form/post-handler`"
       (fact "it returns an OK response if the body contains a `startDate` value and the content of the csv"
             (let [response (form/post-handler {:body "startDate=test"})]
               (:status response) => 200
               (:headers response) => {"Content-Type" "text/html"}
               (:body response) => "<h1>Start date: test</h1>")))
