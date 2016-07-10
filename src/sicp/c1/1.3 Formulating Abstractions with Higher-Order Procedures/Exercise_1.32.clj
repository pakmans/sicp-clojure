; Exercise 1.32
; 1. Show that sum and product (Exercise 1.31) are both special cases of a 
;    still more general notion called accumulate that combines a collection of
;    terms, using some general accumulation function:
;    (accumulate combiner null-value term a next b)
;    Accumulate takes as arguments the same term and range specifications as
;    sum and product, together with a combiner procedure (of two arguments) 
;    that specifies how the current term is to be combined with the accumulation
;    of the preceding terms and a null-value that specifies what base value to 
;    use when the terms run out. Write accumulate and show how sum and product
;    can both be defined as simple calls to accumulate.

(defn accumulator [combiner null-value term a next b]
  (if (> a b)
    null-value
    (combiner (term a) (accumulator combiner null-value term (next a) next b))))

(defn sum [term a next b]
  (accumulator + 0 term a next b))

(defn product [term a next b]
  (accumulator * 1 term a next b))

(sum (fn [x] x) 1 (fn [x] (inc x)) 10)
;56

(product (fn [x] x) 1 (fn [x] (inc x)) 10)
; 3628800


; 2. If your accumulate procedure generates a recursive process, write one that
;    generates an iterative process. If it generates an iterative process, 
;    write one that generates a recursive process.

(defn accumulator [combiner null-value term a next b]
  (defn iter [n acc]
    (if (> n b)
      acc
      (iter (next n) (combiner (term n) acc))))
  (iter a a))

(accumulator * 1 (fn [x] x) 1 (fn [x] (inc x)) 10)
; 3628800