(ns sicp.1.2.4_Exponentiation)

; Simple exponentiation function
(defn expt-1 [b n]
  (if (= n 0)
      1
      (* b (expt b (- n 1)))))

; Linear recursive version:
; O(n) O(1)
(defn expt-iter [b counter product]
  (if (= counter 0)
      product
      (expt-iter b
                (- counter 1)
                (* b product))))

(defn expt-2 [b n]
  (expt-iter b n 1))

; Optimized linear recursive version:
(defn square [x] (* x x))
(defn fast-expt [b n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))


