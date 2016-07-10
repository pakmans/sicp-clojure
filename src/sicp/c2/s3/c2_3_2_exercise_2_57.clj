; First approximation.
; It doesn't work that well, because it won't simplify the multpilication
; For example (make-product 'x 3 4) will yield (* x 12) which is ok
; but for     (make-product 3 4 'x) it will yield (* 3 (* 4 x)) instead of (* 12 x) 



(defn constant? [ x ] (number? x))

(defn variable? [x] (symbol? x))

(defn same-variable? [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (= v1 v2)))

; (defn make-sum [a1 a2] (list '+ a1 a2))

(defn make-sum [& summands] 
  (let [reordered (concat (filter (comp not number?) summands) (filter number? summands))]
    (let [a1 (first reordered) a2 (second reordered) args (rest reordered)]
      (cond
        (> (count args) 1) (make-sum a1 (apply make-sum args))
        (and (number? a1) (number? a2)) (+ a1 a2)
        (= a1 0) a2
        (= a2 0) a1
        :else (list '+ a1 a2)))))

(defn make-product [& multiplicands]
  (let [reordered (concat (filter (comp not number?) multiplicands) (filter number? multiplicands))]
    (let [m1 (first reordered) m2 (second reordered) args (rest reordered)]
      (cond
        (> (count args) 1) (make-product m1 (apply make-product args))
        (= m1 1) m2
        (= m2 1) m1
        (or (= m1 0) (= m2 0)) 0
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))))

(defn sum? [x]
  (if (coll? x)
    (= (first x) '+)
    false))

(defn addend [s]
  (second s))

(defn augend [s]
  (apply make-sum (conj (rest (rest s)) 0)))

(defn product? [x] 
  (if (coll? x)
    (= (first x) '*)
    false))

(defn multiplier [p] 
  (second p))

(defn multiplicand [p]
  (apply make-product (conj (rest (rest p)) 1)))

(defn deriv [exp var]
  (cond
    (constant? exp) 0
    (variable? exp) (if (same-variable? exp var) 1 0)
    (sum? exp) (make-sum (deriv (addend exp) var)
                         (deriv (augend exp) var))
    (product? exp) (make-sum
                     (make-product (multiplier exp)
                                   (deriv (multiplicand exp) var))
                     (make-product (deriv (multiplier exp) var)
                                   (multiplicand exp)))))



