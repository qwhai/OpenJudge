package org.poj.p4103;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int step = Integer.parseInt(reader.readLine());
        reader.close();
        int sum = formula(step, 0, 0);
        System.out.println(sum);
    }
    
    // status=0, 1, 2, 3
    // 0: 原点
    // 1: 从左向右
    // 2: 从右向左
    // 3: 从下向上
    private int formula(int step, int status, int sum) {
        if (step == 0) {
            return sum + 1;
        }
        
        if (status != 1) {
            sum = formula(step - 1, 2, sum);
        }
        
        if (status != 2) {
            sum = formula(step - 1, 1, sum);
        }
        
        sum = formula(step - 1, 3, sum);
        
        return sum;
    }
}
