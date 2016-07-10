; Exercise 2.56: Show how to extend the basic differentiator to handle more
; kinds of expressions. For instance, implement the differentiation rule
;
;    n      n-1
; d(u ) = nu    du
;  dx           dx
; 
; by adding a new clause to the deriv program and defining appropriate
; procedures exponentiation?, base, exponent, and make-exponentiation. 
; (You may use the symbol ** to denote exponentiation.) Build in the rules
; that anything raised to the power 0 is 1 and anything raised to the power
; 1 is the thing itself.
 
(defn exponentiation? [x]
  (if (and (list? x) (= (count x) 3))
    (= (first x) '**)
    false))

(defn base [exponent]
  (second exponent))

(defn exponent [exponent]
  (nth exponent 2))

(defn make-exponentiation [base exponent]
  (cond (= exponent 0) 1
        (= exponent 1) base
        (and (number? base) (number? exponent)) (Math/pow base exponent)
        :else (list '** base exponent)))

(defn deriv [exp var]
  (cond (constant? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum
                         (make-product (multiplier exp)
                                       (deriv (multiplicand exp) var))
                         (make-product (deriv (multiplier exp) var)
                                       (multiplicand exp)))
        (exponentiation? exp) (make-product
                                (make-product (exponent expr)
                                              (make-exponentiation (base expr)
                                                                   (make-sum (exponent expr) -1)))
                                (deriv (base exp) var))))


