package com.main;

import com.main.tasks.BaseTask;
import com.main.tasks.gcd_lcm.GCD;
import com.main.tasks.gcd_lcm.LCM;
import com.main.tasks.sorts.Bubble;
import com.main.tasks.sorts.Insertion;
import com.main.tasks.sorts.Selection;

import java.io.IOException;

public class Main {
    public static final void main(String[] args) throws IOException {
        BaseTask task = new LCM();
        System.out.println("Task: " + task.getClass().getName());
        task.start();
    }
}
