#include <iostream>
using namespace std;
class Checker
{
    public:
    int n = 10;
    void foo()
    {
        int n = 90;
        cout << n;
    }
};

int main() {
    Checker c;
    cout<<"\n"<<c.n<<"\n";
    c.foo();

    Checker* ch = new Checker();
    cout<< ch->n << "\n";
    ch->foo();
    
    return 0;
}