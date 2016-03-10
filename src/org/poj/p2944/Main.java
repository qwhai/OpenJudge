package org.poj.p2944;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * 2944:单词替换
 * http://bailian.openjudge.cn/practice/2944/
 * </p>
 * Create Date: 2016年3月10日
 * Last Modify: 2016年3月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String segment = reader.readLine();
            String patternLabel = reader.readLine();
            String replaceLabel = reader.readLine();
            
            String[] segments = segment.split(" ");
            
            for (int i = 0; i < segments.length; i++) {
                if (segments[i].equals(patternLabel)) {
                    segments[i] = replaceLabel;
                }
            }
            
            String result = "";
            for (int i = 0; i < segments.length; i++) {
                if (i == 0) {
                    result += segments[i];                    
                } else {
                    result += (" " + segments[i]);
                }
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
