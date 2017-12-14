package com.main.tasks.fibonacci;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.util.Scanner;

//Даны целые числа 1≤n≤10181≤n≤1018 и 2≤m≤1052≤m≤105, необходимо
// найти остаток от деления nn-го числа Фибоначчи на mm.
public class HugeFibonacciNumber extends BaseTask {
    @Override
    protected void run() throws IOException {
        Scanner reader = readFile();
        Long a = reader.nextLong();
        Long b = reader.nextLong();
        System.out.println(fibonacci(a, b));
    }

    private static long fibonacci(long n, long mod) {
        long a11 = 1, a12 = 1, a21 = 1, a22 = 0; //матрица оператора
        long r11 = 1, r12 = 0; //вектор-столбец результа
        long q11 = 0, q12 = 0, q21 = 0, q22 = 0; //вспомогательная матрица при перемножении
        while (n > 0) {
            if ((n & 1) == 1) {
                q11 = (r11 * a11 + r12 * a21) % mod;
                q12 = (r11 * a12 + r12 * a22) % mod;
                r11 = q11;
                r12 = q12;
            }
            q11 = (a11 * a11 + a12 * a21) % mod;
            q12 = (a11 * a12 + a12 * a22) % mod;
            q21 = (a21 * a11 + a22 * a21) % mod;
            q22 = (a21 * a12 + a22 * a22) % mod;
            a11 = q11;
            a12 = q12;
            a21 = q21;
            a22 = q22;

            n /= 2;

        }
        return r12;
    }

}
