(ns aocifetch.core
  (:require [clj-http.client]
            ))
(defn get-cookie []
  (System/getenv "AOC_SESSION_COOKIE"))

(defn generate-url [year day]
  (str "https://adventofcode.com/" year "/day/" day "/input"))

(defn generate-options []
  {:headers {"Cookie" (str "session=" (get-cookie))}})

(defn fetch-input [year day]
  (let [response (clj-http.client/get (generate-url year day) (generate-options))]
    (:body response)))
