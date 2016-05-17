; Exercise 1.31
; 1. The sum procedure is only the simplest of a vast number of similar 
;    abstractions that can be captured as higher-order procedures. 
;    Write an analogous procedure called product that returns the product 
;    of the values of a function at points over a given range.

(defn product [term a next b]
  (if (> a b)
    1
    (* (term a) (product term (next a) next b))))

(product (fn [x] x) 1 (fn [x] (inc x)) 10)
; 3628800


; Show how to define factorial in terms of product. Also use product to compute 
; approximations to π using the formula
; π/4 = (2*4*4*6*6*8...)/(3*3*5*5*7*7..)

(defn fact [x] 
  (product (fn [x] x) 1 (fn [x] (inc x)) x))  
  
 (fact 10)
 ; 3628800
 
 
; 2. If your product procedure generates a recursive process, write one that 
;    generates an iterative process. If it generates an iterative process,
;    write one that generates a recursive process.
(defn product [term a next b]
  (defn iter [n prod]
    (if (> n b)
      prod
      (iter (next n) (* (term n) prod))))
  (iter a 1))

(product (fn [x] x) 1 (fn [x] (inc x)) 10)
; 3628800

