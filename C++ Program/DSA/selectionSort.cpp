#include <iostream>
#include <vector>
using namespace std;

void selectionSort(int a[], int n)
{
    int maxi = INT_MIN, lastPos = n - 1, maxiPos;

    for (int i = 0; i <= lastPos; i++)
    {

        for (int i = 0; i <= lastPos; i++)
        {
            maxi = max(maxi, a[i]);
        }
        for (int i = 0; i <= lastPos; i++)
        {
            if (a[i] == maxi)
            {
                maxiPos = i;
            }
        }

        int temp = a[lastPos];
        a[lastPos] = a[maxiPos];
        a[maxiPos] = temp;

        maxi = INT_MIN;
        lastPos--;
    }

    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
}

int main()
{
    int arr[] = {4, 5, 1, 3, 2};
    int n = sizeof(arr) / sizeof(int);
    selectionSort(arr, n);
    return 0;
}