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