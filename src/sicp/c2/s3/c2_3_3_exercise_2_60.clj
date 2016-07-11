; Exercise 2.60:
; We specified that a set would be represented as a list with no
; duplicates. Now suppose we allow duplicates. For instance, the set {1,2,3}
; could be represented as the list (2 3 2 1 3 2 2). Design procedures
; element-of-set?, adjoin-set, union-set, and intersection-set that operate on
; this representation. How does the efficiency of each compare with the
; corresponding procedure for the non-duplicate representation? Are there
; applications for which you would use this representation in preference to
; the non-duplicate one?
;
; element-of-set? don't need to change.

(defn intersection-ordered-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) ()
        (element-of-set? (first set1) set2) (cons (first set1) (intersection-ordered-set (rest set1) set2))
        :else (recur (rest set1) set2)))

; adjoin-set and union-set could be simplified a bit since we don't need to 
; check for duplicate items.
(defn adjoin-set [x a-set]
    (cons x a-set))

(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :else (recur (cons (first set2) set1) (rest set2))))
        ;:else (union-set (cons (first set2) set1) (rest set2))))

