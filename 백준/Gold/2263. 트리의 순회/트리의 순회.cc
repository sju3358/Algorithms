#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


vector<int> inOrder;
vector<int> postOrder;
unordered_map<int, int> inOrderIndex;


void preOrder(int postOrderStart, int postOrderEnd, int inOrderStart, int inOrderEnd) {

	if (postOrderStart > postOrderEnd || inOrderStart > inOrderEnd)
		return;
	
	int root = postOrder[postOrderEnd];

	cout << root << " ";

	int rootIndexOfInOrder = inOrderIndex.find(root)->second;
	
	int leftSize = rootIndexOfInOrder - inOrderStart;
	int rightSize = inOrderEnd - rootIndexOfInOrder;
	
	preOrder(postOrderStart, postOrderStart + leftSize-1,inOrderStart, rootIndexOfInOrder-1);
	preOrder(postOrderEnd - rightSize, postOrderEnd-1,rootIndexOfInOrder+1, inOrderEnd);


}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);


	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		int input; cin >> input;
		inOrderIndex.insert(make_pair(input, i));
	}

	for (int i = 0; i < n; i++) {
		int input; cin >> input;
		postOrder.push_back(input);
	}

	preOrder(0,postOrder.size()-1,0,postOrder.size()-1);

}