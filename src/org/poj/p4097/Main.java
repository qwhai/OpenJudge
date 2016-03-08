package org.poj.p4097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * http://bailian.openjudge.cn/practice/4097/
 * </p>
 * 2016年3月8日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            // 数据录入
            int n = Integer.parseInt(reader.readLine());
            String[] sites = new String[n];
            for (int i = 0; i < sites.length; i++) {
                sites[i] = reader.readLine();
            }
            int m = Integer.parseInt(reader.readLine());
            String[][] targets = new String[m][2];
            for (int i = 0; i < targets.length; i++) {
                targets[i] = reader.readLine().split(" ");
            }
            
            // 计算
            for (int i = 0; i < targets.length; i++) {
                // 同一站
                if (targets[i][0].equals(targets[i][1])) {
                    System.out.println(targets[i][0]);
                    continue;
                }
                
                // 处理每一个始末站之间的站点
                boolean forward = true; // 正向或逆向状态
                for (int j = 0; j < sites.length; j++) {
                    if (sites[j].equals(targets[i][0]) || sites[j].equals(targets[i][1])) {
                        forward = sites[j].equals(targets[i][0]); // 修改为逆向状态
                        break;
                    }
                }
                
                int status = -1; // 上车/下车状态
                if (forward) {
                    for (int j = 0; j < sites.length; j++) {
                        if (sites[j].equals(targets[i][0]) || sites[j].equals(targets[i][1])) {
                            status++;
                            if (status == 1) {
                                System.out.println(sites[j]);
                                break;
                            }
                        }
                        if (status == 0) {
                            System.out.print(sites[j] + " ");
                        }
                    }
                } else {
                    for (int j = sites.length - 1; j >= 0; j--) {
                        if (sites[j].equals(targets[i][0]) || sites[j].equals(targets[i][1])) {
                            status++;
                            if (status == 1) {
                                System.out.println(sites[j]);
                                break;
                            }
                        }
                        if (status == 0) {
                            System.out.print(sites[j] + " ");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
