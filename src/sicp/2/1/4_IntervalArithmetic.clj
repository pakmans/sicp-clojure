(ns sicp.2.1.4_IntervalArithmetic)


; Exercise 2.7.  Alyssa's program is incomplete because she has not 
;specified the implementation of the interval abstraction. Here is a 
;definition of the interval constructor:

(defn make-interval [l u] (list l u))

(defn lower-bound [x]
  (first x))

(defn upper-bound [x]
  (last x))

(defn add-interval [x y]
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))

(defn mul-interval [x y]
  (let [p1 (* (lower-bound x) (lower-bound y))
        p2 (* (lower-bound x) (upper-bound y))
        p3 (* (upper-bound x) (lower-bound y))
        p4 (* (upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (mul-interval x 
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y)))))

; Exercise 2.8.  Using reasoning analogous to Alyssa's, describe how the 
; difference of two intervals may be computed. Define a corresponding 
; subtraction procedure, called sub-interval.

(defun sub-interval [x y]
  (make-interval
    (- (lower-bound x) (upper-bound y))
    (- (upper-bound x) (lower-bound y))))
