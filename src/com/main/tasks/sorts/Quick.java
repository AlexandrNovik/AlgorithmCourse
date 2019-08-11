package com.main.tasks.sorts;

import com.main.tasks.sorts.base.BaseSortTask;

import java.util.ArrayList;
import java.util.List;

public class Quick extends BaseSortTask {
    @Override
    protected void sort(int[] values) {
        final List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < values.length; i++) {
            list.add(i);
        }
        List<Integer> l = quickSort(list);
        int[] sorted = new int[l.size()];
        for (int i = 0; i < values.length; i++){
            sorted[i] = l.get(i);
        }
        printSortedArray(sorted);
    }

    private List<Integer> quickSort(List<Integer> values) {
        if (values.size() < 2) return values;
        int pivot = values.size()  / 2;
        List<Integer> less = values.subList(pivot, values.size());
        List<Integer> more = values.subList(0, pivot);
        final ArrayList<Integer> list = new ArrayList<Integer>(quickSort(less));
        list.add(values.get(pivot));
        list.addAll(quickSort(more));
        return list;
    }
}
