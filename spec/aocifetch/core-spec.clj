(ns aocifetch.core-spec
  (:require [speclj.core :refer :all]
            [aocifetch.core :as ifetch]
            [clj-http.client]
            ))

(describe "AoCifetch"
          (context "when given a year and day"
                   (it "constructs an input URL for that year amd day"
                       (should= "https://adventofcode.com/2024/day/1/input"
                                (ifetch/generate-url "2024" "1"))))
          (context "when the AOC_SESSION_COOKIE is set"
                   (it "includes the cookie in the HTTP options"
                       (with-redefs [ifetch/get-cookie (fn [] "areallydeliciouscookie")]
                         (should= {:headers {"Cookie" "session=areallydeliciouscookie"}}
                                  (ifetch/generate-options))))
                   (it "fetches the puzzle body from the advent of code website"
                       (with-redefs [ifetch/get-cookie (fn [] "areallydeliciouscookie")
                                     clj-http.client/get (fn [_ _] {:body "Here is your puzzle input!"})]
                         (should= "Here is your puzzle input!"
                                  (ifetch/fetch-input "2024" "1"))
                         ))))
