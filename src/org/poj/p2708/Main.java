package org.poj.p2708;

import java.util.Scanner;

public class Main {

    private static int[] getDatas() {
        Scanner input = new Scanner(System.in);
        int[] datas = new int[10];
        for (int i = 0; i < 10; i++) {
            datas[i] = input.nextInt();
        }
        input.close();
        return datas;
    }
    
    private static boolean judgeData(int[] datas) {
        double[][] nutrient = new double[10][3];
        nutrient = getNutrientContent();
        double[] energy = {4.1, 9.3, 4.1};
        
        double[][] energyTable = getEnergyTable(datas, nutrient, energy);
        double[] PFC = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                PFC[i] += energyTable[j][i];
            }
        }
        
        double[] rates = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            rates[i] = (PFC[i] / (PFC[0] + PFC[1] + PFC[2])) * 100;
        }
        
        if ((14 > rates[0]) || (rates[0] > 16)) {
            return false;
        }
        if ((30 > rates[1]) || (rates[1] > 35)) {
            return false;
        }
        if ((49 > rates[2]) || (rates[2] > 56)) {
            return false;
        }
        
        return true;
    }
    
    private static double[][] getEnergyTable(int[] datas, double[][] nutrient, double[] energy) {
        double[][] energyTable = new double[10][3];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                energyTable[i][j] = nutrient[i][j] * datas[i] * energy[j];
            }
        }
        return energyTable;
    }
    
    private static double[][] getNutrientContent() {
        double[][] nutrient = new double[10][3];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                nutrient[i][j] = getContent()[i * 3 + j];
            }
        }
        return nutrient;
    }
    
    private static double[] getContent() {
        double[] nutrient = {
                7.5,0.75,78,
                10,1.25,75,
                1.5,0.19,4.28,
                35,18,42,
                5.0,5.0,0.6,
                16.5,28.8,1.05,
                17.7,20.33,4.06,
                14.9,0.8,0.93,
                0,100,0,
                0.85,0.5,8
        };
        return nutrient;
    }
    
    public static void main(String[] args) {
        int[] datas = getDatas();
        if (judgeData(datas)) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

}