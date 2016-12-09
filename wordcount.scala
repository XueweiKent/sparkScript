sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap
var locWeight = HashMap[String, Int]()
locWeight("172.31.17.139") = 5:Int
locWeight("172.31.16.243") = 5:Int
locWeight("172.31.28.174") = 5:Int
locWeight("172.31.25.123") = 5:Int
locWeight("172.31.28.253") = 5:Int


val textFile = sc.textFile("data/clarknet_access_log_Sep4").cache()
textFile.count()
textFile.count()
textFile.count()
val textFileWeighted = sc.textFile("data/clarknet_access_log_Sep4").repartitionWithWeight(5, locWeight).cache()
val textFileWeighted = textFile.repartitionWithWeight(5, locWeight).cache()
textFileWeighted.count()
textFileWeighted.count()
textFileWeighted.count()

textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
textFileWeighted.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)

textFile.map(line => line.split(" ").size).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  reduce((a, b) => if (a > b) a else b)

textFileWeighted.map(line => line.split(" ").size).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  reduce((a, b) => if (a > b) a else b)


sc.setLogLevel("INFO")
val textFile = sc.textFile("data/clarknet_access_log_Sep4").cache()
textFile.count()
val linesWithSpark = textFile.filter(line => line.contains("Spark"))
textFile.filter(line => line.contains("Spark")).count()
textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
wordCounts.collect()

import scala.collection.mutable.HashMap
var locWeight = HashMap[String, Int]()
locWeight("172.31.17.139") = 5:Int
locWeight("172.31.16.243") = 4:Int
locWeight("172.31.28.174") = 3:Int
locWeight("172.31.25.123") = 2:Int
locWeight("172.31.28.253") = 1:Int
val textFileWeighted = textFile.repartitionWithWeight(5, locWeight).cache()
textFileWeighted.count()


textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)

textFileWeighted.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)

var tfm = textFileWeighted.coalesce(5).cache()
tfm.count()

var pc = new DefaultPartitionCoalescer(0.99)
var pctmp=pc.asInstanceOf[PartitionCoalescer]
var tfm = textFileWeighted.coalesce(5, false, partitionCoalescer=pc)

import org.apache.spark.rdd.CoalescedRDD
import org.apache.spark.rdd.DefaultPartitionCoalescer
import org.apache.spark.rdd.PartitionCoalescer
import org.apache.spark.rdd.CoalescedRDD

val pc = new DefaultPartitionCoalescer()
pc.coalesce(5, textFileWeighted)




textFileWeighted.map(line => line.split(" ").size).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  map(size => size * size / 2.0).
  map(size => Math.abs(Math.cos(Math.asin(Math.cos(Math.log(size)))))).
  map(size => Math.log(Math.tanh(Math.exp(Math.sqrt(size))))).
  reduce((a, b) => if (a > b) a else b)
