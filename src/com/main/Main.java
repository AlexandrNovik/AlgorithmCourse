package com.main;

import com.main.tasks.BaseTask;
import com.main.tasks.gcd_lcm.LCM;

import java.io.IOException;

public class Main {
    public static final void main(String[] args) throws IOException {
        BaseTask baseTask = new LCM();
        baseTask.start();
    }
}
