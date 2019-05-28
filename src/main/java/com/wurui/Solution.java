package com.wurui;

/**
 * @description:
 * @author: wurui
 * @create: 2019-05-13 14:28
 **/
public class Solution {
    public int getMaxLength(String str) {
        int result = 0;
        String[] arr = str.split(" ");
        for (String s : arr) {
            result = s.length() > result ? s.length() : result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getMaxLength("aa aa aaaa  aaa a a a aa aaaaa aaa"));
    }
}
