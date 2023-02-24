#include <vector>
#include <iostream>

using namespace std;


vector<vector<char>> binaryTree;


void preOrderTravel(char curNode) {
	if (curNode == '.')
		return;

	cout << curNode;
	preOrderTravel(binaryTree[curNode - 'A'][0]);
	preOrderTravel(binaryTree[curNode - 'A'][1]);
}

void inOrderTravel(char curNode) {
	if (curNode == '.')
		return;

	inOrderTravel(binaryTree[curNode - 'A'][0]);
	cout << curNode;
	inOrderTravel(binaryTree[curNode - 'A'][1]);
}

void postOrderTravel(char curNode){
	if (curNode == '.')
		return;
	
	postOrderTravel(binaryTree[curNode - 'A'][0]);
	postOrderTravel(binaryTree[curNode - 'A'][1]);
	cout << curNode;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);	

	int n; cin >> n;
	
	for (int i = 0; i < n; i++) {
		binaryTree.push_back({});
	}

	for (int i = 0; i < n; i++) {
		char parent;
		char left;
		char right;
		cin >> parent >> left >> right;

		binaryTree[parent - 'A'].push_back(left);
		binaryTree[parent - 'A'].push_back(right);
	}

	preOrderTravel('A'); 
	cout << "\n";
	inOrderTravel('A');
	cout << "\n";
	postOrderTravel('A');
	cout << "\n";
}