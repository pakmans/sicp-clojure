(ns sicp.lec2a)

;SICP Lecture 2a

; 1.3.1 Procedures as Arguments

; Sum of integers from a to b
(defn sum-int [a b]
  (if (> a b)
    0
    (+ a 
       (sum-int (inc a) b))))

; Sum of squares from a to b
(defn sum-sq [a b]
  (if (> a b)
    0
    (+ (* a a)
       (sum-sq (inc a) b))))

; pi/8 aproximation as the sum of 1/(x*(x+2))
; from a=1 to b=n
(defn pi-sum [a b] 
  (if (> a b)
    0
    (+ (/ 1.0 (* a (+ a 2) ))
       (pi-sum (+ a 4) b) )))

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) 
       (sum term (next a) next b))))

;sum-int:
(sum (fn[x] x) 0 (fn [x] (inc x)) 10)

; sum-sq:
(sum (fn[x] (* x x)) 0 (fn [x] (inc x)) 10)