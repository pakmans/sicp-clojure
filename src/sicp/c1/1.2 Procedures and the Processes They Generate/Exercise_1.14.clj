;; Exercise 1.14: Draw the tree illustrating the process generated by the 
;; count-change procedure of 1.2.2 in making change for 11 cents. What are the 
;; orders of growth of the space and number of steps used by this process as 
;; the amount to be changed increases?

; Counting Change Example
; In order to notice how long it can take use (count-change 1000)
; instead of (count-change 100) as it is in the book.
(defn first-denomination [coin-index]
  (cond
    (= coin-index 1) 1
    (= coin-index 2) 5
    (= coin-index 3) 10
    (= coin-index 4) 25
    (= coin-index 5) 50)  
  )

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount (- kinds-of-coins 1))
             (cc (- amount (first-denomination kinds-of-coins))
                 kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))


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
