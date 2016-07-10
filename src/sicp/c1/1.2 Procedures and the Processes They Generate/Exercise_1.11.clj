;; Exercise 1.11
;; A function f is defined by the rule that 
;; f(n)=n if n<3 and f(n)=f(n−1)+2f(n−2)+3f(n−3) if n≥3.
;; Write a procedure that computes f by means of a recursive process. 
;; Write a procedure that computes f by means of an iterative process.

; Exercise 1.11 - a
; f(n) = n if n<3 
; and 
; f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n> 3
; Recursive version
(defn f-rec [n]
  (if (< n 3)
    n
    (+ (f-rec (- n 1)) 
       (* 2 (f-rec (- n 2))) 
       (* 3 (f-rec (- n 3)))) ))

; Exercise 1.11 - b
; f(n) = n if n<3 
; and
; f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>=3
; Iterative version
; f(0) = 0
; f(1) = 1
; f(2) = 2
; f(3) = 2 + 2*1 + 3*0 = 4        
; f(4) = 4 + 2*2 + 3*1 = 11
(defn f-iter [n]
  (loop [a 2, b 1, c 0, count n]
    (if (= count 0)
      c
    (recur (+ a
              (* 2 b)
              (* 3 c))
           a b
           (- count 1)))))