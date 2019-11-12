(defproject montecarlo-ps :project/git-ref-short
  :description "Montecarlo estimation project"
  :url "https://github.com/agjacome/montecarlo-ps/"
  :license {:name "MIT" :url "https://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.10.1" ]
                 [compojure           "1.6.1"  ]
                 [environ             "1.1.0"  ]
                 [http-kit            "2.3.0"  ]
                 [selmer              "1.12.17"]]

  :profiles {:dev {:dependencies [[midje "1.9.9" :exclusions [org.clojure/clojure commons-codec]]]}}

  :plugins [[jonase/eastwood            "0.3.5" ]
            [lein-ancient               "0.6.15"]
            [lein-cljfmt                "0.6.5" ]
            [lein-midje                 "3.2.1" ]
            [me.arrdem/lein-git-version "2.0.8" ]]

  :eastwood {:add-linters [:unused-fn-args :unused-locals :unused-namespaces :unused-private-vars]
             :only-modified true}

  :aliases {"format" ["cljfmt" "fix"]
            "lint"   ["eastwood"]
            "test"   ["do" ["format"] ["lint"] ["midje"]]}

  :main montecarlo-ps.main)
