; Exercise 2.61:
; Give an implementation of adjoin-set using the ordered 
; representation. By analogy with element-of-set? show how to take advantage
; of the ordering to produce a procedure that requires on the average about
; half as many steps as with the unordered representation.

; It is the same implementation, we just need to substitute element-of-set?
; by the sorted set version element-of-sorted-set?
(defn adjoin-ordered-set? [x a-set]
  (if (element-of-ordered-set? x a-set)
    a-set
    (cons x a-set)))

