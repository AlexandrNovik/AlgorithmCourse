package com.main.tasks.fibonacci;

import com.main.tasks.BaseTask;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FibonacciSimpleNumber extends BaseTask {

    @Override
    protected void run() throws IOException {
        Scanner reader = readFile();
        int n = reader.nextInt();
        System.out.println(fibonacci(n));
    }
    @Override
    protected String inputFileName() {
        return "fibonacci.txt";
    }
    private static int fibonacci(final int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int fibonacciArray(final int n) {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 1;
        array[2] = 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        for (int i = 2; i < n; i++) {
            array[2] = array[0] + array[1];
            array[0] = array[1];
            array[1] = array[2];
        }
        return array[2];
    }

    private static int fibRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
}
