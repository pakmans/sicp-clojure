(defn average [x y] 
  (/ (+ x y) 2))

(defn positive? [x] (> x 0))

(defn negative? [x] (< x 0))

(defn abs [x]
  (if (> x 0)
    x
    (- x)))

(defn close-enough? [x y]
  (< (abs (- x y)) 0.001 ))

(defn search [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond 
          (positive? test-value) (search f neg-point midpoint)
          (negative? test-value) (search f midpoint pos-point)
          :else midpoint)))))


(defn half-interval-method [f a b]
  (let [a-value (f a)
        b-value (f b)]
  (cond
    (and (negative? a-value)
         (positive? b-value))
    (search f a b)
    (and (negative? b-value)
         (positive? a-value))
    (search f b a)
    :else
    (print "Values are not of opposite sign"))))
  
(defn sin[x]
  (. Math sin x))

(half-interval-method sin 2.0 4.0)
;3.14111328125


(half-interval-method 
 (fn [x] (- (* x x x) (* 2 x) 3))
 1.0
 2.0)
; 1.89306640625


; Finding fixed points of functions

(def tolerance 0.00001)

; try is a reserved word in clojure, so we use try-guess
(defn fixed-point [f first-guess]
  (defn close-enough? [v1 v2]
    (< (abs (- v1 v2))
       tolerance))
  (defn try-guess [guess]
    (let [next (f guess)]
      (if (close-enough? guess next)
        next
        (try-guess next))))
  (try-guess first-guess))

(defn cos[x] (. Math cos x))

(fixed-point cos 1.0)
; 0.7390822985224024

(fixed-point (fn [y] (+ (sin y) (cos y)))
             1.0)
; 1.2587315962971173

; Unstable solution:
(defn sqrt [x]
  (fixed-point (fn [y] (/ x y))
               1.0))

(sqrt 2)
; StackOverflowError

; With average damping:
(defn sqrt [x]
  (fixed-point (fn [y] (average y (/ x y)))
               1.0))

(sqrt 2)
; 1.4142135623746899