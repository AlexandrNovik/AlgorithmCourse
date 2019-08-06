package com.main.tasks.dynamic;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.util.Scanner;

public class Combinations extends BaseTask {
    @Override
    protected void run() throws IOException {
        Scanner reader = readFile();
        String[] a = reader.nextLine().split(" ");
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        int r = reader.nextInt();
        int n = arr.length;
        printCombination(arr, n, r);
    }

    @Override
    protected String inputFileName() {
        return "dynamic.txt";
    }

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }
}
