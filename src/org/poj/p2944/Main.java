package org.poj.p2944;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
