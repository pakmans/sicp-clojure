; Exercise 1.12 Pascal's Triangle
; Simple, but TERRIBLY inneficient recursive implementation:
; 
(defn pascal-element [row col]
    (cond (or (= col 1) (= col row)) 1
          :else (+ (pascal-element (- row 1) (- col 1))
                   (pascal-element (- row 1) col))))

(defn pascal-rec [r]
  (loop [row 1, col 1]
    (if (<= row r)
      (if (<= col row)
        (do (print (pascal-element row col)) 
            (recur row (+ col 1)))
        (do (println) 
            (recur (+ row 1) 1))))))

; For each element of the triangle, something like this happens:
;        (p 5 2)
;          /  \
;   (p 4 1)   (p 4 2)
;      1        /  \
;          (p 3 1)  (p 3 2)
;              1      /  \
;                (p 2 1)  (p 2 2)
;                   1       /  \
;                    (p 1 1)   (p 1 1)
;                       1         1

