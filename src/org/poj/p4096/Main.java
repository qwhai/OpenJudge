package org.poj.p4096;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lebal = scanner.nextLine();
        lebal = lebal.replaceAll("A", "1");
        lebal = lebal.replaceAll("B", "2");
        lebal = lebal.replaceAll("C", "\\$");
        lebal = lebal.replaceAll("D", "\n");

        System.out.println(lebal);
        scanner.close();
    }
}
