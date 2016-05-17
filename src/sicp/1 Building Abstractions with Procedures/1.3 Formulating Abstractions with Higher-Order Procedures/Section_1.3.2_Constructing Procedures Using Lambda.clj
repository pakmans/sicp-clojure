;Lambda
(fn [x] (+ x 4))

; Invoking a Lambda
((fn [x] (+ x 4)) 6)

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) 
       (sum term (next a) next b))))

; Integral Using lambda instead of named function for incrementing dx
(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2)) 
          (fn [x] (+ x dx))
          b)
     dx))


; Let

(defn square [n] (* n n))

; Using internal function
(defn f [x y]
  (defn f-helper [a b]
    (+ (* x (square a))
       (* y b)
       (* a b)))
  (f-helper (+ 1 (* x y)) 
            (- 1 y)))

; Using lambda (anonymous funcion)
(defn f2 [x y]
  ((fn [a b]
     (+ (* x (square a))
        (* y b)
        (* a b)))
   (+ 1 (* x y)) 
   (- 1 y)))

; Which is equivalent to let
(defn f3 [x y]
  (let [a (+ 1 (* x y))
        b (- 1 y)]
     (+ (* x (square a))
        (* y b)
        (* a b))))

; Sample of simple let
(+ (let [x 3]
     (+ x (* x 10)))
   5)

; Exercise 1.34
; Substitution expansion:
; (f f) faile because it attempts to invoke f with wrong argument: 2 instead of a function
; (f f)
; (f 2) <- Fails, because f expects a function not a number
(defn f [g]
  (g 2))
