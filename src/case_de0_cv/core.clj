(ns case-de0-cv.core
  (:require [scad-clj.scad :as scad]
            [scad-clj.model :as model]))

(def primitives
  (model/difference
    (model/cube 130 101 13 :center false)
    (model/union
      (model/translate [2.5 2.5 1.5] (model/cube 125 96 15 :center false))
      (model/translate [6 6 -2] (binding [model/*fn* 100] (model/cylinder 1.5 17 :center false)))
      (model/translate [124 6 -2] (binding [model/*fn* 100] (model/cylinder 1.5 17 :center false)))
      (model/translate [124 95 -2] (binding [model/*fn* 100] (model/cylinder 1.5 17 :center false)))
      (model/translate [6 95 -2] (binding [model/*fn* 100] (model/cylinder 1.5 17 :center false)))
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "case-de0-cv.scad" (scad/write-scad primitives)))