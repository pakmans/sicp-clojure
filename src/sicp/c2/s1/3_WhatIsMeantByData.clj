(ns sicp.2.1.3_WhatIsMeantByData)

; Excercise 2.4

(defn my-cons [x y]
  (fn [m] (m x y)))

(defn my-car [z]
  (z (fn [p q] p)))

(defn my-cdr [z]
  (z (fn [p q] q)))

; (def z (my-cons 3 9))
; z -> (fn[m] (m 3 9))
; (my-car z)
; (my-car (fn[m] (m 3 9))
;    (fn [3 9] 3))


; Exercise 2.5.  Show that we can represent pairs of nonnegative integers
; using only numbers and arithmetic operations if we represent the pair a 
; and b as the integer that is the product 2a 3b. Give the corresponding 
; definitions of the procedures cons, car, and cdr.



; Exercise 2.6.  In case representing pairs as procedures wasn't 
; mind-boggling enough, consider that, in a language that can manipulate 
; procedures, we can get by without numbers (at least insofar as 
; nonnegative integers are concerned) by implementing 0 and the operation 
; of adding 1 as

(def zero (fn [f] (fn [x] x)))
(def one (fn [f] (fn [x] (f (x)))) 

(defn add-1 [n] (fn [f] (fn [x] (f ((n f) x)))))

; This representation is known as Church numerals, after its inventor, 
; Alonzo Church, the logician who invented the calculus.

; Define one and two directly (not in terms of zero and add-1). (Hint: Use 
; substitution to evaluate (add-1 zero)). Give a direct definition of the 
; addition procedure + (not in terms of repeated application of add-1).

; Substitution model:
; (add-1 zero)
; (fn [f] (fn [x] (f ((zero f) x))))
; (fn [f] (fn [x] (f ((fn [x] x) x)))) 
; (fn [f] (fn [x] (f (x))))     <----- one

(def one (fn [f] (fn [x] (f (x)))) 
(def zero (fn [f] (fn [x] (f (x)))) 






