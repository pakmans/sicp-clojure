(ns sicp.2.2.2_HierarchichalStructures)

(def a (cons (list 1 2) (list 3 4)))
;     /\\
;    /  \\
;   /\   \\
;  1  2   34
(defn count-leaves[x]
  (cond (not (coll? x)) 1
        (empty? x) 0
        :else (+ (count-leaves (first x))
                 (count-leaves (rest x)))))

(count-leaves a)


; Exercise 2.24.  Suppose we evaluate the expression (list 1 (list 2 (list 3 4))). Give the
; result printed by the interpreter, the corresponding box-and-pointer structure, and the 
; interpretation of this as a tree

;      (1 (2 (3 4)))
;          /\
;         /  \ (2 (3 4))
;        1   /\ 
;           /  \ (3 4)
;          2   /\
;             /  \ 
;            3    4


;                 __ __
;  (1 (2 (3 4))) |__|__|
;                 |    \__  __ (2 (3 4))
;                 1    |__||__|
;                       |     \__  __  (3 4)
;                       2     |__||__|
;                              |     \__  __
;                              3     |__||__|
;                                     |   |
;                                     4   nil

; Exercise 2.25.  Give combinations of cars and cdrs that will pick 7 from each of the
; following lists:

; (1 3 (5 7) 9)

(def a '(1 3 (5 7) 9))
(rest (first (rest (rest a))))

; ((7))
(def b '((7)))
(first (first b))

; (1 (2 (3 (4 (5 (6 7))))))
(def c '(1 (2 (3 (4 (5 (6 7)))))))
(first (rest (first (rest (first (rest (first (rest (first (rest (first (rest c))))))))))))

; Exercise 2.26.  Suppose we define x and y to be two lists:

(def x (list 1 2 3))
(def y (list 4 5 6))

; (append x y)
; There is no append in clojure

(cons x y)
; ((1 2 3) 4 5 6)

(list x y)
; ((1 2 3) (4 5 6))
