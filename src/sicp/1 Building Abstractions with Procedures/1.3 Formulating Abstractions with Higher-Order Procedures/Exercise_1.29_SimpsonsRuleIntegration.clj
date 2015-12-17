; Exercise 1.29
; Define a procedure that takes as arguments f, a, b, and n and returns the 
; value of the integral, computed using Simpson’s Rule. Use your procedure to 
; integrate cube between 0 and 1 (with n=100 and n=1000), and compare the 
; results to those of the integral procedure shown above.

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) 
       (sum term (next a) next b))))

(defn simpson-int [f a b n]
  (def h (/ (- b a) n))
  (defn simp-next [x] (+ x h))
  (* (/ h 3.0) (+ (sum (* 4 f) (+ a h) simp-next b) (sum (* 2 f) (+ a (* 2 h)) simp-next b ))))

; Remember that we haven't been introduced to let or any other construct that
; might make the definition more idiomatic or elegant.
(defn simpson-int [f a b n]
  (def h (/ (- b a) n))
  (defn trm [k]
    (def y (f (+ a (* k h))))
    (cond
      (or (= 0 k) (= n k)) y
      (odd? k) (* 4.0 y)
      :else (* 2.0 y)))
  (* (/ h 3) (sum trm 0 inc n)))


(defn cube [x] (* x x x))

(simpson-int cube 0 1 100)
; 0.2499999999999999

(simpson-int cube 0 1 1000)
; 0.2500000000000002