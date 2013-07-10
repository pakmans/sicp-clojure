(ns sicp.2.2.3_SequencesSsConventionalInterfaces)

; Clojure defines filter for the exact same functionality
(defn myfilter [predicate items]
  (cond (empty? items) nil
        (predicate (first items))  (cons (first items) (myfilter predicate (rest items)))
        :else (myfilter predicate (rest items))))


(defn accumulate [op initial items]
  (if (empty? items) initial
  (op (first items) (accumulate op initial (rest items)))))



(defn enumerate-interval [low high]
  (if (> low high) nil
    (cons low (enumerate-interval (+ low 1) high))))

; Of course, Clojure has range