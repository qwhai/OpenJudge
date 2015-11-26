package org.poj.p2698;

/**
 * 列优先
 */
public class Main {

    private int[] column; // 同栏是否有皇后，1表示有
    private int[] rup; // 右上至左下是否有皇后
    private int[] lup; // 左上至右下是否有皇后
    private int[] queen; // 解答
    private int num; // 解答编号

    public Main() {
        column = new int[8 + 1];
        rup = new int[(2 * 8) + 1];
        lup = new int[(2 * 8) + 1];

        for (int i = 1; i <= 8; i++) {
            column[i] = 1;
        }

        for (int i = 1; i <= (2 * 8); i++) {
            rup[i] = 1;
            lup[i] = 1;
        }

        queen = new int[8 + 1];
    }

    public void backtrack(int raw) {
        if (raw > 8) {
            showAnswer();
        } else {
            for (int c = 1; c <= 8; c++) {
                if ((column[c] == 1) && (rup[raw + c] == 1) && (lup[raw - c + 8] == 1)) {
                    queen[raw] = c;
                    // 设定为占用
                    column[c] = rup[raw + c] = lup[raw - c + 8] = 0;
                    backtrack(raw + 1);
                    column[c] = rup[raw + c] = lup[raw - c + 8] = 1;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("No. " + num);

        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                String suffix = "";
                if (y < 8) {
                    suffix = " ";
                }
                if (queen[y] == x) {
                    System.out.print("1" + suffix);
                } else {
                    System.out.print("0" + suffix);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main queen = new Main();
        queen.backtrack(1);
    }
}