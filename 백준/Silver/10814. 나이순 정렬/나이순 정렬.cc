#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

typedef struct person {
	int age;
	int index;
	string name;
}Person;

bool compare(Person a, Person b) {

	if (a.age != b.age)
		return a.age < b.age;
	else
		return a.index < b.index;

}

int main(void) {
	
	int n; cin >> n;
	int index = 0;
	
	vector<Person> list;

	for (int i = 0; i < n; i++){
		int age; cin >> age;
		string name; cin >> name;
		Person p = { age,index++,name };
		list.push_back(p);
	}

	stable_sort(list.begin(), list.end(), compare);

	for (Person p : list)
		cout << p.age << " " << p.name << "\n";

	
}