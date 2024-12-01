(ns aocifetch.core-spec
  (:require [speclj.core :refer :all]
            [aocifetch.core :as ifetch]
            [clj-http.client :as http]))

(describe "AoCifetch"
  (context "when the session cookie is set"
    (before
      (System/setProperty "AOC_SESSION_COOKIE" "valid-session-cookie"))
    
    (it "returns puzzle input for a given year and day"
      (with-redefs [http/get (fn [_ _] {:status 200 :body "Here is some puzzle input"})]
        (should= "Here is some puzzle input"
                 (ifetch/fetch-input 2024 1)))))
  (context "when no session cookie is set"
           (before
            (System/clearProperty "AOC_SESSION_COOKIE"))
           (it "complains about missing cookie"
               (should-throw Exception "No session cookie found - set AOC_SESSION_COOKIE"
                             (ifetch/fetch-input 2024 1)))))

