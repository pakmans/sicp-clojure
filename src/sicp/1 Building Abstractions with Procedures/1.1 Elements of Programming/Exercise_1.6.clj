;; Excercise 1.6
;; Alyssa P. Hacker doesn't see why if needs to be provided as a special form. 
;; "Why can't I just define it as an ordinary procedure in terms of cond?" 
;; she asks. Alyssa's friend Eva Lu Ator claims this can indeed be done, and 
;; she defines a new version of it:

(defn average [a b]
  (/ (+ a b) 2))

(defn square [x]
  (* x x))

(defn abs [x]
  (if (> x 0)
    x
    (- x)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn new-if [predicate then-clause else-clause]
  (cond 
    predicate then-clause
    :else else-clause) )

(new-if (= 2 3) 0 5)
;; 5

(new-if (= 1 1) 0 5)
;; 0

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

; Answer: StackOverflowError
; Why: The if special form evaluates the then clause only if necessary, while 
; the new-if always evaluates both.
