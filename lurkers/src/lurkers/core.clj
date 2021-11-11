(ns lurkers.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
;;Create a record and save a log message to a log file
;;Constructor with side effects

;;define a Person record
(defrecord Person [fname lname])

;;define a function to save a log message into the log.txt using spit and :append
(defn log-entry [msg] (spit "log.txt" (apply str msg "\n") :append true))

;;build the constructor which: 1) log the message; 2)create a Person
(defn make-person [fname lname]
  (log-entry (apply str "[log] New Person created : " lname "," fname))
    (->Person fname lname))

;;create a person
(def person (make-person "John" "Smith"))

;;print the content of the log.txt to the console
(println  (slurp "log.txt"))











(defrecord HTML [lines])
(defrecord File-name [name])

(defn create-html-file [text file-name] (spit file-name (apply str text "\n") :append true))

(defn make-html [lines file-name]
  (->HTML lines)
  (->File-name file-name)
    (create-html-file lines file-name))

(def html-file (make-html "<<!DOCTYPE html>
  <html>
  <body>
  
  <h1>My First Heading</h1>
  <p>My first paragraph.</p>
  
  </body>
  </html>" (apply str "lurker_" (rand-int 385792) ".html")))