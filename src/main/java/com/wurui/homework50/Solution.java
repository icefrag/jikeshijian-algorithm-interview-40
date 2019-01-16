package com.wurui.homework50;

/**
 * @description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @author: wurui
 * @create: 2018-12-24 10:27
 **/
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else {
            if (n % 2 != 0) return x * myPow(x, n / 2) * myPow(x, n / 2);
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(0.00001, 2147483647));
    }
}
