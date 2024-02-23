#include <bits/stdc++.h>
using namespace std;

class Base {
    public:
    static void fun() { // only nonstatic member functions may be virtual
        cout<<"This is func()in Class Base"<<endl;
    } // Method Hiding

    static void fun2() {
        cout<<"This is fun2()in Class Base inherited to Class Child"<<endl;
    } // Static method can be inherited
};

class Child: public Base {
    public:
    static void fun() {
        cout<<"This is func()in Class Child"<<endl;
    } // Method Hidden
};

int main() {
    Child child1;
    Base base1;
    Base* base2=new Child();
    base1.fun();
    base1.fun2();
    child1.fun(); 
    child1.fun2(); // Static method inherited
    base2->fun(); // Method Hiding
    vector<int> vec;
    string str;
    return 0;
}