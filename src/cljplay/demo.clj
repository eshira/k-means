(ns cljplay.demo
  (:use cljplay.core))

(def frame (java.awt.Frame.))

(defn demo-1 []
  (do
    (-> frame (.setVisible true))
    (-> frame (.setSize (java.awt.Dimension. 500 500)))
    (def gfx (.getGraphics frame))
    (doseq [[x y] pts]
      (.setColor gfx (java.awt.Color. 255 0 0))
      (.fillRect gfx x y 1 1))

    (def means (k-means pts 3))

    (doseq [[x y] means]
      (.setColor gfx (java.awt.Color. 0 0 255))
      (.fillRect gfx x y 4 4))))

(defn clear-demo-1
  (-> frame .dispose))