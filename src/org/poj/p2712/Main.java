package org.poj.p2712;

import java.util.Scanner;

public class Main {

    /**
     * 得到两个日期之间共有多少天
     * 
     * @param fristMonth
     * @param fristDate
     * @param secondMonth
     * @param secondDate
     * @return
     */
    private static int getDays(int fristMonth, int fristDate, int secondMonth,
            int secondDate) {
        int days = 0;
        int daysOfMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = fristMonth; i < secondMonth; i++) {
            days += daysOfMonth[i - 1];
        }
        days = days + secondDate - fristDate;
        return days;
    }

    /**
     * 根据日期和初始值参数得到最后结果
     * 
     * @param fristMonth
     * @param fristDate
     * @param number
     * @param secondMonth
     * @param secondDate
     * @return
     */
    private static int getResult(int fristMonth, int fristDate, int number,
            int secondMonth, int secondDate) {
        int bacteriaNumber = 1;
        int days = getDays(fristMonth, fristDate, secondMonth, secondDate);
        int i;
        for (i = 0, bacteriaNumber = number; i < days; i++) {
            bacteriaNumber = bacteriaNumber * 2;
        }
        return bacteriaNumber;
    }

    private static void calBacteriaNumber() {
        int count;
        int fristMonth, fristDate, number, secondMonth, secondDate;

        Scanner input = new Scanner(System.in);
        count = input.nextInt();
        for (int i = 0; i < count; i++) {
            fristMonth = input.nextInt();
            fristDate = input.nextInt();
            number = input.nextInt();
            secondMonth = input.nextInt();
            secondDate = input.nextInt();
            int result = getResult(fristMonth, fristDate, number, secondMonth,
                    secondDate);
            System.out.println(result + "");
        }
        
        input.close();
    }

    public static void main(String[] args) {
        calBacteriaNumber();
    }

}