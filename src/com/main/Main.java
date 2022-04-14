package com.main;

import java.io.IOException;

import com.main.tasks.BaseTask;
import com.main.tasks.fibonacci.FibonacciSimpleNumber;

public class Main {
    public static void main(String[] args) throws IOException {
        BaseTask task = new FibonacciSimpleNumber();
        System.out.println("Task: " + task.getClass().getName());
        task.start();
    }
}
