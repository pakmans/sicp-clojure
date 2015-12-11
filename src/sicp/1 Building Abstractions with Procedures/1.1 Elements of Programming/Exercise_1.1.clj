;; Excercise 1.1

10
;; 10

(+ 5 3 4) 
;; 12

(- 9 1)
;; 8

(/ 6 2)
;; 3

(+ (* 2 4) (- 4 6))
;; 6

(def a 3)
(def b (+ a 1)) ;; a = 3, b = 4
(+ a b (* a b)) 
;; (+ 3 4 (* 3 4)
;; (+ 3 4 12)
;; 19

(= a b)
;; false

;;         true    12 (true)
(if (and (> b a) (< b (* a b)))
    b
    a)
;; ans: 4

(cond (= a 4) 6             ;; false
      (= b 4) (+ 6 7 a)     ;; true
      :else 25)
;; 16

(+ 2 (if (> b a) b a))
;; (+ 2 b)
;; (+ 2 4)
;; 6

(* (cond (> a b) a    ;; false
         (< a b) b    ;; true
         :else -1)
   (+ a 1))
;; (* (cond (false) 3
;;          (true) 4
;;          : else -1)
;;    (+ 3 1)
;;
;; (* 4 4)
;;
;; 16