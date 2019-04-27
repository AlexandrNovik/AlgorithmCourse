package com.main.tasks;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class BaseTask {
    protected abstract void run() throws IOException;
    protected abstract String inputFileName();

    public final void start() throws IOException {
        final Long start = System.currentTimeMillis();
        run();
        final Long finish = System.currentTimeMillis();
        System.out.println("Done in: " + (finish - start) + " ms");
    }


    protected final Scanner readFile() throws IOException {
        return new Scanner(new File(inputFileName()));
    }

    // EXAMPLE: enter values solution for stepic.org
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.print(foo(a, b));
    }

    private static final long foo(long a, long b) {
        // solution
        return 1;
    }
}


