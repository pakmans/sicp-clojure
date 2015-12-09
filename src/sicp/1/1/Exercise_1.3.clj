;; Exercise 1.3: Define a procedure that takes three numbers as arguments and
;; returns the sum of the squares of the two larger numbers.

;; Horrible solution, using only what has been covered so far:

(defn sos [x y]
  "Sum Of Squares"
  ( + (* x x) (* y y)))

(defn sosg [a b c]
  (cond (and (<= a b) (<= a c)) (sos b c)
        (and (<= b a) (<= b c)) (sos a c)
        (and (<= c a) (<= c b)) (sos a b )))

(sosg 4 2 3)

(sosg 4 3 4)

(sosg 3 4 3)

(sosg 3 3 3)