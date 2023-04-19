#include <vector>
#include <iostream>

using namespace std;

typedef struct node{
    node* left = NULL;
    node* right = NULL;
    int value = -1;
}Node;


Node* root = new Node;

void postTravel(Node* cur){

    if(cur->left != NULL)
        postTravel(cur->left);
    if(cur->right != NULL)
        postTravel(cur->right);

    cout << cur->value << "\n";
}

void insertValue (int element, node * cur){

    if(cur->value == -1) {
        cur->value = element;
        return;
    }

    if(element < cur->value) {

        if(cur->left == NULL)
            cur->left = new Node;

        insertValue(element, cur->left);
    }
    else if(element > cur->value) {
        if(cur->right == NULL)
            cur->right = new Node;

        insertValue(element, cur->right);
    }
}

int main (){

    int rootValue; cin >> rootValue;
    root->value = rootValue;

    int element;
    while((cin >> element).eof() != true)
        insertValue(element,root);

    postTravel(root);
}