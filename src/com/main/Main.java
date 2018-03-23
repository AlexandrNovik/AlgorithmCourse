package com.main;

import com.main.tasks.BaseTask;
import com.main.tasks.sorts.Selection;

import java.io.IOException;

public class Main {
    public static final void main(String[] args) throws IOException {
        BaseTask task = new Selection();
        task.start();
    }
}
