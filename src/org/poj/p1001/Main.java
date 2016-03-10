package org.poj.p1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * http://bailian.openjudge.cn/practice/1001/
 * </p>
 * 2016年3月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                String[] data = reader.readLine().split(" ");
                char[] a = data[0].toCharArray();
                int index = 0;
                for (int i = a.length - 1; i >= 0; i--) {
                    if (a[i] == '0') {
                        continue;
                    }
                    index = i;
                    break;
                }
                String base = data[0].substring(0, index + 1);
                
                int e = 0;
                for (int i = 1; i < data.length; i++) {
                    if (isEmpty(data[i])) {
                        continue;
                    }
                    e = Integer.parseInt(data[i]);
                }
                
                System.out.println(pow(base, e));
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 计算幂
    private static String pow(String base, int e) throws Exception {
        int position = position(base);
        base = base.replace(".", "");
        String mult = "1";
        for (int i = 0; i < e; i++) {
            mult = multiplication(mult, base);
        }
        position = position * e;
        int length = mult.length();
        
        String result = "";
        if (position < length) {
            result = mult.substring(0, length - position) + "." + mult.substring(length - position, length);
        } else {
            String temp = "";
            for (int i = 0; i < position - length; i++) {
                temp += "0";
            }
            temp += mult;
            length = temp.length();
            result = temp.substring(0, length - position) + "." + temp.substring(length - position, length);
        }

        // 去除10.00的2次方这样的情况
        length = result.length();
        if (result.charAt(length - 1) == '.') {
            result = result.substring(0, length - 1);
        }
        
        return result;
    }
    
    // 计算小数点的位置
    private static int position(String base) {
        int length = base.length();
        int position = 0;
        for (int i = 0; i < length; i++) {
            if (base.charAt(i) == '.') {
                position = length - i - 1;
                break;
            }
        }
        return position;
    }
    
    // 计算两个数字的乘积
    private static String multiplication(String string1, String string2) throws Exception {
        int[] nums1 = transfromToIntegerArray(reverseString(string1));
        int[] nums2 = transfromToIntegerArray(reverseString(string2));
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        // 两数乘积位数不会超过乘数位数和+ 3位
        int cacheLength = length1 + length2 + 3;
        int[] result = new int[cacheLength];

        // 逐位相乘
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                result[i + j] += (nums1[i] * nums2[j]);
            }
        }
        
        // 进位
        carry(result);
        
        return combination(result);
    }
    
    // 对逐位操作的结果进行进位操作
    private static void carry(int[] numbers) {
        int cacheLength = numbers.length;
        
        for (int i = 0; i < cacheLength; i++) {
            int carry = numbers[i] / 10; // 进位
            numbers[i] = numbers[i] % 10;
            
            if (carry > 0) {
                numbers[i + 1] += carry;
            }
        }
    }
    
    // 将一个数字数组拼接成一个字符串，注意这里需要倒置
    private static String combination(int[] numbers) {
        StringBuffer buffer = new StringBuffer();
        boolean started = false;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (!started && numbers[i] != 0) {
                started = true;
            }
            
            if (started) {
                buffer.append(String.valueOf(numbers[i]));
            }
        }
        
        return started ? buffer.toString() : "0";
    }
    
    // 将一个数字字符串转化为整型数组
    private static int[] transfromToIntegerArray(String number) throws Exception {
        if (isEmpty(number)) {
            return null;
        }
        
        char[] chars = number.toCharArray();
        int length = chars.length;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            if (!isNumberChar(chars[i])) {
                throw new Exception(number + "传入的参数不是数字");
            }
            
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        
        return numbers;
    }
    
    // 判断一个字符是否是数字
    private static boolean isNumberChar(char c) {
        return ('0' <= c && c <= '9');
    }
    
    private static boolean isEmpty(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }

        return false;
    }
    
    private static String reverseString(String label) {
        return new StringBuffer(label).reverse().toString();
    }
}
