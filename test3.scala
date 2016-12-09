//no outside workload

//using default first
//loading data from disk, then cache it, count it, time it

//then use our repartitioner
//load data from cache, repartition it, cache it, count it, time it
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
textFile.count()            //2.324, 3.068, 2.587
val textFileWeighted = textFile.
  repartitionWithWeight(5, locWeight).cache()
textFileWeighted.count()    //3.629, 3.649, 3.623
