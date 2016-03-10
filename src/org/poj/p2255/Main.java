package org.poj.p2255;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p></p>
 * Create Date: 2016年3月10日
 * Last Modify: 2016年3月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    Node root = null;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                Main tree = new Main();
                String[] data = reader.readLine().split(" ");
                String[] F = data[0].split("");
                String[] M = data[1].split("");
                tree.restoreTree(F, M);
                tree.lastVisiting(tree, tree.root);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 重建二叉树
    private void restoreTree(String[] labelFirst, String[] labelmodle) {
        int[] r = recordArray(labelFirst, labelmodle);

        if (root == null) {
            root = new Node();
            root.setName(labelFirst[0]);
            root.setIndex(r[0]);
        }

        for (int i = 1; i < labelFirst.length; i++) {
            Node currentNode = new Node();
            currentNode.setName(labelFirst[i]);
            currentNode.setIndex(r[i]);

            insert(currentNode);
        }
    }
    
    private void lastVisiting(Main tree, Node node) {
        if (node == null) {
            return;
        }
        
        lastVisiting(tree, node.getLeftNode());
        lastVisiting(tree, node.getRightNode());
        System.out.print(node == tree.root ? (node.getName() + "\n") : (node.getName()));
        
        return;
    }

    // 向二叉树中插入一个节点
    private void insert(Node insertNode) {
        Node currentNode = root;
        while (true) {
            if (insertNode.getIndex() < currentNode.getIndex()) {
                if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(insertNode);
                    break;
                } else {
                    currentNode = currentNode.getLeftNode();
                }
            } else if (insertNode.getIndex() > currentNode.getIndex()) {
                if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(insertNode);
                    break;
                } else {
                    currentNode = currentNode.getRightNode();
                }
            } else {
                break;
            }
        }
    }

    // 计算索引函数
    private int[] recordArray(String[] labelFirst, String[] labelLast) {
        if (labelFirst == null || labelFirst.length == 0 || labelLast == null || labelLast.length == 0) {
            return null;
        }

        int[] record = new int[labelFirst.length];
        for (int i = 0; i < labelFirst.length; i++) {
            record[i] = index(labelLast, labelFirst[i]);
        }

        return record;
    }

    // 计算索引函数
    private int index(String[] labels, String label) {
        for (int i = 0; i < labels.length; i++) {
            if (label.equals(labels[i])) {
                return i;
            }
        }

        return -1;
    }
    
    class Node {

        String name;
        Node leftNode;
        Node rightNode;
        int index;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
