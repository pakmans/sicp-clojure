; Exercise 1.10 The following procedure computes a mathematical function 
;; called Ackermann's function.

(defn A [x y]
  (cond 
    (= y 0) 0
    (= x 0) (* 2 y)
    (= y 1) 2
    :else (A (- x 1) (A x (- y 1))) ))

(A 1 10)
; 1024

(A 2 4)
; 65536

(A 3 3)
; 65536

; Substitution model expansion:
; (A 1 10)
; (A 0 (A 1 9))
; (* 2 (A 0 (A 1 8)))
; (* 2 (* 2 (A 0 (A 1 7))))
; (* 2 (* 2 (* 2 (A 0 (A 1 6)))))
; (* 2 (* 2 (* 2 (* 2 (A 0 (A 1 5))))))
; (* 2 (* 2 (* 2 (* 2 (* 2 (A 0 (A 1 4)))))))
; (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (A 0 (A 1 3))))))))
; (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (A 0 (A 1 2)))))))))
; (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (A 0 (A 1 1))))))))))
; (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 (* 2 2)))))))))

; f = 2n
(defn f[n] (A 0 n))

; f = 2ⁿ(for n > 0)
(defn g[n] (A 1 n))

;
(defn h[n](A 2 n))

; 5n²
(defn k [n] (* 5 n n))
