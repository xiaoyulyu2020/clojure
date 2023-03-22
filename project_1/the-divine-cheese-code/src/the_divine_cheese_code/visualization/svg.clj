(ns the-divine-cheese-code.visualization.svg
(:require [clojure.string :as s])
(:refer-clojure :only [min max]))

(defn comparator-over-maps
    [comparison-fn ks]
    (fn [maps]
        (zipmap ks
            (map (fn [k] (apply comparison-fn (map k maps)))
            ks)
        )
    )
)

(def min (comparator-over-maps clojure.core/min [:lat :lng]))
(def max (comparator-over-maps clojure.core/max [:lat :lng]))