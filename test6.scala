//50% outside workload on one node
// ./cpuPunisher 300 1

//using default
//loading data from disk, then cache it, count it multiple times

//run a intense job multiple times and 

sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap

var locWeight = HashMap[String, Int]()
locWeight("172.31.17.139") = 50:Int
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

//50% CPU: 1.860, 1.924, 1.828, 1.826, 1.849, 1.785, 1.780, 1.877
//sc.getNodeDuration()
//scala.collection.mutable.HashMap[String,Long] = Map(172.31.28.253 -> 1860, 172.31.28.174 -> 1732, 172.31.25.123 -> 1751, 172.31.17.139 -> 1836, 172.31.16.243 -> 1680)