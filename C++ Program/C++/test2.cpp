#include <bits/stdc++.h>
using namespace std;
int vam=789;
class B {    
    public:
    int x;
    B(int temp) {
        x=temp;
    }
};
// Java Main Class
class A {
    static B b3;
    static int l;
    public:
    // Java main()
    class Inner {
        private:
        int abc=12345;
        public:
        int lmn=9876;
        static void checker() {
            //cout<<lmn*10; non-ststic and local lmn is not accessible to static checker()
        }

    };
    static void start() {
        B* b1=new B(8);
        B* b2=new B(10);
        //cout<<b3.x<<endl;
        //l=0;
        //cout<<l<<endl;
        vam++; // static can access global variable
        cout<<b1->x<<endl;
        Inner inner;
        //cout<<inner.abc; // abc is private so not accessible
        cout<<inner.lmn<<endl; // lmn is public so accessible // lmn is not static but global to start() so
        // start() can access it
    }
};
// Java OS
int main() {
    A::start(); // Using SRO not Dot // Jav will use Dot
}