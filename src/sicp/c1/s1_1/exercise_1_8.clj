(ns sicp-clojure.ch1.s1-1.exercise-1-8)
;; Exercise 1.8.
;; Newton's method for cube roots is based on the fact that if y is an 
;; approximation to the cube root of x, then a better approximation is given 
;; by the value (/ (+ (/ x (sqr y)) (* 2 y)) 3)
;; Use this formula to implement a cube-root procedure analogous to the 
;; square-root procedure.

(defn abs [x]
  (if (> x 0)
    x
    (- x)))

(defn cube [x]
  (* x x x))

(defn square [x]
  (* x x))

(defn improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn good-enough? [guess x]
  (< (abs (- (cube guess) x)) 0.1))

(defn cube-root-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cube-root-iter (improve guess x) x)))

(defn cube-root [x]
  (cube-root-iter 1.0 x))
