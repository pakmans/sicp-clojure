(ns sicp.2.2.1_RepresentingSequences)

(cons 1
      (cons 2
            (cons 3
                  (cons 4 nil))))

(list 1 2 3 4)

(def one-through-four (list 1 2 3 4))

; In Clojure we use first instead of car
(first one-through-four)

; In Clojure we use rest instead of cdr
(rest one-through-four)

(first (rest one-through-four))

(cons 10 one-through-four)

; List Operations

(defn list-ref [items n]
  (if (= n 0)
    (first items)
    (list-ref (rest items) (- n 1))))

(def squares (list 1 4 9 16 25))

(list-ref squares 3)

; In Clojure there is a built-in for this:
(nth squares 3)

; Recursive length function
; In Clojure, an empty list is not nil? (not null? actually),
; but rather empty?
(defn length [items]
  (if (empty? items)
    0
    (+ 1 (length (rest items)))))

(def odds (list 1 3 5 7))

(length odds)

; Iterative length function
(defn length [items]
  (defn length-iter [a count]
    (length-iter (rest a) (+ 1 count))))

(length odds)

; Of course, Clojure has count for this purposes:
(count odds)


; Append function
(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2) )))

(append squares odds)

; Excercise 2.17 Define a procedure last-pair that returns 
; the list that contains only the last element of a given (nonempty) list:
; (last-pair (list 23 72 149 34))
; (34)

(defn last-pair [items]
  (if (empty? (rest items))
    items
    (last-pair (rest items))))

(last-pair (list 23 72 149 34))


; Excercise 2.18 Define a procedure reverse that takes a list as 
; argument and returns a list of the same elements in reverse order:
; (reverse (list 1 4 9 16 25))
; (25 16 9 4 1)
; Note: renamed to invert to avoid clash with Clojure's reverse func.

; Reusing our previous append function:
(defn invert [items]
  (if (empty? items)
    nil
    (append (invert (rest items))
            (list (first items)) )))

; Another solution, independent of append function:
; (we should use recur instead of invoking inv2)
(defn invert2 [items]
  (defn inv2 [pending current]
    (if (empty? pending)
      current
      (inv2 (rest pending) (cons (first pending) current))))
  (inv2 items ()))

; Excercise 2.20 
; In Clojure we use & for arbitrary number of args
(defn f [x y & z]
  (println)
  (println "x=" x)
  (println "y=" y)
  (println "z=" z)) 

(defn g [ & w]
  (println)
  (println "w=" w))

; .... pending


; Mapping over lists

(defn scale-list [items factor]
  (if (empty? items)
    nil
    (cons (* (first items) factor) 
          (scale-list (rest items) factor)) ))

(defn sicp-map [proc items]
  (if (empty? items)
    nil
    (cons (proc (first items))
          (sicp-map proc (rest items)))))

(defn scale-list2 [items factor]
  (sicp-map (fn [x] (* x factor)) items))

; Exercise 2.21.  The procedure square-list takes a list of numbers 
; as argument and returns a list of the squares of those numbers.

(defn square [x] (* x x))

(defn square-list [items]
  (if (empty? items)
    nil
    (cons (* (first items) (first items))
          (square-list (rest items)))))

(defn square-list2 [items]
  (map (fn [x] (* x x)) items ))

; Exercise 2.22.  Louis Reasoner tries to rewrite the first square-list 
; procedure of exercise 2.21 so that it evolves an iterative process:

(defn square-list3 [items]
     (defn iter [things answer]
       (if (empty? things)
         answer
         (iter (rest things)                  ; Use recur instead
               (cons (square (first things))
                     answer))))
  (iter items nil))

; Unfortunately, defining square-list this way produces the answer list in the reverse order of the one desired. Why?

; Because:
; (iter [1 2 3 4] nil)
; (iter [2 3 4] (cons (square 1) nil))
; (iter [2 3 4] [1])
; (iter [3 4] (cons (square 2) [1]))
; (iter [3 4] [4 1])
; (iter [4] (cons (square 3) [4 1]))
; (iter [4] (cons (square 4) [9 4 1]))
; (iter nill [16 9 4 1])
; [16 4 1]

; Louis then tries to fix his bug by interchanging the arguments to cons:

(defn square-list4 [items]
     (defn iter [things answer]
       (if (empty? things)
         answer
         (iter (rest things)                  ; Use recur instead
               (cons answer 
                     (square (first things))))))
  (iter items nil))

; (iter [1 2 3 4] nil)
; (iter [2 3 4] (cons nil 1)) ; <- ERROR: In clojure second arg must be a sequence


; Fixing example for Clojure:

(defn square-list5 [items]
     (defn iter [things answer]
       (if (empty? things)
         answer
         (iter (rest things)                  ; Use recur instead
               (cons answer 
                     [(square (first things))]))))
  (iter items nil))

; It runs, but result are nested lists


; EXCERCISE 2.23.  (pending...)

(defn for-each [f items]
  (if (empty? items)
    nil
    (print (first items))))

(for-each (fn [x] (println x))
          (list 57 321 88))
