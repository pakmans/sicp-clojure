; 1.3.1 Procedures as Arguments
;SICP Video Lecture 2a

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

; sum-pi
; Not very idiomatic, but following the book
(defn pi-sum [a b] 
  (defn pi-term [x] (/ 1.0 (* x (+ x 2))))
  (defn pi-next [x] (+ x 4))
  (sum pi-term a pi-next b))

(* 8 (pi-sum 1 1000))
; 3.139592655589783


; Integral aproximation
(defn integral [f a b dx]
  (defn add-dx [x] (+ x dx))
  (* dx (sum f (+ a (/ dx 2.0)) add-dx b)))

(defn cube [x] (* x x x))

(integral cube 0 1 0.01)
; 0.24998750000000042


