#include <bits/stdc++.h>
using namespace std;

int main() {
    int a=9; // global
    {
        int b=5; //local
        a=a+9;
        cout<<a;
    }
    //b=b+5; // Error
    cout<<a;
    return 0;
}