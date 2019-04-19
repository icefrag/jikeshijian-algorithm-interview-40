package com.wurui.homework37;

import java.util.*;

/**
 * @description: 解数独
 * @author: wurui
 * @create: 2019-04-18 10:53
 **/
public class Solution {
    public void solveSudoku(char[][] board) {
        Map<String, List<Character>> locationMap = new HashMap<>(50);// 用于存储每个需要填的位置和对应可能写入的值。
        Map<Integer, List<Character>> rows = new HashMap<>();// 存每一行已经有的值
        Map<Integer, List<Character>> cols = new HashMap<>();// 存每一列已经有的值
        Map<Integer, List<Character>> tables = new HashMap<>();// 存每一个3*3已经有的值
        getInfo(board, locationMap, rows, cols, tables);
        solve(board, locationMap);
    }

    private boolean solve(char[][] board, Map<String, List<Character>> locationMap) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    List<Character> clist = locationMap.get(i + "," + j);
                    for (Character c : clist) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board, locationMap)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 行校验
            if (board[row][i] != '.' && board[row][i] == c) return false;
            // 列校验
            if (board[i][col] != '.' && board[i][col] == c) return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    private void getInfo(char[][] board, Map<String, List<Character>> locationMap, Map<Integer, List<Character>> rows, Map<Integer, List<Character>> cols, Map<Integer, List<Character>> tables) {
        // 遍历第一遍获取已有位置
        List<Character> tmp;
        if (rows.size() == 0){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Character c = board[i][j];
                    if (c == '.') continue;
                    // 行处理
                    setValue(rows, c, i);
                    // 列处理
                    setValue(cols, c, j);
                    // 3*3小格子处理
                    int index = (i / 3) * 3 + j / 3; // 获得每个table的唯一编号
                    setValue(tables, c, index);
                }
            }
        }

        // 遍历第二遍获取空白位置理论可以填入的值
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Character c1 = board[i][j];
                if (c1 != '.') continue;
                tmp = new ArrayList<>();
                for (int k = 49; k <= 57; k++) {
                    Character c = (char) k;
                    if ((rows.get(i) == null || !rows.get(i).contains(c)) && (cols.get(j) == null || !cols.get(j).contains(c)) && (tables.get((i / 3) * 3 + j / 3) == null || !tables.get((i / 3) * 3 + j / 3).contains(c))) {
                        tmp.add(c);
                    }
                }
                if (tmp.size() > 0) {
                    locationMap.put(i + "," + j, tmp);
                } else {
                    System.out.println("无理论可写入值!");
                }
            }
        }
    }

    private void setValue(Map<Integer, List<Character>> map, Character c, int index) {
        List<Character> tmp;
        if (map.get(index) == null) {
            tmp = new ArrayList<>();
            tmp.add(c);
            map.put(index, tmp);
        } else {
            map.get(index).add(c);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        s.solveSudoku(board);
    }
}
