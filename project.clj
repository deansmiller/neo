(defproject neo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
  				[clojurewerkz/neocons "3.1.0-beta3"]
  				[org.clojure/tools.namespace "0.2.11"]]
  :main ^:skip-aot neo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
