#include <string>
#include <vector>
#include <queue>
#include <sstream>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<string>::iterator iteratorOfOperations;

    vector<int> temp;
    vector<int>::iterator iteratorOfTemp;

    priority_queue<int> two_way_priority_queue;
    
    for(iteratorOfOperations = operations.begin(); iteratorOfOperations != operations.end(); iteratorOfOperations++){
        
        stringstream input(*iteratorOfOperations);
        string output[2];
        input >> output[0] >> output[1];
        
        string operation = output[0];
        int value = stoi(output[1]);

        if(!operation.compare("I"))
            two_way_priority_queue.push(value);

        else if(!operation.compare("D")){

            if(value == 1){
                
                if(two_way_priority_queue.size() > 0)
                    two_way_priority_queue.pop();
            }
            else if(value == -1){

                if(two_way_priority_queue.size() > 0)
                {
                    while(two_way_priority_queue.size() > 1){
                        temp.push_back(two_way_priority_queue.top());
                        two_way_priority_queue.pop();
                    }
                    two_way_priority_queue.pop();
                }

                for(iteratorOfTemp = temp.begin(); iteratorOfTemp != temp.end(); iteratorOfTemp++)
                    two_way_priority_queue.push(*iteratorOfTemp);

                while(!temp.empty())
                    temp.pop_back();

            }
        }
    }
    
    vector<int> answer;

    if(two_way_priority_queue.size() == 0){
        answer.push_back(0);
        answer.push_back(0);
    }
    else{
        answer.push_back(two_way_priority_queue.top());
        while(two_way_priority_queue.size() > 1)
            two_way_priority_queue.pop();
        answer.push_back(two_way_priority_queue.top());
    }
    
    return answer;
}