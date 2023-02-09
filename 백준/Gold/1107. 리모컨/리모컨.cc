#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <algorithm>
using namespace std;


int cost1 = 0;
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

	sort(usableButtons.rbegin(), usableButtons.rend());

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

bool isInUsableButtons(int targetButton, vector<int> usableButtons) {
	
	for (int i = 0; i < usableButtons.size(); i++)
		if (usableButtons[i] == targetButton)
			return true;
	return false;
}

bool isInbrokenButtons(int targetButton, vector<int> brokenButtons) {

	for (int i = 0; i < brokenButtons.size(); i++)
		if (brokenButtons[i] == targetButton)
			return true;
	return false;
}

bool canMakeChannelWithButtons(int targetChannel, vector<int> usableButtons) {
	while (targetChannel) {
		if (isInUsableButtons(targetChannel % 10, usableButtons) == false)
			return false;

		targetChannel = targetChannel / 10;
	}
	return true;

}

void getCost1(int targetChannel) {
	cost1 = getABS(targetChannel, 100);
}

void getCost2(int targetChannel, vector<int> usableButtons) {
	

	if (targetChannel != 0 && canMakeChannelWithButtons(targetChannel, usableButtons)) {
		cost2 = getLength(targetChannel);
	}
	else if (usableButtons.size() > 0) {
		getCost("", to_string(targetChannel), usableButtons);
		getCostLonger(0, targetChannel, usableButtons);
		getCostShorter(0, targetChannel, usableButtons);
	}
}


int main(void) {

		int targetChannel;
		vector<int> usableButtons;
		vector<int> brokenButtons;

		cin >> targetChannel;
		int n; cin >> n;

		for (int i = 0; i < n; i++) {
			int brokenBuuton; cin >> brokenBuuton;
			brokenButtons.push_back(brokenBuuton);
		}
		sort(brokenButtons.begin(), brokenButtons.end());


		
		for (int button = 0; button <= 9; button++) 
			if (isInbrokenButtons(button,brokenButtons) == false)
				usableButtons.push_back(button);
		


		sort(usableButtons.begin(), usableButtons.end());


		getCost1(targetChannel);
		getCost2(targetChannel, usableButtons);
		

		cout << (cost1 < cost2 ? cost1 : cost2) << endl;

}