#include <string>
#include <vector>

using namespace std;

string covertToBinary(int target, int length){
	string result ="";

	while(target){
		if(target % 2 == 0)
			result = "0" + result;
		else
			result = "1" + result;
		
		target /= 2;
	}

	string temp = "";
	for(int i=0 ; i< length - result.length(); i++){
		temp = temp +"0";
	}

	result = temp + result;
	
	return result;

}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;

	for(int i = 0; i<n; i++){
		string str1 = covertToBinary(arr1[i], n);
		string str2 = covertToBinary(arr2[i], n);
		string result = "";

		for(int j = 0; j<n; j++){
			if(str1[j] == '1' || str2[j] == '1')
				result = result + "#";
			else
				result = result + " ";
		}
		answer.push_back(result);
	}

    return answer;
}

// int main (void){
// 	solution(5,{9,20,28,18,11},{30,1,21,17,28});
// }