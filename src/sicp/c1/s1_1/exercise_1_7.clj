(ns ^{:doc
      "The good-enough? test used in computing square roots will not 
      be very effective for finding the square roots of very small numbers. 
      o, in real computers, arithmetic operations are almost always performed 
      with limited precision. This makes our test inadequate for very large
      numbers. Explain these statements, with examples showing how the test fails 
      for small and large numbers. An alternative strategy for implementing
      good-enough? is to watch how guess changes from one iteration to the next
      and to stop when the change is a very small fraction of the guess.
      Design a square-root procedure that uses this kind of end test.
      Does this work better for small and large numbers?"}
  sicp.c1.s1-1.exercise-1-7)

;; Exercise 1.7: The good-enough? test used in computing square roots will not 
;; be very effective for finding the square roots of very small numbers. 
;; Also, in real computers, arithmetic operations are almost always performed 
;; with limited precision. This makes our test inadequate for very large
;; numbers. Explain these statements, with examples showing how the test fails 
;; for small and large numbers. An alternative strategy for implementing
;; good-enough? is to watch how guess changes from one iteration to the next
;; and to stop when the change is a very small fraction of the guess.
;; Design a square-root procedure that uses this kind of end test.
;; Does this work better for small and large numbers?

;; Answer
;; For small numbers, it is quite intuitive as the expected result gets closer
;; and closer the the error tolerance.
;; For larger numbers, I'm not exactly sure but it certainly has to do with
;; the way floating point numbers are encoded.

(defn average [a b]
  (/ (+ a b) 2))

(defn abs [x]
  (if (> x 0)
    x
    (- x)
    ))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess new-guess]
  "New version of good enough"
  (< (abs (- guess new-guess))
     0.00001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess (improve guess x))
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
