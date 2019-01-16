package com.wurui.homework122;

/**
 * @description: 买卖股票的最佳时机2
 * @author: wurui
 * @create: 2018-12-26 10:34
 **/
public class Solution {
    /**
     * 使用贪心算法.
     * 前提:
     * 1.每天可以无限制次数交易
     * 2.只能持有一股
     * 3.交易无手续费.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int current;
        int next;
        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1){
                current = prices[i];
                next = prices[i + 1];

                if (next > current){
                    totalProfit += next - current;
                }
            }
        }

        return totalProfit;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
