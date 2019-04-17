package com.wurui.homework01;

import java.util.Stack;

/**
 * @description: 判断括号字符串是否有效
 * @author: wurui
 * @create: 2018-10-24 11:18
 **/
public class Solution {
    //() 合法
    //()[]  合法
    //([)]  非法
    //((([]))   非法
    //]][[  非法
    // 解决思路:
    // 1.遇到左括号入栈
    // 2.遇到右括号出栈
    // 3.运行结束判断stack是不是空的
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        String[] arrays = new String[]{")(","][","}{"};
        for (int i = 0; i < s.length(); i++) {
            Character character =  s.charAt(i);
            for (int j = 0; j < arrays.length; j++) {
                String array = arrays[j];
                char[] cArray = array.toCharArray();
                // 如果是遇到了右括号,从stack中弹出一个元素
                if (character == cArray[0]){
                    if (stack.isEmpty()){
                        return false;
                    }
                    Character tmp = stack.pop();
                    if (tmp != cArray[1]){
                        return false;
                    }
                    // 如果是左括号,加入stack
                }else if (character == cArray[1]){
                    stack.push(character);
                    break;
                }
            }
        }

        if (!stack.isEmpty()){
            return  false;
        }

        return true;
    }

    public static void main(String[] args){
        Solution s = new  Solution();
        System.out.println(s.check("()"));
        System.out.println(s.check("()[]"));
        System.out.println(s.check("((([]))"));
        System.out.println(s.check("]][["));
        System.out.println(s.check("([])"));
    }
}
