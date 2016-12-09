//no outside workload
// ./cpuPunisher 300 0

//using default
//loading data from disk, then cache it, count it multiple times

//run a intense job multiple times and 

sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap

var locWeight = HashMap[String, Int]()
locWeight("172.31.17.139") = 1:Int
locWeight("172.31.16.243") = 1:Int
locWeight("172.31.28.174") = 1:Int
locWeight("172.31.25.123") = 1:Int
locWeight("172.31.28.253") = 1:Int

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

//100% CPU: 1.818, 1.678, 1.588, 1.582, 1.544, 1.689, 1.644, 1.599
//sc.getNodeDuration()
//scala.collection.mutable.HashMap[String,Long] = Map(172.31.28.253 -> 1453, 172.31.28.174 -> 1637, 172.31.25.123 -> 1472, 172.31.17.139 -> 1452, 172.31.16.243 -> 1487)
