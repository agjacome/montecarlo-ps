(defproject montecarlo-ps :project/git-ref-short
  :plugins [[me.arrdem/lein-git-version "2.0.8"]]

  :description "Montecarlo estimation project"
  :license {:name "MIT" :url "https://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.10.0"]]

  :main montecarlo-ps.core)
