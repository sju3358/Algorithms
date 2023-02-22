#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    
     if(s.length() == 1 )
        return 1;
         
	int answer = 0;

	char pivot = s[0];

	int cntOfPivot = 0;
	int cntOfNotPivot = 0;
    int endOfString = 0;

   
	for (int i = 0; i < s.length(); i++) {

		if (pivot == s[i]) {
			cntOfPivot++;
		}

		if (pivot != s[i]) {
			cntOfNotPivot++;
		}

		if (cntOfPivot == cntOfNotPivot) {
			cntOfPivot = cntOfNotPivot = 0;
			answer++;
            endOfString = i;
			if (i < s.length() - 1) {
				pivot = s[i + 1];
			}
		}
	}
    
    if(endOfString != s.length()-1)
        answer++;

	return answer;
}