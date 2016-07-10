; Exercise 1.17
; Suppose we include, together with addition, operations double, which doubles 
; an integer, and halve, which divides an (even) integer by 2. 
; Using these, design a multiplication procedure analogous to fast-expt that 
; uses a logarithmic number of steps.

; a*b = 2*a*b/2          for b even
; a*b = 2*a*(b-1)/2 + b  for b odd


(defn dbl [x] (* 2 x))

(defn halve [x] (/ x 2)) 

(defn mul [a b]
  (cond (= b 0) 0
        (even? b) (dbl (mul a (halve b)))
        :else (+ a (mul a (- b 1)))))

; Tests:
(mul 4 3)
(mul 4 4)
(mul 4 1)
(mul 5 0)

