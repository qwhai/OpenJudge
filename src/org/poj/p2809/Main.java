package org.poj.p2809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 2809:计算2的N次方
 * http://bailian.openjudge.cn/practice/2809/
 * </p>
 * Create Date: 2016年3月10日
 * Last Modify: 2016年3月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    enum ComparativeSize {

        /** 大于 */
        Bigger("大"),
        
        /** 相等 */
        Equal("相等"),
        
        /** 小于 */
        Small("小");
        
        private String desc;
        
        ComparativeSize(String _desc) {
            desc = _desc;
        }
        
        /**
         * 获得枚举值的描述
         * 
         * @return
         *      描述
         */
        public String getDesc() {
            return desc;
        }
    }
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                String n = reader.readLine();
                System.out.println(pow("2", n));
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 计算幂
    private static String pow(String base, String e) {
        String mult = "1";
        for (String i = e; !i.equals("0"); i = subtraction(i, "1")) {
            mult = multiplication(mult, base);
        }
        return mult;
    }
    
    private static String subtraction(String string1, String string2) {
        ComparativeSize comparativeSize = compare(string1, string2);
        String resultSign = "";
        if (comparativeSize == ComparativeSize.Equal) {
            return "0";
        } else if (comparativeSize == ComparativeSize.Small) {
            String swap = string1;
            string1 = string2;
            string2 = swap;
            
            resultSign = "-";
        }
        
        int[] nums1 = transfromToIntegerArray(reverseString(string1));
        int[] nums2 = transfromToIntegerArray(reverseString(string2));
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int[] result = new int[Math.max(length1, length2) + 1];
        
        int minLength = Math.min(length1, length2);
        int maxLength = Math.max(length1, length2);
        
        // 逐位相减
        for (int i = 0; i < minLength; i++) {
            result[i] = nums1[i] - nums2[i];
        }
        
        // 余位补充
        for (int i = minLength; i < maxLength; i++) {
            result[i] = nums1[i];
        }
        
        // 借位处理
        borrow(result);
        
        return resultSign + combination(result);
    }
    
    // 计算两个数字的乘积
    private static String multiplication(String string1, String string2) {
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
    private static int[] transfromToIntegerArray(String number) {
        if (isEmpty(number)) {
            return null;
        }
        
        char[] chars = number.toCharArray();
        int length = chars.length;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            if (!isNumberChar(chars[i])) {
                return null;
            }
            
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        
        return numbers;
    }
    
    // 判断一个字符是否是数字
    private static boolean isNumberChar(char c) {
        return ('0' <= c && c <= '9');
    }
    
    // 比较两个大数的大小
    private static ComparativeSize compare(String string1, String string2) {
        if (!isNumberString(string1) || !isNumberString(string2)) {
            return null;
        }
        int[] nums1 = transfromToIntegerArray(string1);
        int[] nums2 = transfromToIntegerArray(string2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if (length1 > length2) {
            return ComparativeSize.Bigger;
        } else if (length1 < length2) {
            return ComparativeSize.Small;
        }
        
        for (int i = 0; i < length1; i++) {
            if (nums1[i] > nums2[i]) {
                return ComparativeSize.Bigger;
            } else if (nums1[i] < nums2[i]) {
                return ComparativeSize.Small;
            }
        }
        
        return ComparativeSize.Equal;
    }
    
    // 对逐位操作的结果进行借位操作
    private static void borrow(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] += 10;
                numbers[i + 1]--;
            }
        }
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
    
    private static boolean isNumberString(String string) {
        return isSub(string, "^-{0,1}[0-9]+$");
    }
    
    private static boolean isSub(String str, String re) {
        Pattern pattern = Pattern.compile(re);
        Matcher match = pattern.matcher(str);
        if (match.find(0)) {
            return true;
        }
        
        return false;
    }
}
