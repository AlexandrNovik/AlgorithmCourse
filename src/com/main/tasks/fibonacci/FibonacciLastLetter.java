package com.main.tasks.fibonacci;

import com.main.tasks.BaseTask;

import java.io.IOException;
import java.util.Scanner;

public class FibonacciLastLetter extends BaseTask {

    @Override
    protected void run() throws IOException {
        System.out.println(fibonacci(readFile().nextInt()));
    }

    private static int fibonacci(final int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        for (int i = 2; i < n; i++) {
            c = a + b % 10;
            a = b;
            b = c;
        }
        return c % 10;
    }

    public static final void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        System.out.print(fibonacci(n));
    }

}
