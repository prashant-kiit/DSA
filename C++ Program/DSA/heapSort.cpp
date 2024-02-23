#include <iostream>
#include <vector>
using namespace std;

int a[] = {1, 2, 3, 4, 5};
int n = sizeof(a) / sizeof(int);
int m = n;

void maxHeapify(int root)
{

    int parent = root, leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
    while (parent <= (n - 2) / 2 && (a[parent] < a[leftChild] && (rightChild > n - 1 || a[parent] < a[rightChild])))
    {

        // find biggest
        int biggest = parent;
        if (a[parent] < a[leftChild])
            biggest = leftChild;
        if (rightChild <= n - 1 && a[biggest] < a[rightChild])
            biggest = rightChild;

        // swap
        if (biggest != parent)
        {
            int temp = a[parent];
            a[parent] = a[biggest];
            a[biggest] = temp;
        }

        parent = biggest;
        leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
    }
}

void buildMaxHeapify()
{

    // traverse from last parent element to first parent element
    for (int i = (n - 2) / 2; i >= 0; i--)
    {
        // max heapify each element
        maxHeapify(i);
    }
    for (int i = 0; i < 5; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
}

void maxExtract()
{

    // swap
    int temp = a[0];
    a[0] = a[n - 1];
    a[n - 1] = temp;

    // resize
    n--;

    // max heapify(0)
    maxHeapify(0);
}

void heapSort()
{

    // build max heap
    buildMaxHeapify();

    // max extract and place max element at correct postion
    for (int i = 0; i < n; i++)
        maxExtract();

    // arranage last two elements
    if (a[0] > a[1])
    {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

    // print the sorted array
    for (int i = 0; i < m; i++)
    {
        cout << a[i] << " ";
    }
}

int main()
{
    heapSort();
    return 0;
}