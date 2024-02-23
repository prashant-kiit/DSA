// Online C++ compiler to run C++ program online
#include <bits/stdc++.h>
using namespace std;
int wow=7;
class Singleton {
    private:
    Singleton() {}
    static Singleton s_instance;
    public:
    static Singleton* getInstance1() {
        //cout<<&s_instance<<endl;
        return &s_instance;
    }
    static Singleton& getInstance2() {
        
        //cout<<&s_instance<<endl;
        return s_instance;
    }
    static Singleton getInstance3() {
        //cout<<&s_instance<<endl;
        return s_instance;
    }
    int sample;
};
Singleton Singleton::s_instance;
class Base {
    public:
    Base(){}
    int baseVar;
    //void display()  {} // method hiding
    //virtual void display()  {} // method overidding
    virtual void display()=0; // Pure virtual
};
class Derived: public Base{
    public:
    int DerivedVar;
    void display() {
        cout<<"Derived class "<<DerivedVar;
    }
    void random();
};
class XYZ {
    int some=2;
    static int count;
    public:
    // static int count=9; cannot initialize a static member inside class
    static void counter() { 
        cout<<wow; // globla wow is access by static func without being static
    // Outside definition of static function is not required 
    // b/c anyway a function is defined outside the class in Method Segment in memory in C++
        count++;
        // cout<<some; static function cannot access non-satic variable
    }
    void someth() {
        cout<<some;
        cout<<count; // non static function can have both static and non static member
    }
};
int XYZ::count=8*2; // can initialize a static member outside class
// Return pointer/address
int* fun1(int x) {
    int* p=&x;
    cout<<"Ans ptr 1 "<<p<<" "<<*p<<endl;
    return p;
}
// Return reference/alias
int& fun2(int x) {
    int& p=x;
    cout<<"Ans ref 1 "<<p<<" "<<&p<<" "<<&x<<endl;
    return p;
}
// Return pointer value
int fun3(int x) {
    int* p=&x;
    cout<<"Ans value 1 "<<p<<" "<<*p<<endl;
    return *p;
}

// Important: reference intialized by pointer's target value
int& fun4(int x) {
    int* p=&x;
    cout<<"Ans ref/pointer 1 "<<p<<" "<<*p<<" "<<&x<<endl;
    return *p;
}
int main(){
    // Singleton // Same object with different instance pointers
    // Singleton* s1=Singleton::getInstance1();
    // Singleton* s2=Singleton::getInstance1();
    // // Singleton // Same instance with different aliases
    // Singleton& s3=Singleton::getInstance2();
    // Singleton& s4=Singleton::getInstance2();
    // // Non-Singleton // Duplicate instances are formed
    // Singleton s5=Singleton::getInstance3();
    // Singleton s6=Singleton::getInstance3();
    // s1->sample=2;
    // cout<<s2->sample;
    // int a=9;
    XYZ xyz, xy, x;
    // xyz.count++;
    // xy.count++;
    // x.count++;
    // XYZ::count++;
    xyz.counter();
    // Base b; // object of abstract class type "Base" is not allowed
    // cout<<x.count<<endl;
    // xy.counter();
    // cout<<xy.count<<endl;
    // x.counter();
    // cout<<XYZ::count<<endl;
    // int* ptr=fun1(2);
    // cout<<"Ans ptr 2 "<<ptr<<" "<<*ptr<<endl;
    // int& pt=fun2(22);
    // cout<<"Ans ref 2 "<<pt<<" "<<&pt<<endl;
    // int poi=fun3(222);
    // cout<<"Ans value 2 "<<poi<<" "<<&poi<<endl;
    // int* pointer=new int();
    // int& reference=*pointer; // Important: reference intialized by pointer's target value
    // cout<<reference;
    // int& poit=fun4(2222);
    // cout<<"Ans ref/pointer 2 "<<poit<<" "<<&poit<<endl;
    // Base* ob;
    // Derived od;
    // ob=&od; // Upcasting
    // od.DerivedVar=90;
    // ob->display();
    // int a=0;
    // int* ptr;
    // *(ptr+0)=25;
    // *(ptr+1)=25;
    // int a=9; // Error
    // cout<<"1."<<a<<endl;
    // {
    //     a=a+1; // Correct
    //     cout<<"2."<<a<<endl;
    // }
    // cout<<"3."<<a<<endl;
    // string a="abc";
    return 0;
}