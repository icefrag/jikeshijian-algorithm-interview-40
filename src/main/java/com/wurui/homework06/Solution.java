package com.wurui.homework06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 判断两个单词是不是异位词
 * @author: wurui
 * @create: 2018-11-23 17:28
 **/
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return new String(c1).equals(new String(c2));
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character,Integer> sMap = new HashMap<>(s.length());
        Map<Character,Integer> tMap = new HashMap<>(t.length());
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        for (int i=0;i<c1.length;i++){
            char temp1 = c1[i];
            char temp2 = c2[i];

            if (sMap.containsKey(temp1)){
                sMap.put(temp1,sMap.get(temp1) + 1);
            }else {
                sMap.put(temp1,1);
            }

            if (tMap.containsKey(temp2)){
                tMap.put(temp2,tMap.get(temp2) + 1);
            }else {
                tMap.put(temp2,1);
            }
        }

        return sMap.equals(tMap);
    }
    
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.isAnagram2("anagram","nagaram"));
    }
}
