#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <algorithm>
using namespace std;

int cost2 = 500001;



int getABS(int a, int b) {
	return a > b ? a - b : b - a;
}


int getLength(int n) {
	if (n == 0)
		return 1;


	int cnt = 0;
	while (n) {
		n = n / 10;
		cnt++;
	}
	return cnt;
}

void getCost(string curChannel, string targetChannel, vector<int> usableButtons) {

	if (curChannel.length() == targetChannel.length()) {


		while (curChannel[0] == '0')
			curChannel = curChannel.substr(1, curChannel.length() - 1);

		if (curChannel.length() == 0)
			curChannel = "0";

		int cost = curChannel.length() + getABS(stoi(targetChannel), stoi(curChannel));
		if (cost2 > cost)
			cost2 = cost;
	}
	else {


		for (int i = 0; i < usableButtons.size(); i++) {

			getCost(curChannel + to_string(usableButtons[i]), targetChannel, usableButtons);

		}
	}

}

void getCostLonger(int curChannel, int targetChannel, vector<int> usableButtons) {

	if (usableButtons.size() == 1) {
		if (usableButtons[0] == 0)
			return;
		else
			curChannel = curChannel * 10 + usableButtons[0];
	}
	else {
		if (usableButtons[0] == 0)
			curChannel = curChannel * 10 + usableButtons[1];
		else
			curChannel = curChannel * 10 + usableButtons[0];
	}


	if (usableButtons.size() >= 1) {
		while (getLength(curChannel) <= getLength(targetChannel)) {
			curChannel = curChannel * 10 + usableButtons[0];
		}
	}

	int cost = getLength(curChannel) + curChannel - targetChannel;
	if (cost2 > cost)
		cost2 = cost;

}

void getCostShorter(int curChannel, int targetChannel, vector<int> usableButtons) {

	if (getLength(targetChannel) == 1)
		return;

	if (usableButtons.size() == 1) {
		if (usableButtons[0] == 0)
			return;
		else
			curChannel = curChannel * 10 + usableButtons[0];
	}
	else {
		if (usableButtons[0] == 0)
			curChannel = curChannel * 10 + usableButtons[1];
		else
			curChannel = curChannel * 10 + usableButtons[0];
	}


	if (usableButtons.size() >= 1) {
		while (getLength(curChannel) != getLength(targetChannel) - 1) {
			curChannel = curChannel * 10 + usableButtons[0];
		}
	}

	int cost = getLength(curChannel) + targetChannel - curChannel;
	if (cost2 > cost)
		cost2 = cost;

}


int main(void) {

	bool test = false;
	do{

		int curChannel = 100;
		int targetChannel;
		vector<int> usableButtons;
		vector<int> rusableButtons;
		set<int> brokenButtons;

		cin >> targetChannel;
		int n; cin >> n;

		for (int i = 0; i < n; i++) {
			int brokenBuuton; cin >> brokenBuuton;
			brokenButtons.insert(brokenBuuton);
		}

		for (int i = 0; i <= 9; i++) {
			set<int>::iterator isBroken = brokenButtons.find(i);
			if (isBroken == brokenButtons.end()) {
				usableButtons.push_back(i);
				rusableButtons.push_back(i);
			}
		}

		int cost1 = getABS(targetChannel, curChannel);


		sort(usableButtons.begin(), usableButtons.end());
		sort(rusableButtons.rbegin(), rusableButtons.rend());


		bool flag = true;
		int target = targetChannel;
		while(target){
			set<int>::iterator isBroken = brokenButtons.find(target % 10);
			if (isBroken != brokenButtons.end()) {
				flag = false;
				break;
			}
			target = target / 10;
		}

		if (targetChannel && flag) {
				cost2 = getLength(targetChannel);
		}
		else if (usableButtons.size() != 0) {
			getCost("", to_string(targetChannel), usableButtons);
			getCostLonger(0, targetChannel, usableButtons);
			getCostShorter(0, targetChannel, rusableButtons);
		}
		cout << (cost1 < cost2 ? cost1 : cost2);
		cost2 = 500001;

	} while (test);

}