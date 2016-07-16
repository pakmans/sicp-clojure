; 2.4.1 Representations for Complex Numbers
;
; Code is in inverse order from book in order to be able to load it to 
; the repl for evaluation


; Ben's representation
(ns rectangular)

(defn real-part [z] (first z))

(defn imag-part [z] (last z))

(defn magnitude [z] (Math/sqrt (+ (Math/pow (real-part z) 2))))

(defn angle [z] (Math/atan2 (imag-part z) (real-part z)))

(defn make-from-real-imag [x y]
  (list x y))

(defn make-from-mag-ang [r a]
  (list (* r (Math/cos a)) (* r (Math/sin a))))

; Alyssa's representation 

(ns polar)

(defn magnitude [z] (first z))

(defn angle [z] (last z))

(defn real-part [z] (* (magnitude z) (Math/cos (angle z))))

(defn imag-part [z] (* (magnitude z) (Math/sin (angle z))))

(defn make-from-real-imag [x y]
  (list (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)))
        (Math/atan2 x y)))

(defn make-from-mag-ang [r a]
  (list r a))

;(make-from-real-imag (real-part z)
;                     (imag-part z))
;
;(make-from-mag-ang (magnitude z)
;                   (angle z))

(defn add-complex [z1 z2]
  (make-from-real-imag
    (+ (real-part z1) (real-part z2))
    (+ (imag-part z1) (imag-part z2))))

(defn sub-complex [z1 z2]
  (make-from-real-imag
    (- (real-part z1) (real-part z2))
    (- (imag-part z1) (imag-part z2))))

(defn mul-complex [z1 z2]
  (make-from-mag-ang 
    (* (magnitude z1) (magnitude z2))
    (+ (angle z1) (angle z2))))

(defn div-complex [z1 z2]
  (make-from-mag-ang 
    (/ (magnitude z1) (magnitude z2))
    (- (angle z1) (angle z2))))

