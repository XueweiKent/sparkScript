#include <iostream>
#include <unistd.h>
#include <thread>
#include <cmath>
#include <vector>
using namespace std;

void busyLoop(int input){
	double var = 2.3;
	while(true){
		if(var > 9999999)
			var = 2.3;
		var = exp(var);
	}
}

void timeBomb(int second){
	sleep(second);
	cout<<"end"<<endl;
	exit(0);
}

int main(int argc, char ** argv)
{
    if(argc < 3){
    	cout<<"Input Format: cpuPunisher second num_thread"<<endl;;
    	return -1;
    }

    int second = atoi(argv[1]);
    int num_thread = atoi(argv[2]);;

    cout<<"start"<<endl;
    vector<thread> threads;
    for(int i=0; i < num_thread; i++){
    	threads.push_back(thread(busyLoop, 1));
    }
    
    thread timer(timeBomb, second);
    timer.join();

    return 0;
}