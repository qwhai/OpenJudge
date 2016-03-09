package org.poj._p4070;

public class Test {
    public static char[] text = { '1', '2', '3' };

    public static void main(String[] args) {
        permutation(text, 0, text.length);
        System.exit(0);
    }

    /**
     * 全排列输出
     * 
     * @param a[]
     *            要输出的字符数组
     * @param m
     *            输出字符数组的起始位置
     * @param n
     *            输出字符数组的长度
     */
    public static void permutation(char a[], int m, int n) {
        int i;
        char t;
        if (m < n - 1) {
            permutation(a, m + 1, n);
            for (i = m + 1; i < n; i++) {
                t = a[m];
                a[m] = a[i];
                a[i] = t;
                permutation(a, m + 1, n);
                t = a[m];
                a[m] = a[i];
                a[i] = t;
            }
        } else {
            printResult(a);
        }
    }

    /**
     * 输出指定字符数组
     * 
     * @param text
     *            将要输出的字符数组
     */
    public static void printResult(char[] text) {
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
        }
        System.out.println();
    }
}