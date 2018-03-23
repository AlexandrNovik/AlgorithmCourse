package com.main.tasks.sorts.base;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class BaseSortTask extends BaseTask {
    protected int[] array;

    protected abstract void sort(int[] values);

    @Override
    protected void run() throws IOException {
        array = Files
                .lines(Paths.get("unsorted.txt"))
                .mapToInt(Integer::parseInt)
                .toArray();
        printUnsortedArray(array);
        sort(array);
        printSortedArray(array);
    }

    protected void printSortedArray(int[] values) {
        System.out.print("Sorted array: ");
        printArray(values);
        System.out.println();
    }

    protected void printUnsortedArray(int[] values) {
        System.out.print("Unsorted array: ");
        printArray(values);
        System.out.println();
    }

    protected void swap(Integer i1, Integer i2) {
        int temp = array[i1];
        array[i1] = i2;
        array[i2] = temp;
    }

    private void printArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print("[" + values[i] + "] ");
        }
        System.out.print("}");
    }

}
