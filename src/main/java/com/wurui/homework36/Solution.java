package com.wurui.homework36;

/**
 * @description: 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @author: wurui
 * @create: 2019-04-01 11:29
 **/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length !=9) return false;
        char[][] rows = new char[9][9];// 行
        char[][] cols = new char[9][9];// 列
        char[][] tables = new char[3][3];// 3*3格子

        for (int i = 0 ;i < 9; i++){
            char[] row = board[i];
        }
        return true;
    }
}
