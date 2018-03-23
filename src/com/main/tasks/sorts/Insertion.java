package com.main.tasks.sorts;

import com.main.tasks.sorts.base.BaseSortTask;

public class Insertion extends BaseSortTask {
    @Override
    protected void sort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j > 0 && values[j - 1] > values[j]; j--)
                swap(j - 1, j);
        }

    }
}
