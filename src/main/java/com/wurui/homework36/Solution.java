package com.wurui.homework36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @author: wurui
 * @create: 2019-04-01 11:29
 **/
public class Solution {
    /**
     * 最原始的思路,吴瑞的思路
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        char[][] cols = new char[9][9];// 列
        char[][] tables0 = new char[3][3];// 3*3格子
        char[][] tables1 = new char[3][3];// 3*3格子
        char[][] tables2 = new char[3][3];// 3*3格子

        for (int i = 0; i < 9; i++) { // 一行一行的遍历
            for (int j = 0; j < 9; j++) {
                cols[i][j] = board[j][i];
                if (j < 3) {
                    tables0[i % 3][j] = board[i][j];
                } else if (j >= 3 && j < 6) {
                    tables1[i % 3][j - 3] = board[i][j];
                } else if (j >= 6) {
                    tables2[i % 3][j - 6] = board[i][j];
                }
            }

            if (i > 0 && (i + 1) % 3 == 0) {
                if (!check3c3(tables0)) return false;
                if (!check3c3(tables1)) return false;
                if (!check3c3(tables2)) return false;
                tables0 = new char[3][3];
                tables1 = new char[3][3];
                tables2 = new char[3][3];
            }
        }

        if (!check(board)) return false;
        if (!check(cols)) return false;

        return true;
    }

    private boolean check3c3(char[][] chars) {
        boolean result = true;
        Set<Character> cSet = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = chars[i][j];
                if (c != '.' && cSet.contains(c)) {
                    return false;
                }
                cSet.add(c);
            }
        }

        return result;
    }

    private boolean check(char[][] chars) {
        boolean result = true;

        for (int i = 0; i < 9; i++) {
            if (!check(chars[i])) return false;
        }

        return result;
    }

    private boolean check(char[] row) {
        boolean result = true;
        Set<Character> cSet = new HashSet<>();
        for (int i = 0; i < row.length; i++) {
            char c = row[i];
            if (c != '.' && cSet.contains(c)) {
                return false;
            }
            cSet.add(c);
        }
        return result;
    }


    public boolean isValidSudoku2(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9]; // 行
        HashMap<Integer, Integer>[] cols = new HashMap[9]; // 列
        HashMap<Integer, Integer>[] tables = new HashMap[9]; // 3*3的小格子

        // 初始化
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>(13);
            cols[i] = new HashMap<>(13);
            tables[i] = new HashMap<>(13);

        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                Integer ci = c - '0';
                if (c == '.') continue;
                rows[i].put(ci, rows[i].containsKey(ci) ? rows[i].get(ci) + 1 : 1);
                cols[j].put(ci, cols[j].containsKey(ci) ? cols[j].get(ci) + 1 : 1);
                tables[(i/3)*3 + j/3].put(ci,tables[(i/3)*3 + j/3].containsKey(ci)? tables[(i/3)*3 + j/3].get(ci) + 1: 1);

                if (rows[i].get(ci) > 1 || cols[j].get(ci) > 1 || tables[(i/3)*3 + j/3].get(ci) > 1)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] borad = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        Solution s = new Solution();
        System.out.println(s.isValidSudoku2(borad));
    }
}
