package com.wurui.homework08;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: wurui
 * @create: 2018-11-29 10:14
 **/
public class Solution {
    /**
     * 示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (i < length && j < length){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            map.put(s.charAt(j),j+1);
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
