//no outside workload

//using our Spark
//loading data from disk, repartition, then cache it
//then run counter multiple times, time it
sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap

var locWeight = HashMap[String, Int]()
locWeight("172.31.17.139") = 5:Int
locWeight("172.31.16.243") = 5:Int
locWeight("172.31.28.174") = 5:Int
locWeight("172.31.25.123") = 5:Int
locWeight("172.31.28.253") = 5:Int

val textFileWeighted = sc.textFile("data/clarknet_access_log_Sep4").
  repartitionWithWeight(5, locWeight).cache()
textFileWeighted.count()	//5.377, 5.187, 5.613
textFileWeighted.count()	//0.284, 0.231, 0.277
textFileWeighted.count()	//0.114, 0.098, 0.122
textFileWeighted.count()	//0.128, 0.127, 0.132
