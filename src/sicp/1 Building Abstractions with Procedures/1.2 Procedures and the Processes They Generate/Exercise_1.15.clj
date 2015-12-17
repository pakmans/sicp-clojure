; Exercise 1.15
(defn cube [x] 
  (* x x x))

(defn abs [x]
  (if (> x 0)
    x
    (- x)))

(defn p [x] (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
   (if (not (> (abs angle) 0.1))
       angle
       (p (sine (/ angle 3.0)))))

; (sine 12.15)
; (p (sine 4.05))
; (p (p (sine 1.35)))
; (p (p (p (sine 0.45))))
; (p (p (p (p (sine 0.15)))))
; (p (p (p (p (p (sine 0.05))))))
; (p (p (p (p (p 0.05)))))          <----- Solution to 1: p is applied 5 times
; (p (p (p (p (- (* 3 0.05) (* 4 (cube 0.05)))))))
; (p (p (p (p (- 0.15 0.0005)))))
; (p (p (p (p 0.1495))))
; (p (p (p (- (* 3 0.1495) (* 4 (cube 0.1495))))))
; (p (p (p (- 0.4485 0.01336545))))
; (p (p (p 0.435134551)))
; (p (p (- (* 3 0.435134551) (* 4 (cube 0.435134551)))))
; (p (p (- 1.305403652 0.329557119)))
; (p (p (0.975846533)))
; (p (- (* 3 0.975846533) (* 4 (cube 0.975846533))))
; (p (- 2.927539599 3.717102712))
; (p −0.789563113)
; (- (* 3 −0.789563113) (* 4 (cube −0.789563113)))
; (- −2.368689339 −1.968885875)
; −0.399803464

; 1. How many times is the procedure p applied when (sine 12.15) is evaluated?
; answer: 5 times

; 2. What is the order of growth in space and number of steps (as a function 
;    of a) used by the process generated by the sine procedure when (sine a) is evaluated?
;

; Simplified version:
; (sine 12.15)
; (p (sine 4.05))
; (p (p (sine 1.35)))
; (p (p (p (sine 0.45))))
; (p (p (p (p (sine 0.15)))))
; (p (p (p (p (p (sine 0.05))))))
; (p (p (p (p (p 0.05)))))          <----- Solution to 1: p is applied 5 times
; (p (p (p (p 0.1495))))
; (p (p (p 0.435134551)))
; (p (p (0.975846533)))
; (p −0.789563113)
; −0.399803464

