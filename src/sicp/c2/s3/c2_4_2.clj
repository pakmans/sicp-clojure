; 2.4.2 Tagged data

(defn attach-tag [type-tag contents]
  (list type-tag contents))

(defn type-tag [datum]
  (if (list? datum)
    (first datum)
    (throw (Exception. "Bad tagged datum:\nTYPE-TAG"))))

(defn contents [datum]
  (if (list? datum)
    (last datum)
    (throw (Exception. "Bad tagged datum:\nTYPE-TAG"))))

(defn rectangular? [z]
  (= (type-tag z) "rectangular"))

(defn polar? [z]
  (= (type-tag z) "polar"))

(defn real-part [z]
  (cond (rectangular? z)
        (rectangular/real-part (contents z))
        (polar? z)
        (polar/real-part (contents z))
        :else (throw (Exception. "Unknown type:\nREAL-PART"))))

(defn imag-part [z]
  (cond (rectangular? z)
        (rectangular/imag-part (contents z))
        (polar? z)
        (polar/imag-part (contents z))
        :else (throw (Exception. "Unknown type:\nIMAG-PART"))))

(defn magnitude [z]
  (cond (rectangular? z)
        (rectangular/magnitude (contents z))
        (polar? z)
        (polar/magnitude (contents z))
        :else (throw (Exception. "Unknown type:\nMagnitude"))))

(defn angle [z]
  (cond (rectangular? z)
        (rectangular/angle (contents z))
        (polar? z)
        (polar/angle (contents z))
        :else (throw (Exception. "Unknown type:\nAngle"))))

(defn make-from-real-imag [x y]
  (attach-tag "rectangular" (rectangular/make-from-real-imag x y)))

(defn make-from-mag-ang [r a]
  (attach-tag "polar" (polar/make-from-mag-ang r a))) 

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

