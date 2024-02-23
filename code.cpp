#include <iostream>
#include <vector> 
using namespace std;

class Heap {
    
    private:
    vector<int> container;
    int size;
    
    public:
    Heap(vector<int> container) {
        this->container=container;
        size=container.size();
    }
    
    void print() {
        for (int element : container) 
            cout << element << " "; 
        cout<<endl;
    }
    
    int length() {
        return size;
    }
    
    bool isHeapHelper(vector<int> container, int index) {
        if(2*index+2 > container.size() - 1) {
            if (2*index+1 == container.size()-1) {
                bool bc=container[index] < container[2*index+1];
                return container[index] < container[2*index+1];
            }
            else 
                return true;
        }
        
        bool leftCheck=container[index] < container[2*index+1];
        bool rightCheck=container[index] < container[2*index+2];
        bool rootCheck=leftCheck && rightCheck;
        bool recursiveLeftCheck=isHeapHelper(container, 2*index+1);
        bool recursiveRightCheck=isHeapHelper(container, 2*index+2);
        bool recursiveCheck=recursiveLeftCheck && recursiveRightCheck;
        return rootCheck && recursiveCheck;

    }
    
    bool isHeap(Heap* heap) {
        return isHeapHelper(heap->container, 0);
    }
    
    vector<int> verify (vector<int> container, int index) {

        if (index == 0)
            return container;

        if (index > 0 && container[index] > container[(index - 1) / 2]) {
            return container;
        }
        
        int temp=container[index];
        container[index]=container[(index - 1) / 2];
        container[(index - 1) / 2]=temp;
            
        return verify(container, (index - 1) / 2);
    }
    void insert(int value) {
        container.push_back(value);
        size=container.size();
        if (container.size() - 1 > 0)
            container=verify(container, container.size() - 1);
    } // O(logn)
    
    void remove(int index) {
        if (index < container.size()) {
             container.erase(container.begin()+index);
             size=container.size();
             // heapify // O(nlogn)
             for (int i=0; i<container.size(); i++)
                container=verify(container, i);
        }
        else 
            cout<<"Error"<<endl;
    }
    
    // heapify for single element
    vector<int> heapify(vector<int> container, int rootIndex) {
        
        if ( (container[rootIndex] > container[2*rootIndex+1]) || (container[rootIndex] > container[2*rootIndex+2]) ) {
        
            if ( container[2*rootIndex+1] < container[2*rootIndex+2] ) {
                int temp=container[rootIndex];
                container[rootIndex]=container[2*rootIndex+1];
                container[2*rootIndex+1]=temp;
                
                return heapify(container, 2*rootIndex+1);
            }
            
            if ( container[2*rootIndex+1] > container[2*rootIndex+2] ) {
                int temp=container[rootIndex];
                container[rootIndex]=container[2*rootIndex+2];
                container[2*rootIndex+2]=temp;
                
                return heapify(container, 2*rootIndex+2);
            }
            
        }

        return container;
    } // O(logn)

    void heapifyFromBottom(int index) {

        // container[index]=value;
        // cout<<"index = "<<index<<endl;
        // cout<<"parent = "<<container[(index - 1) / 2]<<endl;
        // cout<<"child = "<<container[index]<<endl;
        // cout<<"condition = "<<((index > 0) && (container[(index - 1) / 2] >= container[index]))<<endl; 

        while (index > 0 && container[(index - 1) / 2] >= container[index]) {
            
            int tmp = container[(index - 1) / 2];
            container[(index - 1) / 2] = container[index];
            container[index] = tmp;

            index = (index - 1) / 2;

        }

    } // O(logn)

    void decreaseKey(int index, int value) {
        container[index]=value;
        heapifyFromBottom(index);
    }

    void remove2(int index) {

        int temp = container[index];
        container[index] = container[container.size() - 1];
        container[container.size() - 1] = temp;

        container.pop_back();
        
        size=container.size();

        if (container[index] < container[(index - 1) / 2])
            heapifyFromBottom(index);
        if (container[index] > min(container[2*index+1], container[2*index+2]))
            container = heapify(container, index);
    }
};

int main() {
	// declaration and initizalize
	    // vector
	    // class
	    // constructor
	    // size
	    // assign custom value
    // Important Heap operation
        // heapify from top
        // heapify from bottom  
        // decrease key=heapify from bottom 
        // extract min=heapify from top
        // insert=heapify from bottom
        // delete=decrease key+extract min
        // minHeapify=heapify from top for the 0th element
        // build heap = 1. minheapify starting from the end OR
        // O(n) not O(nlogn) 2. insert algo starting from the start
        // ( minHeapify from start and insert from end are also possible )
        
	vector<int> container={10, 20, 15, 40, 50, 100, 25, 45};
	Heap* heap=new Heap(container);
	heap->print();
	// check
	// cout<<"isHeap "<<heap->isHeap(heap)<<endl;
	// insert
	// heap->insert(12);
	// heap->print();
	// cout<<heap->length()<<endl;
	// delete
    // heap->remove(2);
    heap->remove2(2);
    heap->print();
    // cout<<heap->length()<<endl;
    // heap->decreaseKey(3, 5);
    // heap->print();
	return 0;
}