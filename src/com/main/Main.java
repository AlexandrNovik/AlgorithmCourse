package com.main;

import com.main.tasks.BaseTask;
import com.main.tasks.dynamic.Combinations;
import com.main.tasks.fibonacci.FibonacciLastLetter;
import com.main.tasks.fibonacci.FibonacciSimpleNumber;
import com.main.tasks.sorts.Quick;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BaseTask task = new FibonacciSimpleNumber();
        System.out.println("Task: " + task.getClass().getName());
        task.start();
    }
}
