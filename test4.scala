//varing outside workload on one node
// ./cpuPunisher 300 0
// ./cpuPunisher 300 1
// ./cpuPunisher 300 3

//using default
//loading data from disk, then cache it, count it multiple times

//run a intense job multiple times and 

sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap

val textFile = sc.textFile("data/clarknet_access_log_Sep4").cache()
textFile.count()
textFile.count()
textFile.count()

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

//100% CPU: 1.759, 2.235, 1.706, 1.702, 1.763, 1.707, 1.728, 1.707
//50% CPU: 2.812, 2.804, 2.811, 2.854, 2.826, 2.862, 2.809, 2.807
//25% CPU: 5.566, 5.638, 6.605, 5.535, 5.526, 5.533, 5.533, 5.532

//sc.getNodeDuration()
//scala.collection.mutable.HashMap[String,Long] = Map(172.31.28.253 -> 1453, 172.31.28.174 -> 1637, 172.31.25.123 -> 1472, 172.31.17.139 -> 1452, 172.31.16.243 -> 1487)
//scala.collection.mutable.HashMap[String,Long] = Map(172.31.28.253 -> 1475, 172.31.28.174 -> 1670, 172.31.25.123 -> 1487, 172.31.17.139 -> 2836, 172.31.16.243 -> 1486)
//scala.collection.mutable.HashMap[String,Long] = Map(172.31.28.253 -> 1455, 172.31.28.174 -> 1652, 172.31.25.123 -> 1446, 172.31.17.139 -> 5517, 172.31.16.243 -> 1451)