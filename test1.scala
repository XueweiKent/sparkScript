//no outside workload

//using original Spark
//loading data from disk, cache it
//then run counter multiple times, time it
sc.setLogLevel("INFO")
import java.lang.Math
import scala.collection.mutable.HashMap
val textFile = sc.textFile("data/clarknet_access_log_Sep4").cache()
textFile.count()	//2.97, 2.884, 3.056
textFile.count()	//0.243, 0.294, 0.245
textFile.count()	//0.168, 0.182, 0.197
textFile.count()	//0.124, 0.123, 0.142
