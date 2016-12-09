//75% outside workload on one node
// ./cpuPunisher 300 3

//using default
//loading data from disk, then cache it, count it multiple times

//run a intense job multiple times and 

sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap

var locWeight = HashMap[String, Int]()
locWeight("172.31.17.139") = 25:Int
locWeight("172.31.16.243") = 100:Int
locWeight("172.31.28.174") = 100:Int
locWeight("172.31.25.123") = 100:Int
locWeight("172.31.28.253") = 100:Int

val textFile = sc.textFile("data/clarknet_access_log_Sep4").cache()
val textFileWeighted = textFile.
  repartitionWithWeight(5, locWeight).cache()
textFileWeighted.count()
textFileWeighted.count()
textFileWeighted.count()

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

//25% CPU: 2.169, 2.125, 2.158, 2.066, 2.070, 2.074, 2.074, 2.108
//sc.getNodeDuration()
//scala.collection.mutable.HashMap[String,Long] = Map(172.31.28.253 -> 1890, 172.31.28.174 -> 1798, 172.31.25.123 -> 1817, 172.31.17.139 -> 2084, 172.31.16.243 -> 1729)