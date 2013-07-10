(ns sicp.1_3_1)

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) 
       (sum term (next a) next b))))

(defn cube [x] (* x x x))

(defn integral [f a b dx]
  (defn add-dx [x] (+ x dx))
  (* (sum f (+ a (/ dx 2)) add-dx b)
     dx))


; Exercise 1.29 - a
; Simpson's Rule Integral
; Notice that we get exact result with just 2 iterations
; for the cube function
(defn integral-simp [f a b n]
  (def h (/ (- b a) n) )
  (defn y-term [k]
    (* (cond 
         (= k 0) 1
         (= k n) 1
         (odd? k) 4
         (even? k) 2)
       (f (+ a (* k h)))))
  (* (/ h 3)
     (sum y-term 0 (fn [x] (+ x 1)) n)))

; Exercise 1.29 - b
; A more idiomatic version of Simpson's Rule Integral
(defn integral-simp2 [f a b n]
  (let [h (/ (- b a) n)]
  (defn y-term [k]
    (* (cond 
         (or (= k 0) (= k n)) 1
         (odd? k) 4
         :else 2)
       (f (+ a (* k h)))))
  (* (/ h 3)
     (sum y-term 0 (fn [x] (+ x 1)) n))))

; Exercise 1.30
; Iterative version of the sum procedure
(defn sum-iter [term a next b]
  (defn iter [a result]
    (if (> a b) result
        (recur (next a) (+ result (term a) ) )))
  (iter a 0 ))




