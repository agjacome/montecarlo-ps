(ns montecarlo-ps.http.hello-world-test
  (:use midje.sweet)
  (:require [montecarlo-ps.http.hello-world :as hello-world]))

(defn- request
  ([]            (request :get   "/"))
  ([method]      (request method "/"))
  ([method path] {:request-method method :uri path}))

(facts "about `hello-world/get-handler`"

  (fact "it always returns an OK response"
    (let [response (hello-world/get-handler request)]
      (:status  response) => 200
      (:headers response) => {"Content-Type" "text/html"}
      (:body    response) => "<h1>Hello World!</h1>")))

(facts "about `hello-world/routes`"

  (fact "correctly handles GET requests to the root path"
    (hello-world/routes (request :get "/")) => (contains {:status anything}))

  (fact "does not handle non-GET requests to the root path"
    (hello-world/routes (request :post  )) => falsey
    (hello-world/routes (request :put   )) => falsey 
    (hello-world/routes (request :patch )) => falsey 
    (hello-world/routes (request :delete)) => falsey)

  (fact "does not handle GET requests to non-root paths"
    (hello-world/routes (request :get "/asd"       )) => falsey
    (hello-world/routes (request :get "/test"      )) => falsey
    (hello-world/routes (request :get "/test2/test")) => falsey
    (hello-world/routes (request :get "/whatever/" )) => falsey))
