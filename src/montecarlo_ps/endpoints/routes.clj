(ns montecarlo-ps.endpoints.routes
  (:require [compojure.core :refer [context, defroutes]]
            [compojure.route :refer [not-found]]
            [montecarlo-ps.endpoints.form :as form]))

(defroutes routes
  (context "/" [] form/routes)
  (not-found "not found"))
