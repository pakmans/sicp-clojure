(ns sicp.2.1.2_AbstractionBarriers)

; Exercise 2.2

(defn make-point [x y]
  (list x y))

(defn x-point [point]
  (first point))

; In clojure ther is no cdr, so I use nth function
; instead of rest rest returns a sequence
(defn y-point [point]
  (nth point 1))

(defn print-point [p]
  (print "(" (x-point p) "," (y-point p) ")")
)

(defn make-segment [p1 p2]
  (list p1 p2))

(defn start-segment [s]
  (first s))

(defn end-segment [s]
  (last s))

(defn mid-point [s]
  (make-point
  (/ (- (x-point (end-segment s))
     (x-point (start-segment s))) 2)
  (/ (- (y-point (end-segment s))
     (y-point (start-segment s))) 2)))

(def m (mid-point s))

(print-point m)
