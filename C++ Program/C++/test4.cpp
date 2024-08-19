
#include <bits/stdc++.h>
using namespace std;
int main() {
    //[](int a){cout<<a*2<<endl;};
    int m=3; // Accesses the varibale from immediate scope
    vector<int> v={1,2,3,4,5};
    // capture caluse can be used get multiple paramters in lambada functions
    for_each(v.begin(), v.end(), [m](int a){ // removes use of overhead for function // m is immutable
        cout<<a*m<<endl;
        }
    );
    for_each(v.begin(), v.end(), [&m](int a){ // removes use of overhead for function // m is mutable
        m=5;
        cout<<a*m<<endl;
        }
    );
    cout<<m<<endl;
}