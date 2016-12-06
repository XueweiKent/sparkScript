./sbin/start-master.sh
tail -f /home/ubuntu/spark/logs/spark-ubuntu-org.apache.spark.deploy.master.Master-1-ip-172-31-23-88.out

http://52.90.185.40:8080/
http://52.90.185.40:4040/jobs/
./sbin/start-slave.sh spark://ip-172-31-23-88.ec2.internal:7077


for MACHINE in $MACHINE_MASTER $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    scp -i $WORK_DIR/spark_project.pem \
        $WORK_DIR/SimpleApp/target/scala-2.11/simple-project_2.11-1.0.jar \
        ubuntu@$MACHINE:/home/ubuntu/
done

./bin/spark-submit --master spark://ip-172-31-23-88.ec2.internal:6066 --deploy-mode cluster ../simple-project_2.11-1.0.jar

wget ftp://ita.ee.lbl.gov/traces/clarknet_access_log_Sep4.gz /home/ubuntu/spark/data/clarknet_access_log_Sep4.gz

#stop cluster
for MACHINE in $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE \
    "./spark/sbin/stop-slave.sh"
done
ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE_MASTER "./spark/sbin/stop-master.sh"

#pull from git and compile
for MACHINE in $MACHINE_MASTER $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE \
    "cd spark && git pull " 
done
for MACHINE in $MACHINE_MASTER $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE \
    "cd spark &&  ./build/mvn -Pyarn -Phadoop-2.4 -Dhadoop.version=2.4.0 -DskipTests package" &
done

#form a cluster
ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE_MASTER "./spark/sbin/start-master.sh" 
for MACHINE in $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE \
    "./spark/sbin/start-slave.sh  spark://ip-172-31-23-88.ec2.internal:7077"
done

#start spark shell
cd spark
./bin/spark-shell --master spark://ip-172-31-23-88.ec2.internal:7077
sc.setLogLevel("INFO")
