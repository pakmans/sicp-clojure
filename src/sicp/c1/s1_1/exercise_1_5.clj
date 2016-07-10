;; Exercise 1.5: Ben Bitdiddle has invented a test to determine
;; whether the interpreter he is faced with is using applicative-
;; order evaluation or normal-order evaluation. He defines the
;; following two procedures:

(defn p [] (p)) ;; <- Infinite recursion

(defn test [x y]
  (if (= x 0) 0 y))

;; Then he evaluates the expression

(test 0 (p))
;; StackOverflowError

;; What behavior will Ben observe with an interpreter that uses 
;; applicative-order evaluation? What behavior will he observe with an 
;; interpreter that uses normal-order evaluation? 
;; Explain your answer. (Assume that the evaluation rule for the special form 
;; if is the same whether the interpreter is using normal or applicative order:
;; The predicate expression is evaluated first, and the result determines
;; whether to evaluate the consequent or the alternative expression.)

;; Answer 1 (wrong, becuase of the assumption in parenthesis):
;; The interpreter uses the applicative order evaluation, since it tries to
;; evaluate all the operands first which causes an infinite recursion in (p). 
;; If the interpreter used a normal-order evaluation, (p) would never be 
;; invoked since the condition (= x 0) would return 0 without needing to 
;; evaluate (p).


;; Answer 2:
;; In normal-order evaluation (p) would be handed to test unevaluated.
;; Since the assumption assumption specified regarding the if special form
;; the function would return 0;
;;
;; In applcative-order evaluation (p) would be evaluated before the evaluation
;; of test in order to hand test a value.  Since p has an infinite recursion,
;; a StackOverflowError is thrown.