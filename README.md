# sparkScript

spark project helpful scripts

1. cpuPunisher: a C++ application to add throttling on local machine. Run it as ./cpuPunisher num_of_second num_of_thread

2. bashrc: used to configure EC2 machine to compile Spark quickly. Contains information regarding JAVA path and Scala path.

3. ip map: quick map between private ip and public of our EC2 machines. Text file.

4. kmeans.scala: small kmeans example running on Spark shell. 

5. script.sh, script2.sh: bash scripts to copy/git pull/compile spark/stop cluster/start cluster/start spark shell/install java+scala

6. statistic.py: small python script to calculate mean and std of an array of numbers

7. test*.scala: each script runs a specific test on Spark. Details are commented on the head of each script. To run them, open a Spark shell and paste them in.

8. wordcount.scala: pieces of scala scripts during debugging/testing process.

9. SimpleApp: simple application practising submitting scala jobs to Spark cluster.
