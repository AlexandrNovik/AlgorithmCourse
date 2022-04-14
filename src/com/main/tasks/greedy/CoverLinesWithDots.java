package com.main.tasks.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;
import static java.util.Comparator.comparingInt;

public class CoverLinesWithDots {
    public final void start() throws IOException {
        final Long start = System.currentTimeMillis();
        prepare();
        final Long finish = System.currentTimeMillis();
        out.println("Done in: " + (finish - start) + " ms");
    }

    private void prepare() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Line> lines = new ArrayList();
        for (int i = 0; i < n; n++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            lines.add(new Line(a1, a2));
        }
        scanner.close();
        solution(lines);
    }

    private void solution(ArrayList<Line> lines) {
        lines.sort(comparingInt(o -> o.to));
        ArrayList<Integer> points = new ArrayList();
        lines.forEach(line -> {
            if (points.isEmpty()) {
                points.add(line.to);
            }
            if (line.from > points.get(points.size() - 1)) {
                points.add(line.to);
            }
        });
        out.println(points.size());
        points.forEach(i -> out.print(i + " "));

    }

    public static void main(String[] args) throws IOException {
        new CoverLinesWithDots().start();
    }

    private static class Line {
        int from;
        int to;

        public Line(int f, int t) {
            from = f;
            to = t;
        }
    }
}
