package org.poj._p4070;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            new Main().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void execute() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        do {
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                break;
            }

            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = i + 1;
            }

            fullArray(a, 0, n - 1);
        } while (true);

        reader.close();
    }
    
    private void fullArray(int[] a, int start, int end) {
        if (start > end) {
            printArray(a);
        } else {
            for (int i = start; i <= end; i++) {
                swap(a, start, i);
                fullArray(a, start + 1, end);
                swap(a, start, i);
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void printArray(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            System.out.print(i == 0 ? "" + a[i] : " " + a[i]);
        }
        System.out.println();
    }
}
