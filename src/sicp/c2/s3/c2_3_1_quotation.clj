(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (recur item (rest x))))
        ; :else (memq item (rest x))))


; Exercise 2.53.  What would the interpreter print in response to evaluating
; each of the following expressions?

(list 'a 'b 'c)

; (a b c)

(list (list 'george))

; ((george))

(rest '((x1 x2) (y1 y2)))

; ((y1 y2))

; Original:
;(pair? (car '(a short list)))
; Clojure version
(list? (first '(a short list)))

; false

(memq 'red '((red shoes) (blue socks)))

; false

(memq 'red '(red shoes blue socks))

; (red shoes blue socks)

; Exercise 2.54. Implement equal? as a procedure

(defn equal? [l1 l2]
  (cond (and (empty? l1) (empty? l2)) true
        (and (= (first l1) (first l2)) (equal? (rest l1) (rest l2))) true
        :else false))

; Interesting cases to note:
(equal? nil nil)
; true
(equal? nil ())
;true
(first nil)
;nil
(first ())
;nil

; Exercise 2.55.  Eva Lu Ator types to the interpreter the expression

(first ''abracadabra)

; To her surprise, the interpreter prints back quote. Explain.
;
; 'abracadabra is equivalent to (quote abracadabra) which evaluates to abracadabra
; ''abracadabra is equivalent to (quote (quote abracadabra)) which evaluates to (quote abracadabra)
; So calling first on the list consisting of quote and abracadabra yields the word quote
