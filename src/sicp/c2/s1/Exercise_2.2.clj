; Exercise 2.2
; Consider the problem of representing line segments in a plane. Each segment
; is represented as a pair of points: a starting point and an ending point.
; Define a constructor make-segment and selectors start-segment and end-segment
; that define the representation of segments in terms of points. Furthermore, a
; point can be represented as a pair of numbers: the x coordinate and the y
; coordinate. Accordingly, specify a constructor make-point and selectors
; x-point and y-point that define this representation. Finally, using your
; selectors and constructors, define a procedure midpoint-segment that takes a
; line segment as argument and returns its midpoint (the point whose coordinates
; are the average of the coordinates of the endpoints). 

(defn make-point [x y]
  (list x y))

(defn x-point [point]
  (first point))

; In clojure ther is no cdr, so I use nth function
; instead of rest rest returns a sequence
(defn y-point [point]
  (nth point 1))

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

; To try your procedures,
; you’ll need a way to print points:

(defn print-point [p]
  (print "(" (x-point p) "," (y-point p) ")"))

(def s (make-segment (make-point 0 0) (make-point 1.0 1.0)))

(print-point (mid-point s))
