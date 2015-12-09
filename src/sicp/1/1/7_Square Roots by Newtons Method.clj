(ns sicp.1.1.7
  (:require math.numeric-tower))
; SICP Lecture 1a

; Heron of Alexandria's (Newton's) method for calculating square roots
(defn average [a b]
  (/ (+ a b) 2))

(defn my-abs [a]
  (if (> a 0)
    a
    (- a)))

(defn square [x]
  (* x x))

(defn abs [x]
  (if (> x 0)
    x
    (- x)
    ))

; Changed "try" with "try-guess" because of clash with native try
(defn sqrt [x] 
  (defn improve [guess] 
    (average guess (/ x guess)))
  (defn good-enough? [guess]
    (< (abs (- (square guess) x)) 0.001))
  (defn try-guess [guess]
    (if (good-enough? guess) 
      guess
      (try-guess (improve guess))))
  (try-guess 1)
  )

; Excercise 1.6 Alyssa P. Hacker doesn't see why 
; if needs to be provided as a special form. 
; "Why can't I just define it as an ordinary 
; procedure in terms of cond?" she asks. 
; Alyssa's friend Eva Lu Ator claims this can 
; indeed be done, and she defines a new version 
; of if:

(defn new-if [predicate then-clause else-clause]
  (cond 
    predicate then-clause
    :else else-clause) )

(defn sqrt-hacker [x] 
  (defn improve [guess] 
    (average guess (/ x guess)))
  (defn good-enough? [guess]
    (< (abs (- (square guess) x)) 0.001))
  (defn try-guess [guess]
    (new-if (good-enough? guess) 
      guess
      (try-guess (improve guess))))
  (try-guess 1)
  )

; Answer: stack overflow
; Why: The if special form evaluates the then clause
; only if necessary, while the new-if always evaluates
; both.
