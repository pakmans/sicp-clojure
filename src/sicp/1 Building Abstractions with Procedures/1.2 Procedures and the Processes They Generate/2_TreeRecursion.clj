(ns sicp.1.2.2)

; Lecture 1b
; Compute the fibonacci series up to the nth element
; Simple, but inneficient algorithm
; time -> O(fib(n))
; size -> O(n)
(defn fib-rec [n]
  (if (< n 2)
    n
    (+ (fib-rec (- n 1)) 
       (fib-rec (- n 2)) )))


; Iterative version
(defn fib-iter [n]
  (defn fib-iter-aux[a b count]
  (if (= count 0) 
    b
    (fib-iter-aux (+ a b) a (- count 1))))
  (fib-iter-aux 1 0 n))

; Clojure idiomatic version
(defn fib-iter2 [n]
  (loop [a 1, b 0, count n]
    (if (= count 0) 
      b
    (recur (+ a b) a (- count 1)))))

; Counting Change Example
; In order to notice how long it can take use (count-change 1000)
; instead of (count-change 100) as it is in the book.
(defn first-denomination [coin-index]
  (cond
    (= coin-index 1) 1
    (= coin-index 2) 5
    (= coin-index 3) 10
    (= coin-index 4) 25
    (= coin-index 5) 50)  
  )

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount (- kinds-of-coins 1))
             (cc (- amount (first-denomination kinds-of-coins))
                 kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))

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
; f(0) = 3
; f(1) = 3
; f(2) = 3
; f(3) = 3 + 2*(3) + 3*(3) = 18
(defn f-iter [n]
  (loop [a 3, b 3, c 3, count n]
    (if (= count 0) 
      c
    (recur (+ a 
              (* 2 b)
              (* 3 c))
           a b (- count 1)))))




; Exercise 1.12 Pascal's Triangle
; Simple, but TERRIBLY inneficient recursive implementation:
; 
(defn pascal-element [row col]
    (cond (or (= col 1) (= col row)) 1
          :else (+ (pascal-element (- row 1) (- col 1))
                   (pascal-element (- row 1) col))))

(defn pascal-rec [r]
  (loop [row 1, col 1]
    (if (<= row r)
      (if (<= col row)
        (do (print (pascal-element row col)) 
            (recur row (+ col 1)))
        (do (println) 
            (recur (+ row 1) 1))))))

; For each element of the triangle, something like this happens:
;        (p 5 2)
;          /  \
;   (p 4 1)   (p 4 2)
;      1        /  \
;          (p 3 1)  (p 3 2)
;              1      /  \
;                (p 2 1)  (p 2 2)
;                   1       /  \
;                    (p 1 1)   (p 1 1)
;                       1         1

