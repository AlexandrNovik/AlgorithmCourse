package com.main.tasks.sorts;

import com.main.tasks.sorts.base.BaseSortTask;

public class Bubble extends BaseSortTask {
    @Override
    protected void sort(int[] values) {
        for (int i = values.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (values[j] > values[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
}
