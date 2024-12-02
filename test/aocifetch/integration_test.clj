(ns aocifetch.integration-test
  (:gen-class)
  (:require [clojure.test :refer [deftest is]]
            [aocifetch.core :as ifetch]))

(defn -main [& _]
  (clojure.test/run-tests 'aocifetch.integration-test))

(deftest test-2022-4-gives-camp-cleanup-section-assignment-pairs
  (let [input (ifetch/fetch-input "2022" "4")
        section-assignment-pair #"\d{1,2}-\d{1,2}"]
    (is (re-find section-assignment-pair input))))
