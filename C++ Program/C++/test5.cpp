
#include <bits/stdc++.h>
using namespace std;

int main() {

    // Static(alloc and init) array, Mutable
    int a1[5]={1,2,3,4,5};
    for(int i=0; i<5;i++) {
        cout<<a1[i]<<" ";
    }
    // Dynamic(alloc and init) array, Mutable
    float* a2=new float[5];
    for(int i=0; i<6;i++) {
        *(a2+i)=i+1;
    }
    for(int i=0; i<7;i++) {
        cout<<a2[i]<<" ";
    }
    // Static(alloc and init) OR Dynamic(alloc and init) Class, Immutable
    vector<double> v={1,2,3,4,5};
        v.push_back(6);
        for(int i=0; i<7;i++) {
        cout<<v[i]<<" ";
    }
}