package com.main.tasks.dynamic;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.util.Scanner;

/*
 * prints all combinations in array
 */
public class Combinations extends BaseTask {
    @Override
    protected void run() throws IOException {
        Scanner reader = readFile();
        String[] a = reader.nextLine().split(" ");
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        int combinationSize = reader.nextInt();
        calculateCombinations(arr, combinationSize);
    }

    @Override
    protected String inputFileName() {
        return "combinations.txt";
    }

    private static void combinationRecursive(int[] arr,  // arr[]  ---> Input Array
                                             int[] data, // data[] ---> Temporary array to store current combination
                                             int start,  // start & end ---> Staring and Ending indexes in arr[]
                                             int end,
                                             int index, // index  ---> Current index in data[]
                                             int combinationSize // combinationSize ---> Size of a combination to be printed
    ) {
        // Current combination is ready to be printed, print it
        if (index == combinationSize || (start > 0) && arr.length < combinationSize) {
            print(data, combinationSize);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= combinationSize-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end; i++) {
            data[index] = arr[i];
            combinationRecursive(arr, data, i + 1, end, index + 1, combinationSize);
        }
    }

    private static void print(int[] data, int combinationSize) {
        for (int j = 0; j < combinationSize; j++)
            System.out.print(data[j] + " ");
        System.out.println();
    }

    // The main function that prints all combinations of size combinationSize
    // in arr[] of size n. This function mainly uses combinationRecursive()
    private static void calculateCombinations(int[] arr, int combinationSize) {
        // A temporary array to store all combination one by one
        int[] data = new int[combinationSize];

        // Print all combination using temporary array 'data[]'
        combinationRecursive(arr, data, 0, arr.length - 1, 0, combinationSize);
    }
}
