package org.poj.p1007;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        String temp = input.nextLine();
        
        String[] dna = new String[m];
        for (int i = 0; i < m; i++) {
            dna[i] = input.nextLine();
        }
        
        int[] record = getInitInt(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isBiggerChar(dna[i].charAt(j), dna[i].charAt(k))) {
                        record[i]++;
                    }
                }
            }
        }
        
        int max = -1;
        for (int i = 0; i < m; i++) {
            if (record[i] > max) {
                max = record[i];
            }
        }
        
        int[] mark = new int[m];
        for (int i = 0, k = 0; i <= max; i++) {
            for (int j = 0; j < m; j++) {
                if (record[j] == i) {
                    mark[k++] = j;
                }
            }
        }
        
        // ´òÓ¡
        for (int i = 0; i < m; i++) {
            System.out.println(dna[mark[i]]);
        }
        
    }
    
    private static int[] getInitInt(int m) {
        int[] record = new int[m];
        for (int i = 0; i < m; i++) {
            record[i] = 0;
        }
        return record;
    }
    
    private static boolean isBiggerChar(char a, char b) {
        if ((a - b) > 0) {
            return true;
        }else {
            return false;
        }
    }

}