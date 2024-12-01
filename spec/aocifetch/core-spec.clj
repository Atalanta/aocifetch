(ns aocifetch.core-spec
  (:require [speclj.core :refer :all]
            [aocifetch.core :as ifetch]
            [clj-http.client :as http]))

(describe  "AoCifetch"
           (it "returns puzzle input for a given year and day"
               (with-redefs [http/get (fn [ _ _ ] {:status 200 :body "Here is some puzzle input"})]
                 (should= "Here is some puzzle input"
                          (ifetch/fetch-input 2024 1)))))
