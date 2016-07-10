(defn make-product [& args]
  (let [nums (filter number? args) symbs (filter (comp not number?) args)]
    (println nums)
    (println symbs)))
