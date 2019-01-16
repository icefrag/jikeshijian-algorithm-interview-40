package com.wurui.homework22;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成
 * @author: wurui
 * @create: 2019-01-08 14:37
 **/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        _gen(result,"",n,n);
        return result;
    }

    private void _gen(List<String> result,String cur,int maxLeft,int maxRight){
        if (maxLeft == 0 && maxRight == 0){
            result.add(cur);
            return;
        }

        if (maxLeft > 0){
            _gen(result,cur + "(",maxLeft - 1,maxRight);
        }

        if (maxRight > maxLeft){
            _gen(result,cur + ")",maxLeft,maxRight - 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(4));
    }
}
