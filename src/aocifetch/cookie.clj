(ns aocifetch.cookie)

(defn getenv [key]
  (System/getenv key))

(defn fetch-cookie []
  (getenv "AOC_SESSION_COOKIE"))
