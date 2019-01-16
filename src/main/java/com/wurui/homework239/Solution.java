package com.wurui.homework239;

import java.util.*;

/**
 * @description: 239. 滑动窗口最大值
 * @author: wurui
 * @create: 2018-11-22 10:40
 **/
public class Solution {
    // 思路 可以使用窗口大小长度的 双向队列,移动后,进来的数比右边小,则忽略.比右边大则清空队列加入此数据.
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(nums.length);
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (deque.peekFirst()!=null && nums[deque.getFirst()] <= num){
                deque.clear();
                deque.addFirst(i);
            }else{
                for (Iterator<Integer> iterator = deque.iterator(); iterator.hasNext(); ) {
                    Integer next =  iterator.next();
                    if (nums[next] < num) iterator.remove();
                }

                deque.addLast(i);
            }



            if (deque.getFirst() <= i - k) deque.removeFirst();

            if (i >= k - 1){
                list.add(nums[deque.getFirst()]);
            }
        }

        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
           result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0},3)));
    }
}
