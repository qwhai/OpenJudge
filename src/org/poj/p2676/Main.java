package org.poj.p2676;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] datas = new int[n];
        for (int i = 0; i < n; i++) {
            datas[i] = input.nextInt();
        }
        
        int count1 = 0;
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < n; i++) {
            switch (datas[i]) {
            case 1:
                count1++;
                break;
            case 5:
                count5++;
                break;
            case 10:
                count10++;
                break;

            default:
                break;
            }
        }
        
        System.out.println(count1);
        System.out.println(count5);
        System.out.println(count10);
        
        input.close();
    }
}