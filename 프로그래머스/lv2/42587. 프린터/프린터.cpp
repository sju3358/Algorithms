#include <iostream>
#include <vector>
#include <queue>
using namespace std;


typedef struct document {
	int index;
	int prioirty;
}Document;

bool isMaxPrioirty(queue<Document> documents) {

	vector<Document> copiedDocuments;

	while (documents.empty() != true) {
		copiedDocuments.push_back(documents.front());
		documents.pop();
	}

	int prioirty = copiedDocuments[0].prioirty;

	for (int i = 1; i < copiedDocuments.size(); i++)
		if (copiedDocuments[i].prioirty > prioirty)
			return false;

	return true;
}


int solution(vector<int> priorities, int location) {
	
	queue<Document> documents;

	int cnt = 1;

	//vector로 들어온 input을 queue에 담기.
	for (int i = 0; i < priorities.size(); i++) 
		documents.push({ i, priorities[i] });
	
	
	bool isMaxPrioirtyFlag; //현재 front값이 max값인지 확인 , front가 target location인지 확인
	while((isMaxPrioirtyFlag = isMaxPrioirty(documents)) != true || documents.front().index != location){

		//target location이 아니지만 max값이라면 pop하고 출력된 프린터 개수 세기
		if(isMaxPrioirtyFlag == true)
				cnt++;
		else 
			documents.push(documents.front()); //target location도 아니고 max값도 아니면 빼서 뒤로 넣기

		documents.pop();
	}

	return cnt;
}



	// int main() {
	// cout << solution({2,1,3,2}, 2) << endl;
	// cout << solution({1,1,9,1,1,1}, 0) << endl;
	// }