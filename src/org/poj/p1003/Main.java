package org.poj.p1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://bailian.openjudge.cn/practice/1003/
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            double distance = 0;
            while ((distance = Double.parseDouble(reader.readLine())) != 0.0) {
                int cardCount = 0;
                double sum = 0.0;
                while (true) {
                    cardCount++;
                    sum += 1.0 / (cardCount + 1);
                    if (sum >= distance) {
                        System.out.println(cardCount + " card(s)");
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
