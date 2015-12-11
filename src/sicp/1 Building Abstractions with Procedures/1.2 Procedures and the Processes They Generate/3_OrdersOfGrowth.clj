(ns sicp.1.2.3-OrdersOfGrowth)

; Exercise 1.14
;                                     (cc 11 5)
;                        (cc 11 4)               (cc -39 5)
;                 (cc 11 3)      (cc -14 4)            0
;          (cc 11 2)   (cc 1 1)       0
;    (cc 11 1)                             (cc 11 6)  (cc 11 0) (cc 1)
;(cc 11 0)                  +                (cc 10 1)
;   0   (cc 10 0)  (cc 9 1)       +      (cc 10 0)  (cc 9 1)
;          0     (cc 9 0) (cc 8 1)           0   (cc 9 0) (cc 8 1) 
;                     0  (cc 8 0) (cc 7 1)           0  (cc 8 0) (cc 7 1)
;                           0  (cc 7 0) (cc 6 1)
;                                  0  (cc 6 0) (cc 5 1)
;                                         0 (cc 5 0) (cc 4 1)
;                                               0   (cc 4 0) (cc 3 1)
;                                                       0 (cc 3 0) (cc 2 1) 
;                                                             0  (cc 2 0) (cc 1 1)
;                                                                    0  (cc 1 0) (cc 0 1)
;                                                                           0        0



; Exercise 1.15
(defn cube [x] 
  (* x x x))