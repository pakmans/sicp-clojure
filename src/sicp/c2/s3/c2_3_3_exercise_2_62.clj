; Exercise 2.62:
; Give a Θ(n) implementation of union-set for sets represented as ordered lists.

(defn union-ordered-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :else (let [x1 (first set1) x2 (first set2)]
                (cond (= x1 x2) (cons x1 (union-ordered-set (rest set1) (rest set2)))
                      (< x1 x2) (cons x1 (union-ordered-set (rest set1) set2))
                      :else (cons x2 (union-ordered-set set1 (rest set2)))))))

