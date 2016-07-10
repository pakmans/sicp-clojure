(defn make-rat [n d]
  (list n d))

(defn numer [x]
  (first x))

(defn denom [x]
  (last x))

(defn print-rat [x]
  (println)
  (println (numer x) "/" (denom x)))

(defn add-rat [x y]
  (make-rat ( + (* (numer x) (denom y))
              (* (numer y) (denom x)))
              (* (denom x) (denom y))))

; From 1.2.5:
(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(defn make-rat [n d]
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))

; Exercise 2.1.  Define a better version of make-rat that handles both 
; positive and negative arguments. Make-rat should normalize the sign so that 
; if the rational number is positive, both the numerator and denominator are 
; positive, and if the rational number is negative, only the numerator is negative