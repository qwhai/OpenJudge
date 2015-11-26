package org.poj.p1703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ²¢²é¼¯
 */
public class Main {

    private final static String NOT_SURE_LABEL = "Not sure yet.";
    private final static String DIFFERENT_GANGS_LABEL = "In different gangs.";
    private final static String SAME_GANG_LABEL = "In the same gang.";

    private static int[] parents = null;
    private static int[] classifys = null;
    private static int[] size = null;

    static BufferedReader reader = new BufferedReader(new InputStreamReader(
            System.in));

    private static void answer(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            System.out.println(NOT_SURE_LABEL);
        } else {
            if (classifys[x] == classifys[y]) {
                System.out.println(SAME_GANG_LABEL);
            } else {
                System.out.println(DIFFERENT_GANGS_LABEL);
            }
        }
    }

    private static void printAnswers(int m, int n) throws IOException {
        for (int i = 0; i < m; i++) {
            String[] data = reader.readLine().split(" ");

            if (data[0].equals("D")) {
                int x = Integer.valueOf(data[1]);
                int y = Integer.valueOf(data[2]);
                union(x, y);
            } else {
                answer(Integer.valueOf(data[1]), Integer.valueOf(data[2]));
            }
        }
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        int p = find(parents[x]);

        classifys[x] = (classifys[x] + classifys[parents[x]]) % 2;

        parents[x] = p;

        return p;
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (size[px] <= size[py]) {
                parents[px] = py;
                classifys[px] = (classifys[x] + classifys[y] + 1) % 2;
                size[py] += size[px];
            } else {
                parents[py] = px;
                classifys[py] = (classifys[x] + classifys[y] + 1) % 2;
                size[px] += size[py];
            }
        }
    }

    private static void initFlagArray(int n) {
        parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        classifys = new int[n + 1];

        size = new int[n + 1];
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        int t = 0;
        try {
            t = Integer.parseInt(reader.readLine());

            while (t-- > 0) {
                String[] mn = reader.readLine().split(" ");
                int n = Integer.parseInt(mn[0]);
                int m = Integer.parseInt(mn[1]);

                initFlagArray(n);

                printAnswers(m, n);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}