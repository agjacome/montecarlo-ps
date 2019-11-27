(ns montecarlo-ps.endpoints.form
  (:require [compojure.core :refer [GET, POST, defroutes]]
            [selmer.parser :refer [render-file]]
            [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clj-time.format :as f]
            [clj-time.coerce :as c]))


(defn get-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (render-file "montecarlo_ps/pages/form.html" {})})

(defn read-column [filename column-index]
  (with-open [reader (io/reader filename)]
    (let [data (csv/read-csv reader)]
      (map #(nth % column-index) data))))

(defn post-handler [request]
  (let [start-date  (-> request :params :startDate)
        csv-content (-> request :params :csv :tempfile slurp csv/read-csv
                        ;;(read-column 1)
                        (nth 2)
                        (get 2)
                        ;c/from-string
                        ;(f/formatter "dd/MM/yyyy hh:mm:ss")
                        pr-str)]
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    (render-file "montecarlo_ps/pages/results.html" {:content csv-content :startDate start-date})}))

(defroutes routes
  (GET "/" [] get-handler)
  (POST "/" [] post-handler))
