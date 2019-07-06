package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.TreeSet;

public class SudokuManager {
    private static SudokuManager instance;

    public static SudokuManager getInstance() {
        if (instance == null) {
            instance = new SudokuManager();
        }
        return instance;
    }

    private int[][] result = new int[9][9];
    private TreeSet[][] treeSets = new TreeSet[9][9];
    private List<Integer> aTempList = new ArrayList<>();
    private List<Integer> bTempList = new ArrayList<>();

    public void init(int[] temps) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                treeSets[i][j] = new TreeSet();
            }
        }

        int k = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = temps[k];
                if (temps[k] == 0) {
                    treeSets[i][j].add(1);
                    treeSets[i][j].add(2);
                    treeSets[i][j].add(3);
                    treeSets[i][j].add(4);
                    treeSets[i][j].add(5);
                    treeSets[i][j].add(6);
                    treeSets[i][j].add(7);
                    treeSets[i][j].add(8);
                    treeSets[i][j].add(9);
                } else {
                    treeSets[i][j].add(temps[k]);
                }
                k++;
            }
        }
        printSudoku();
    }

    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(i + "" + j + ":  ");
                printTreeSet(treeSets[i][j]);
            }
            System.out.println();
        }
    }

    private void printTreeSet(TreeSet set) {
        for (Object value : set) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    //开始计算数独值

    /**
     * 数独计算原理 对每一行，每一列，每一个九宫格（称之为一个组）进行扫描
     * 1 如果当前组已经填好了数字 a， 则对当前组内的其他数字进行如下处理
     * 移除数字对应的集合 a，如果集合里只有一个数字b，则将b填入result里
     */
    public void calc() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (result[i][j] != 0) {
                    calcIJ(i, j);
                    calcIJ9(i, j);
                }
            }
        }
        processNext();
    }

    //一次扫描结束之后，
    private void processNext() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (treeSets[i][j].size() == 1 && result[i][j] == 0) {
                    result[i][j] = (int) treeSets[i][j].first();
                    calcIJ(i, j);
                    calcIJ9(i, j);
                }
            }
        }
        printSudoku();

    }
    // 计算高阶的数独 对于
    private void processHigh(){

    }

    //计算每一行每一列，移除不可能的数字，如果移除后只有一个数字，则记录下来
    private void calcIJ(int i1, int j1) {
        //先计算一行

        for (int j = 0; j < 9; j++) {
            treeSets[i1][j].remove(result[i1][j1]);

        }
        for (int i = 0; i < 9; i++) {
            treeSets[i][j1].remove(result[i1][j1]);

        }
    }

    //计算九宫格，移除不可能的数字，如果移除后只有一个数字，则记录下来
    private void calcIJ9(int i1, int j1) {
        int tempi = (i1 / 3) * 3;
        int tempj = (j1 / 3) * 3;
        for (int i = tempi; i < tempi + 3; i++) {
            for (int j = tempj; j < tempj + 3; j++) {
                treeSets[i][j].remove(result[i1][j1]);
            }
        }
    }

}
