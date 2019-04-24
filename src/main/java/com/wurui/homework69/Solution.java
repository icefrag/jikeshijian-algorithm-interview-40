package com.wurui.homework69;

/**
 * @description: 计算x的平方根
 * @author: wurui
 * @create: 2019-04-23 20:59
 **/
public class Solution {
    /**
     * 使用二分查找法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int right, left, mid, res;
        right = x;
        left = 1;
        res = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
