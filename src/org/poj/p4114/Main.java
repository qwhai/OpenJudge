package org.poj.p4114;

/**
 * http://bailian.openjudge.cn/practice/4114/
 * Given n segments in the two dimensional space,
 * write a program,
 * which determines if there exists a line such that after projecting these segments on it,
 * all projected segments have at least one point in common.
 * 
样例输入
3
2
1.0 2.0 3.0 4.0
4.0 5.0 6.0 7.0
3
0.0 0.0 0.0 1.0
0.0 1.0 0.0 2.0
1.0 1.0 2.0 1.0
3
0.0 0.0 0.0 1.0
0.0 2.0 0.0 3.0
1.0 1.0 2.0 1.0
样例输出
Yes!
Yes!
No!
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Wrong Answer
public class Main {

    public static void main(String[] args) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(reader.readLine());
            while (T-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                String[][] segments = new String[n][4];
                for (int i = 0; i < n; i++) {
                    segments[i] = reader.readLine().split(" ");
                }
                
                double[][] coordinates = new double[n * 2][2];
                for (int i = 0; i < segments.length; i++) {
                    coordinates[2 * i][0] = Double.parseDouble(segments[i][0]);
                    coordinates[2 * i][1] = Double.parseDouble(segments[i][1]);
                    coordinates[2 * i + 1][0] = Double.parseDouble(segments[i][2]);
                    coordinates[2 * i + 1][1] = Double.parseDouble(segments[i][3]);
                }
                
                boolean havingIntersection = false; // 有交点的值为否
                for (int i = 0; i < coordinates.length; i++) {
                    for (int j = i + 1; j < coordinates.length; j++) {
                        if (i != j) {
                            double[] kb = getLineKB(coordinates[i][0], coordinates[i][1], coordinates[j][0], coordinates[j][1]);
                            if (isAllIntersection(segments, kb[0], kb[1])) {
                                havingIntersection = true;
                                break;
                            }
                        }
                    }
                }
                
                printResult(havingIntersection);
            }
        } catch (Exception e) {
        }
    }
    
    private static boolean isAllIntersection(String[][] segments, double k, double b) {
        boolean f = true;
        if (k == Double.MAX_VALUE || k == Double.MIN_VALUE) {
            for (int i = 0; i < segments.length; i++) {
                double x1 = Double.parseDouble(segments[i][0]);
                double x2 = Double.parseDouble(segments[i][2]);
                if (!isIntersection(x1, x2, b)) {
                    f = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < segments.length; i++) {
                double x1 = Double.parseDouble(segments[i][0]);
                double y1 = Double.parseDouble(segments[i][1]);
                double x2 = Double.parseDouble(segments[i][2]);
                double y2 = Double.parseDouble(segments[i][3]);
                if (!isIntersection(x1, y1, x2, y2, k, b)) {
                    f = false;
                    break;
                }
            }
        }
        
        return f;
    }
    
    /**
     * 线段与直线的关系（是否相交）
     * 直线：x = b
     * 线段：(x1, y1) - (x2, y2)
     */
    private static boolean isIntersection(double x1, double x2, double b) {
        boolean isInter = false;
        isInter = ((x1 - b) * (x2 - b) <= 0 ? true : false);
        
        return isInter;
    }
    
    /**
     * 线段与直线的关系（是否相交）
     * 直线：y = kx + b
     * 线段：(x1, y1) - (x2, y2)
     */
    private static boolean isIntersection(double x1, double y1, double x2, double y2, double k, double b) {
        boolean isInter = false;
        double inLineY1 = k * x1 + b;
        double inLineY2 = k * x2 + b;
        
        isInter = ((y1 - inLineY1) * (y2 - inLineY2) <= 0 ? true : false);
        
        return isInter;
    }
    
    /**
     * 计算直线方程，这里暂时不考虑斜率不存在的情况
     */
    private static double[] getLineKB(double x1, double y1, double x2, double y2) {
        double[] kb = new double[2];
        kb[0] = k(x1, y1, x2, y2);
        kb[1] = y1 - kb[0] * x1;
        
        return kb;
    }
    
    
    private static double k(double x1, double y1, double x2, double y2) {
        double k = 0.0;
        if (x2 - x1 != 0) {
            k = (y2 - y1) / (x2 - x1);
        } else {
            if (y2 - y1 >= 0) {
                k = Double.MAX_VALUE;
            } else {
                k = Double.MIN_VALUE;
            }
        }
        return k;
    }
    
    private static void printResult(boolean havingIntersection) {
        if (havingIntersection) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }
    }
}
