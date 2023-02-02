#include <iostream>
#include <string>
using namespace std;
int main(void){
    string input; cin>> input;
    for(int i = 0; i <input.length(); i++){
        if('a' <= input[i] && input[i] <= 'z')
            input[i] = input[i] -('a' - 'A');
        else
            input[i] = input[i] +('a' - 'A');
    } 
    cout << input;
}