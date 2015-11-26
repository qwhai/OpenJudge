package org.poj.p4108;

/**
 * http://bailian.openjudge.cn/practice/4108/
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int m = Integer.parseInt(reader.readLine());
            while (m-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                
                Antelope root = new Antelope();
                for (int i = 0; i < n; i++) {
                    root.newYear();
                }
                System.out.println(root.getDescendantsCouple() + 1);
            }
        } catch (Exception e) {
        }
    }
    
    static class Antelope {
        int age;
        ArrayList<Antelope> children;
        
        public Antelope() {
            age = 0;
            children = new ArrayList<Antelope>();
        }
        
        public int getChildrenCouple() {
            return (age < 3 ? 0 : (age - 2) * 2) / 2;
        }
        
        public int getDescendantsCouple() {
            int couple = 0;
            for (int i = 0; i < children.size(); i++) {
                couple += (children.get(i).getDescendantsCouple() + 1);
            }
            
            return couple;
        }
        
        public void newYear() {
            age++;
            for (int i = 0; i < children.size(); i++) {
                children.get(i).newYear();
            }
            
            if (age >= 3) {
                Antelope child = new Antelope();
                children.add(child);
            }
        }
    }
}
