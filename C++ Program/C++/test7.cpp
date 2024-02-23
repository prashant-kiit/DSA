#include <bits/stdc++.h>
using namespace std;
void fun() {   
    throw 100;
}
int main() {

    int a=0, b=6;
    //Shorter Exp Handling
    if (a==0 || b==0) {
        cout<<"Errorcode = "<<100<<" : ZeroAsInput"<<endl;
        throw;
    }    
    // Longer Exp Handling
    try {
        if (a==0 || b==0) 
            fun();
        if (a==-1 || b==-1) 
            throw 200;
    }    
    catch(int e) {
        if (e==100) {
            cout<<"ErrorCode = "<<e<<" : ZeroAsInput"<<endl;
            throw;
        }
        if (e=200) {
            cout<<"Warning = "<<e<<" : NegativeAsInput"<<endl;
        }
    }

    cout<<a+b<< endl;

    return 0;
}
