package com.main.tasks.gcd_lcm;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.util.Scanner;

// Greatest Common Divisor
// НОД — наибольшее число, которое является делителем одновременно для чисел a и b.
public class GCD extends BaseTask {
    @Override
    protected String inputFileName() {
        return "numbers.txt";
    }

    @Override
    protected void run() throws IOException {
        Scanner reader = readFile();
        long a = reader.nextLong();
        long b = reader.nextLong();
        System.out.println(findGCDEuclid(a, b));
    }

    private static long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private static long findGCDEuclid(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) return findGCDEuclid(a % b, b);
        if (b >= a) return findGCDEuclid(a, b % a);
        return 1;
    }

    // Классический алгоритм Евклида
    public static long classicEuclid(long a, long b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // Те же остатки, но без рекурсии
    public static long gcd_2(long a, long b) {
        long t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Бинарный алгоритм поиска НОД
    public static long gcd_4(long a, long b) {
        if (a == b)
            return a;
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if ((~a & 1) != 0) {
            if ((b & 1) != 0)
                return gcd_4(a >> 1, b);
            else
                return gcd_4(a >> 1, b >> 1) << 1;
        }
        if ((~b & 1) != 0)
            return gcd_4(a, b >> 1);
        if (a > b)
            return gcd_4((a - b) >> 1, b);
        return gcd_4((b - a) >> 1, a);
    }

    // Бинарный алгоритм на основе битовой арифметики
    public static long gcd_5(long a, long b) {
        int shift;
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        for (shift = 0; ((a | b) & 1) == 0; ++shift) {
            a >>= 1;
            b >>= 1;
        }
        while ((a & 1) == 0)
            a >>= 1;
        do {
            while ((b & 1) == 0)
                b >>= 1;
            if (a > b) {
                long t = b;
                b = a;
                a = t;
            }
            b = b - a;
        } while (b != 0);
        return a << shift;
    }
}
