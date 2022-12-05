#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer;

	int rightMax = board[0]/2;
	int leftMax = -1 * rightMax;

	int upMax = board[1]/2;
	int downMax = -1 * upMax;

	int start_x = 0;
	int start_y = 0;

	for(int i = 0; i<keyinput.size(); i++){
		if(keyinput[i].compare("left") == 0){
			if(start_x - 1 >= leftMax)
				start_x = start_x - 1;
		}
		else if(keyinput[i].compare("right") == 0){
			if(start_x + 1 <= rightMax)
				start_x = start_x + 1;
		}
		else if(keyinput[i].compare("up") == 0){
			if(start_y + 1 <= upMax)
				start_y = start_y + 1;
		}
		else if(keyinput[i].compare("down") == 0){
			if(start_y - 1 >= downMax)
				start_y = start_y - 1;
		}
	}
	answer.push_back(start_x);
	answer.push_back(start_y);
    return answer;
}