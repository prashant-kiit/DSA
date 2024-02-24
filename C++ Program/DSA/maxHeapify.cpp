#include <iostream>
#include <vector>
using namespace std;

void maxHeapify(int a[], int n)
{
    int parent = 0, leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
    while (parent <= (n - 2) / 2 && (a[parent] < a[leftChild] && (rightChild > n - 1 || a[parent] < a[rightChild])))
    {
        // (rightChild <= n-1 && a[parent]<a[leftChild] && a[parent]<a[rightChild]) || (rightChild > n-1 && a[parent]<a[leftChild])
        // original print
        for (int i = 0; i < n; i++)
        {
            cout << a[i] << " ";
        }
        cout << endl;
        cout << "parent=" << parent << " left=" << leftChild << " right=" << rightChild << endl;

        // find biggest
        int biggest = parent;
        if (a[parent] < a[leftChild])
            biggest = leftChild;
        if (rightChild <= n - 1 && a[biggest] < a[rightChild])
            biggest = rightChild;
        cout << "biggest=" << biggest << endl;

        // swap
        if (biggest != parent)
        {
            int temp = a[parent];
            a[parent] = a[biggest];
            a[biggest] = temp;
            cout << "swapped" << endl;
        }

        // after swapping print
        for (int i = 0; i < n; i++)
        {
            cout << a[i] << " ";
        }

        parent = biggest;
        leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
        // cout<<endl<<parent<<" "<<biggest<<endl;
        // cout<<"parent="<<parent<<" left="<<leftChild<<" right="<<rightChild<<endl;
    }
}

int main()
{
    int arr[] = {1, 4, 3, 2, 5};
    int n = sizeof(arr) / sizeof(int);
    maxHeapify(arr, n - 1);
    return 0;
}