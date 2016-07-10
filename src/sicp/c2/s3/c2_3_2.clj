;(ns sicp.c2.s3.ss2-symbolic-differentiation)

(defn constant? [ x ] (number? x))

(defn variable? [x] (symbol? x))

(defn same-variable? [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (= v1 v2)))

; (defn make-sum [a1 a2] (list '+ a1 a2))

(defn make-sum [a1 a2] 
  (cond (and (number? a1) (number? a2)) (+ a1 a2)
        (= a1 0) a2
        (= a2 0) a1
        :else (list '+ a1 a2) ))

;(defn make-product [a1 a2] (list '* a1 a2))

(defn make-product [m1 m2]
  (cond (and (number? m1) (number? m2)) (* m1 m2)
        (= m1 1) m2
        (= m2 1) m1
        (or (= m1 0) (= m2 0)) 0
        :else (list '* m1 m2)))

(defn sum? [x]
  (if (coll? x)
    (= (first x) '+)
    false))

(defn addend [s] (second s))

(defn augend [s] (nth s 2))

(defn product? [x] 
  (if (coll? x)
    (= (first x) '*)
    false))

(defn multiplier [p] (second p))

(defn multiplicand [p] (nth p 2))

(defn deriv [exp var]
  (cond (constant? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum
                         (make-product (multiplier exp)
                                       (deriv (multiplicand exp) var))
                         (make-product (deriv (multiplier exp) var)
                                       (multiplicand exp)))))



;;;; Example of use

(deriv 1 'x)
; 0

(deriv '(+ x 3) 'x)
; 1

(deriv '(* x y) 'x)
; y


(deriv '(* (* x y) (+ x 3)) 'x)
; (+ (* x y) (* y (+ x 3)))
