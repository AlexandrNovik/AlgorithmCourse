package com.main.tasks.fibonacci;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
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

    private static BigInteger fibonacci(final int n) {
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);
        if (n < 2) return BigInteger.valueOf(n);
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
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

    private static final HashMap<Integer, BigInteger> cache = new HashMap<>();

    private static BigInteger fibRecursive(int n) {
        if (n < 2) return BigInteger.valueOf(n);
        if (!cache.containsKey(n)) {
            for (int i = 2; i <= n; i++) {
                BigInteger result = fibRecursive(i - 1).add(fibRecursive(i - 2));
                cache.put(i, result);
            }
        }
        return cache.get(n);

    }
}
