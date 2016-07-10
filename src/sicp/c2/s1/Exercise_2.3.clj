; Exercise 2.3:
; Implement a representation for rectangles in a plane. (Hint: You may want to
; make use of Exercise 2.2.) In terms of your constructors and selectors, create
; procedures that compute the perimeter and the area of a given rectangle. Now
; implement a different representation for rectangles. Can you design your
; system with suitable abstraction barriers, so that the same perimeter and area
; procedures will work using either representation?

(defn make-point [x y]
  (list x y))

(defn x-point [point]
  (first point))

; In clojure ther is no cdr, so I use nth function
; instead of rest rest returns a sequence
(defn y-point [point]
  (nth point 1))

(defn make-segment [p1 p2]
  (list p1 p2))

(defn start-segment [s]
  (first s))

(defn end-segment [s]
  (last s))

(defn rect [p1 p2 p3 p4]
  (make-segment p1 p2))

(defn long-side [])

(defn perimeter [rect]
  (+ (* 2 (long-side rect))
     (* 2 (short-side rect))))