package com.main.tasks.sorts;

import com.main.tasks.sorts.base.BaseSortTask;

public class Selection extends BaseSortTask {
    @Override
    protected void sort(int[] values) {
        int temp;
        for (int i = 0; i < values.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[min]) {
                    min = j;
                }
            }
            temp = values[min];
            values[min] = values[i];
            values[i] = temp;
        }
    }
}
