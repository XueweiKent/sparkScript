#defining machine constants
WORK_DIR=/home/xuewei/spark
MACHINE_MASTER=ec2-52-90-185-40.compute-1.amazonaws.com
MACHINE_1=ec2-54-175-142-41.compute-1.amazonaws.com
MACHINE_2=ec2-54-208-215-40.compute-1.amazonaws.com
MACHINE_3=ec2-54-91-70-126.compute-1.amazonaws.com
MACHINE_4=ec2-54-173-5-62.compute-1.amazonaws.com
MACHINE_5=ec2-54-196-62-240.compute-1.amazonaws.com
MACHINE=$MACHINE_MASTER

#copying spark_github key to machines, so they can clone from git
for MACHINE in $MACHINE_MASTER $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    scp -i $WORK_DIR/spark_project.pem \
        $WORK_DIR/spark_github \
        ubuntu@$MACHINE:/home/ubuntu/.ssh/id_rsa 
    scp -i $WORK_DIR/spark_project.pem \
        $WORK_DIR/spark_github.pub \
        ubuntu@$MACHINE:/home/ubuntu/.ssh/id_rsa.pub 
    scp -i $WORK_DIR/spark_project.pem \
        $WORK_DIR/bashrc \
        ubuntu@$MACHINE:/home/ubuntu/.bashrc
done


#stop cluster
for MACHINE in $MACHINE_1 $MACHINE_2 $MACHINE_3 $MACHINE_4 $MACHINE_5
do
    ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE \
    "./spark/sbin/stop-slave.sh"
done
ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE_MASTER "./spark/sbin/stop-master.sh"


#ssh to the machines
ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE

#install java and scala
ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE_1
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java7-installer
#sudo nano /etc/environment
#JAVA_HOME=/usr/lib/jvm/java-7-oracle/
#source /etc/environment
wget http://www.scala-lang.org/files/archive/scala-2.10.4.tgz
sudo mkdir /usr/local/src/scala
sudo tar xvf scala-2.10.4.tgz -C /usr/local/src/scala/
#vim ~/.bashrc
#export SCALA_HOME=/usr/local/src/scala/scala-2.10.4
#export PATH=$SCALA_HOME/bin:$PATH
#source ~/.bashrc

#clone spark to machines, and switch to right branch. FIRST TIME ONLY
git clone git@github.com:XueweiKent/spark.git
cd spark
git checkout ec2_deploy

#compile spark
export MAVEN_OPTS="-Xmx512m -XX:ReservedCodeCacheSize=128m"
cd /home/ubuntu/spark
./build/mvn -Pyarn -Phadoop-2.4 -Dhadoop.version=2.4.0 -DskipTests clean package
./build/mvn -Pyarn -Phadoop-2.4 -Dhadoop.version=2.4.0 -DskipTests package

#pull and deploy from github
git stash
ssh -y -i $WORK_DIR/spark_project.pem ubuntu@$MACHINE_MASTER "cd ~/spark && git pull"
JAVA_HOME=/usr/bin/java
