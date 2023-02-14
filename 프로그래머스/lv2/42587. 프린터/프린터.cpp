	#include <iostream>
	#include <vector>
	#include <queue>
	using namespace std;


	typedef struct document {
		int index;
		int prioirty;
	}Document;

	bool isMaxPrioirty(queue<Document> documents, int cnt) {

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

		for (int i = 0; i < priorities.size(); i++) 
			documents.push({ i, priorities[i] });
	
	
		bool isMaxPrioirtyFlag = isMaxPrioirty(documents, cnt);
		while(isMaxPrioirtyFlag != true || documents.front().index != location){

			if(isMaxPrioirtyFlag == true)
					cnt++;
			else 
				documents.push(documents.front());

			documents.pop();
			isMaxPrioirtyFlag = isMaxPrioirty(documents, cnt);
		}

		return cnt;
	}



	 // int main() {
	 // cout << solution({2,1,3,2}, 2) << endl;
	 // cout << solution({1,1,9,1,1,1}, 0) << endl;
	 // }