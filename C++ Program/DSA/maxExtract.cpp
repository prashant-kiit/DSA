#include <iostream>
#include <vector>
using namespace std;

void maxHeapify(int a[], int n)
{
    int parent = 0, leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
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

    cout << "Final array:" << endl;
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
}

void maxExtract(int a[], int n)
{
    // get max element
    cout << "max element=" << a[0] << endl;

    // swap
    int temp = a[0];
    a[0] = a[n - 1];
    a[n - 1] = temp;

    // resize
    n--;

    // max heapify(0)
    maxHeapify(a, n);
}

int main()
{
    int arr[] = {5, 4, 3, 2, 1};
    int n = sizeof(arr) / sizeof(arr[0]);
    maxExtract(arr, n);
    return 0;
}