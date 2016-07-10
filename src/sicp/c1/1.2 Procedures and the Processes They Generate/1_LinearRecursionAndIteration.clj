(ns sicp.1.2.1)

; 1.2.1 Linear Recursion and Iteration

; Factorial recursive version
(defn factorial-rec [n]
  (if (= n 1)
    1
    (* n (factorial-rec (- n 1)) )))

; Factorial iterative version
; In clojure this is not really iterative
; since the JVM doesn't hav tail call optimization
(defn factorial-iter [n]
        (defn aux [product counter max-count]
          (if (> counter max-count)
            product
            (aux (* counter product) (+ counter 1) max-count)))
        (aux 1 1 n))

; Clojure's version of an iterarive process
; notice the recur special form instead of
; directly calling aux
(defn factorial-iter2 [n]
        (defn aux [product counter max-count]
          (if (> counter max-count)
            product
            (recur (* counter product) (+ counter 1) max-count)))
        (aux2 1 1 n))

; This is probably a more idiomatic version for Clojure.
; In this case we don't have to define an intermediate
; function, but rather use the special form loop
(defn factorial-iter3 [n]
        (loop [product 1 counter 1]
          (if (> counter n)
            product
            (recur (* counter product) (+ counter 1)))))


; Peano Arithmetic
; Two ways to add whole Numbers in terms of 
; increments and decrements

; First version
; Iteration:
; time -> O(x)
; size -> O(1)
(defn plus-iter [x y]
  (if (= x 0)
    y
    (plus-iter (dec x) (inc y))))

; Second version
; Recursive (Linear):
; time -> O(x)
; size -> O(x)
(defn plus-rec [x y]
  (if (= x 0)
    y
    (inc (plus-rec (dec x) y))))


; Aren't both recursive? they both call themself.
; What is exactly the differenc between recursion and iteration. See excellent explanation in section 1.2.1


