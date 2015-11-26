package org.poj.p2943;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Mouse> mouses = new ArrayList<Mouse>();
            while(n-- > 0) {
                String[] info = reader.readLine().split(" ");
                Mouse mouse = new Mouse();
                mouse.setWeight(Integer.parseInt(info[0]));
                mouse.setColor(info[1]);
                mouses.add(mouse);
            }
            
            sort(mouses);
            
            for (int i = 0; i < mouses.size(); i++) {
                System.out.println(mouses.get(i).getColor());
            }
        } catch (Exception e) {
        }
    }
    
    private static void sort(ArrayList<Mouse> mouses) {
        for (int i = 0; i < mouses.size(); i++) {
            for (int j = i + 1; j < mouses.size(); j++) {
                if (i != j && mouses.get(i).getWeight() < mouses.get(j).getWeight()) {
                    Mouse swapMouse = new Mouse();
                    swapMouse.setWeight(mouses.get(i).getWeight());
                    swapMouse.setColor(mouses.get(i).getColor());
                    
                    mouses.get(i).setWeight(mouses.get(j).getWeight());
                    mouses.get(i).setColor(mouses.get(j).getColor());
                    
                    mouses.get(j).setWeight(swapMouse.getWeight());
                    mouses.get(j).setColor(swapMouse.getColor());
                }
            }
        }
    }
    
    static class Mouse {
        int weight;
        String color;
        
        public int getWeight() {
            return weight;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        
    }
}
