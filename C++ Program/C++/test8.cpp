#include <bits/stdc++.h>
using namespace std;

class Car {
    private:
    string name;
    float price;
    int* ptr;
    int gl=1234;

    public:
    Car(){}
    Car(string name, float price) {
        this->name=name;
        this->price=price;
        ptr=&gl;
    }
    // shallowCopy
    void shallowCopy(Car &other){
        this->name=other.name;
        this->price=other.price;
        this->ptr=other.ptr;
    }
    // deepCopy
    void deepCopy(Car &other) {
        this->name=other.name;
        this->price=other.price;
        this->ptr=&gl;     
    }
    void display() {
        cout<<name<<"-"<<price<<"-"<<&ptr<<"-"<<*ptr<<"-"<<&(*ptr)<<endl;
    }
};

int main() {
    Car audi("Audi", 100);
    audi.display();

    Car maruti;
    maruti.shallowCopy(audi);
    maruti.display();
    maruti.deepCopy(audi);
    maruti.display();
    
    return 0;
}