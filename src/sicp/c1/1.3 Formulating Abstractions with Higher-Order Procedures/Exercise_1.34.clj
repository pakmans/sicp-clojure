; Exercise 1.34:
; Suppose we define the procedure

(defn f [g] (g 2))

;Then we have

(defn square [x] (* x x))

(f square)
; 4

(f (fn [z] (* z (+ z 1))))
;6

; What happens if we (perversely) ask the interpreter to evaluate the 
; combination (f f)? Explain.

; ANSWER: It would generate a runtime error, since we will try to evaluate
; f using 2 as an argument, but f expects a function.
; (ClassCastException java.lang.Long cannot be cast to clojure.lang.IFn)
; (f f)
; (f (f 2))
;       ^ Must be a function!

(f f)
; ClassCastException java.lang.Long cannot be cast to clojure.lang.IFn  user/f