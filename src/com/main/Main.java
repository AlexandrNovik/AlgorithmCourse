package com.main;

import com.main.tasks.BaseTask;
import com.main.tasks.sorts.Bubble;

import java.io.IOException;

public class Main {
    public static final void main(String[] args) throws IOException {
        BaseTask task = new Bubble();
        System.out.println("Task: " + task.getClass().getName());
        task.start();
    }
}
