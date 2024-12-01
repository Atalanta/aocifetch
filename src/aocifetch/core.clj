(ns aocifetch.core
  (:require [clj-http.client :as http]))

(defn fetch-input [year day]
  (let [response (http/get "https://adventofcode.com/2024/1/input")]
    (:body response)))
