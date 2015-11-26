package org.poj.p2694;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * http://bailian.openjudge.cn/practice/2694
 * [* + 11.0 12.0 + 24.0 35.0]
 * [+ / + 5.0 3.0 + 1.0 2.0 6.0]
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String polandExp = reader.readLine();
            String[] ops = polandExp.split(" ");
            String[] stack = new String[ops.length];
            int stackIndex = 0;
            for (int i = 0; i < ops.length; i++) {
                if (isOperator(ops[i])) {
                    stack[stackIndex++] = ops[i];
                } else {
                    if (isOperator(stack[stackIndex - 1])) {
                        stack[stackIndex++] = ops[i];
                    } else {
                        double num1 = Double.parseDouble(stack[--stackIndex]);
                        String op = stack[--stackIndex];
                        stack[stackIndex++] = String.valueOf(getResult(num1, op, Double.parseDouble(ops[i])));
                        
                        if (stackIndex >= 2) {
                            if (!isOperator(stack[stackIndex - 2])) {
                                double num2 = Double.parseDouble(stack[--stackIndex]);
                                num1 = Double.parseDouble(stack[--stackIndex]);
                                op = stack[--stackIndex];
                                stack[stackIndex++] = String.valueOf(getResult(num1, op, num2));
                            }
                        }
                    }
                }
            }
            
            double reslut = Double.parseDouble(stack[--stackIndex]);
            DecimalFormat format = new DecimalFormat("#.000000");
            System.out.println(format.format(reslut));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static double getResult(double num1, String op, double num2) {
        if (isAddition(op)) {
            return num1 + num2;
        }
        if (isSubtraction(op)) {
            return num1 - num2;
        }
        if (isMultiplication(op)) {
            return num1 * num2;
        }
        if (isDivision(op)) {
            return num1 / num2;
        }
        
        return 0;
    }
    
    public static boolean isOperator(String op) {
        if (isAddition(op) || isSubtraction(op) || isMultiplication(op) || isDivision(op)) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isAddition(String op) {
        if (op.equals("+")) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isSubtraction(String op) {
        if (op.equals("-")) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isMultiplication(String op) {
        if (op.equals("*")) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isDivision(String op) {
        if (op.equals("/")) {
            return true;
        }
        
        return false;
    }
}
