(ns sicp.c2.s2.ss4-picture-language
  (:require [quil.core :as q]))

(defn draw []
  (q/image (q/load-image "https://libraries.mit.edu/archives/exhibits/andrew/img/rogers.jpg") 10 10))

(
