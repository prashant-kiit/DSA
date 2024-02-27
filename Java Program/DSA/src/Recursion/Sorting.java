package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sorting {

    public static void main(String[] args) throws InterruptedException {
        // int[] arr = { 5, 7, 3, 10, 2, 1, 5 };
        int[] arr = { 10, 20, 30, 40, 50, 100, 200, 300, 4 };
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        // new Main().pattern(0, 0);
        // new Main().series(10);
        // new Main().bubbleSort(arr, 0, 0);
        // System.out.println(new Main().maximum(arr, arr.length));
        // new Main().selectionSort(arr, 0, 0);
        // arr = new Main().mergeSort(arr, 0, arr.length - 1);
        new Main().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        // Main m = new Main();
        // m.phoneCombination("23", map, 0, "");
        // System.out.println(m.result);
        // System.out.println(new Main().numRollsToTarget(30, 30, 500));
    }
}

class Main {
    void pattern(int i, int j) throws InterruptedException {
        if (i == 3 && j == 1) {
            System.out.print("\nLast(" + i + "," + j + ")\n");
            return;
        }
        if (i + j > 3) {
            System.out.print("\nBreak(" + i + "," + j + ")\n");
            pattern(i + 1, 0);
        } else {
            System.out.print("* (" + i + "," + j + ")");
            Thread.sleep(1500);
            pattern(i, j + 1);
            System.out.print("End(" + i + "," + j + ")\n");
        }
    }

    void series(int n) {
        if (n < 0) {
            return;
        }
        System.out.println(n);
        series(n - 1);
    }

    void bubbleSort(int[] arr, int i, int j) throws InterruptedException {
        if (i == arr.length - 2 && j == 0) {
            return;
        }
        if (i + j > arr.length - 2) {
            bubbleSort(arr, i + 1, 0);
        } else {
            if (arr[j + 1] < arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSort(arr, i, j + 1);
        }
    }

    int maximum(int[] arr, int n) {
        if (n == 0) {
            return Integer.MIN_VALUE;
        }
        return Math.max(arr[n - 1], maximum(arr, n - 1));
    }

    // int[] arr = { 5, 3, 7, 2, 10, 1, 5 };
    int highest = Integer.MIN_VALUE;
    int highestIndex = -1;

    void selectionSort(int[] arr, int i, int j) {
        if (i == arr.length - 1) {
            return;
        }
        if (i + j > arr.length - 1) {
            if (arr[arr.length - 1 - i] != arr[highestIndex]) { // to make it stable
                int temp = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = arr[highestIndex];
                arr[highestIndex] = temp;
            }
            highest = Integer.MIN_VALUE;
            highestIndex = -1;
            selectionSort(arr, i + 1, 0);
        } else {
            if (arr[j] > highest) {
                highest = arr[j];
                highestIndex = j;
            }
            // highest = Math.max(arr[j], highest); // unstable
            highest = arr[j] >= highest ? arr[j] : highest; // stable
            selectionSort(arr, i, j + 1);
        }
    }

    int[] mergeSort(int[] arr, int i, int j) {
        int mid = (i + j) / 2;
        if (i == j) {
            int[] temp = new int[1];
            temp[0] = arr[mid];
            return temp;
        }
        return merge(mergeSort(arr, i, mid), mergeSort(arr, mid + 1, j));
    }

    private int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                mix[k] = first[i];
                i++;
                k++;
            } else {
                mix[k] = second[j];
                j++;
                k++;
            }
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

    void quickSort(int[] arr, int low, int high) {
        if (high < low) {
            return;
        }
        int s = low, e = high, mid = (s + e) / 2;
        while (s <= e) {
            while (arr[s] < arr[mid]) {
                s++;
            }
            while (arr[e] > arr[mid]) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }

    ArrayList<String> result = new ArrayList<String>();

    void phoneCombination(String dial, Map<Character, String> map, int i, String combination) {
        if (i > dial.length() - 1) {
            result.add(combination);
            // System.out.println(combination);
            return;
        }
        String pad = map.get(dial.charAt(i));
        pad.substring(1);
        for (int j = 0; j < pad.length(); j++) {
            phoneCombination(dial, map, i + 1, combination + pad.charAt(j));
        }
    }

    int count = 0;

    void diceRoll(int total_rounds, int target, int dice_cap, int round, int sum) {
        // System.out.println(round);
        // Thread.sleep(1000);
        if (round > total_rounds) {
            if (sum == target) {
                count++;
            }
            return;
        }
        for (int num = 1; num <= Math.min(dice_cap, target); num++) {
            diceRoll(total_rounds, target, dice_cap, round + 1, sum + num);
        }
    }

    public int numRollsToTarget(int n, int k, int target) {
        diceRoll(n, target, k, 1, 0);
        return count;
    }
}
