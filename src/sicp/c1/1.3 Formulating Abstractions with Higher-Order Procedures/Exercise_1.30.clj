; Exercise 1.30
; The sum procedure above generates a linear recursion. The procedure can be 
; rewritten so that the sum is performed iteratively. Show how to do this by 
; filling in the missing expressions in the following definition:
;
;(defn sum [term a next b]
;  (defn iter [a result]
;   (if ⟨??⟩
;       ⟨??⟩
;       (iter ⟨??⟩ ⟨??⟩)))
;  (iter ⟨??⟩ ⟨??⟩))

; Recursive process
(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) (sum term (next a) next b))))
  
(sum (fn[x] x) 0 (fn[x] (+ x 1)) 10)

; Iterative process
(defn sum [term a next b]
  (defn iter [a result]
    (if (> a b) result
        (recur (next a) (+ result (term a) ) )))
  (iter a 0 ))

(sum (fn[x] x) 0 (fn[x] (+ x 1)) 10)

