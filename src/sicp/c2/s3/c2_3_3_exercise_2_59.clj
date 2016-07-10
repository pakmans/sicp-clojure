; Exercise 2.59:
; Implement the union-set operation for the unordered-list representation 
; of sets.

(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        (element-of-set? (first set2) set1) (recur set1 (rest set2)) 
        :else (recur (cons (first set2) set1) (rest set2))))
        ;:else (union-set (cons (first set2) set1) (rest set2))))

