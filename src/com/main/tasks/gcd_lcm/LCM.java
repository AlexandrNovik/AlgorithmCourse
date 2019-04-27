package com.main.tasks.gcd_lcm;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.util.Scanner;

// НОК — наименьшее число, которое делится на a и b без остатка.
public class LCM extends BaseTask {
    @Override
    protected String inputFileName() {
        return "numbers.txt";
    }

    @Override
    protected void run() throws IOException {
        Scanner reader = readFile();
        long a = reader.nextLong();
        long b = reader.nextLong();
        System.out.println(findLCM(a, b));
    }

    private static long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private static long GCD_2(long a, long b) {
        long t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static long findLCM(long a, long b) {
        long lcm = (a * b) / GCD_2(a, b);
        return lcm;
    }
}

