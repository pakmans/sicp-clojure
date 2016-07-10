
(defn element-of-set? [x a-set]
  (cond (empty? a-set) false
        (= x (first a-set)) true
        :else (recur x (rest a-set)))) ; :else (element-of-set? x (rest set))))

(defn adjoin-set [x a-set]
  (if (element-of-set? x a-set)
    a-set
    (cons x a-set)))

(defn intersection-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) ()
        (element-of-set? (first set1) set2) (cons (first set1)
                                                  (intersection-set (rest set1) set2)) ; recur won't work here because it is not on tail position
        :else (recur (rest set1) set2)))
        ; :else (intersection-set (rest set1) set2)))


; Sets as ordered lists

(defn element-of-ordered-set? [x a-set]
  (cond (empty? a-set) false
        (= x (first a-set)) true
        (< x (first a-set)) false
        :else (recur x (rest a-set))))
        ; :else (element-of-set? x (rest set))))

(defn intersection-ordered-set [set1 set2]
  (if (or (empty? set1) (empty? set2)) ()
    (let [x1 (first set1) x2 (first set2)]
      (cond (= x1 x2) (cons x1 (intersection-ordered-set (rest set1) (rest set2)))
            (< x1 x2) (intersection-ordered-set (rest set1) set2)
            (> x2 x1) (intersection-ordered-set set1 (rest set2))))))

