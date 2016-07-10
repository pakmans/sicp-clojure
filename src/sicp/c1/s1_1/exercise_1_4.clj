;; Exercise 1.4: Observe that our model of evaluation allows
;; for combinations whose operators are compound expres-
;; sions. Use this observation to describe the behavior of the
;; following procedure:

(defn a-plus-abs-b [a b] 
  ((if (> b 0) + -) a b)) 

(a-plus-abs-b 5 -4)
;; ((if (> -4 0) + -) 5 -4) 
;; ((if (false) + -) 5 -4)
;; (- 5 -4)
;; 9

(a-plus-abs-b 5 4)
;; ((if (> 4 0) + -) 5 4) 
;; ((if (true) + -) 5 4)
;; (+ 5 4)
;; 9
