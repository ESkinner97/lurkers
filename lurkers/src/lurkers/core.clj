(ns lurkers.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defrecord HTML [lines])
(defrecord File-name [name])
(defrecord NFT-record [someId])

(defn record-entry [msg] (spit "log.txt" (apply str msg "\n") :append true))
(defn create-html-file [text file-name] (spit file-name (apply str text) :append true))

(defn make-html [lines file-name]
  (->HTML lines)
  (->File-name file-name)
    (create-html-file lines file-name))

(defn make-record [someId]
  (record-entry (apply str "[log] new file created : " someId))
  (->NFT-record someId))

(defn create-file []
  (def randNum (rand-int 8719)) 
  (def html
    (make-html "<<!DOCTYPE html>
    <html>
    <body>
    
    <h1>Rutherford the Brave</h1>
    <p>Stealtimefromthefaultyplan</p>
    
    </body>
    </html>" (apply str "lurker_" randNum ".html")))
  (make-record (str randNum)))

(def nft (create-file))
