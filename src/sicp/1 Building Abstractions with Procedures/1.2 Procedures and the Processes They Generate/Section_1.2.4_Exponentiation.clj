; bⁿ

; Recursive version:
; bⁿ=b⋅bⁿ⁻¹,
; b°=1
(defn expt [b n]
  (if (= n 0)
      1
      (* b (expt b (- n 1)))))

; Iterative version:
; O(n) O(1)
(defn expt-iter [b counter product]
  (if (= counter 0)
      product
      (expt-iter b
                (- counter 1)
                (* b product))))

(defn expt [b n]
  (expt-iter b n 1))

; Optimized recursive version:
(defn square [x] (* x x))

(defn fast-expt [b n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))

;; even? is part of clojure standard library

