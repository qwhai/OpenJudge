package org.poj.p4079;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://bailian.openjudge.cn/practice/4079/
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] numbers = reader.readLine().split(" ");
            int[] nums = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = Integer.parseInt(numbers[i]);
            }
            
            BinSearchTree tree = new BinSearchTree(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                tree.insert(nums[i]);
            }
            
            tree.ergodic(tree.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static class BinSearchTree {
        Node root;
        public BinSearchTree(int number) {
            root = new Node(number);
            root.setRoot(true);
        }
        
        public Node getRoot() {
            return root;
        }
        
        public void insert(int newNumber) {
            Node node = root;
            boolean overFlag = false;
            while (!overFlag) {
                if (node.getNumber() == newNumber) {
                    overFlag = true;
                } else if (newNumber < node.getNumber()) {
                    if (node.getLeft() == null) {
                        Node newNode = new Node(newNumber);
                        node.setLeft(newNode);
                        overFlag = true;
                    }
                    node = node.getLeft();
                } else {
                    if (node.getRight() == null) {
                        Node newNode = new Node(newNumber);
                        node.setRight(newNode);
                        overFlag = true;
                    }
                    node = node.getRight();
                }
            }
        }
        
        public void ergodic(Node node) {
            if (node == null) {
                return;
            }
            
            if (!node.isRoot()) {
                System.out.print(" ");
            }
            System.out.print(node.getNumber());
            ergodic(node.getLeft());
            ergodic(node.getRight());
        }
    }
    
    static class Node {
        int number;
        boolean isRoot;
        Node left;
        Node right;
        
        public Node(int number) {
            this.number = number;
            setRoot(false);
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isRoot() {
            return isRoot;
        }

        public void setRoot(boolean isRoot) {
            this.isRoot = isRoot;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
        
    }
}
