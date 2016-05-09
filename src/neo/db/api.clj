(ns neo.db.api
    (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            [clojurewerkz.neocons.rest.labels :as nl]))



(def connection (nr/connect "http://localhost:7474/db/data/" "USER" "PASS"))

(defn get-node
  [id]
  (nn/get connection id))


(defn create-node
  [entity]
  (nn/create connection entity))



(defn add-labels
  [node-id labels]
  (let [node (get-node node-id)]
    (nl/add connection node labels)))



(defn get-by-labels
  [label]
  (nl/get-all-nodes connection label))



(defn link
  [node1-id node2-id link-label]
  (let [node1 (nn/get connection node1-id)
        node2 (nn/get connection node2-id)
        relationship (nrl/create connection node1 node2 link-label {:from node1-id :to node2-id})]
    relationship))



(defn unlink
  [node1-id node2-id link-label]
  (let [node1 (get-node node1-id)
        relationships (nrl/outgoing-for connection node1 :types [link-label])
        rels (for [rel relationships] {:id (:id rel) :data (:data rel)})]

  rels))




(defn delete
  [id]
  (nn/destroy connection id))

