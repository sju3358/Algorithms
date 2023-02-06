#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef struct document {
	int index;
	int prioirty;
}Document;

bool isMaxPrioirty(queue<Document> documents,int cnt) {
	
	vector<Document> copiedDocuments;

	while(documents.empty() != true) {
		copiedDocuments.push_back(documents.front());
		documents.pop();
	}
	
	int prioirty = copiedDocuments[0].prioirty;

	for (int i = 1; i < copiedDocuments.size(); i++)
		if (copiedDocuments[i].prioirty > prioirty)
			return false;
	
	return true;
}

int main(void) {
	int T; cin >> T;

	while (T--) {
		
		queue<Document> documents;
		int cnt = 1;

		int n; int target;
		cin >> n >> target;
		
		for (int i = 0; i < n; i++) {
			int prioirty; cin >> prioirty;
			Document document;
			document.index = i;
			document.prioirty = prioirty;
			documents.push(document);
		}

		while (1) {

			if (isMaxPrioirty(documents,cnt)) {
				if (documents.front().index == target) {
					cout << cnt << endl;
					break;
				}
				else {
					documents.pop();
					cnt++;
				}
			}
			else {
				documents.push(documents.front());
				documents.pop();
			}

		}
	}
}