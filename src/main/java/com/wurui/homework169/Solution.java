package com.wurui.homework169;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description: 求众数
 * @author: wurui
 * @create: 2018-12-26 10:21
 **/
public class Solution {
    /**
     * 使用map解决.
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap(nums.length);

        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int counts;
        if (nums.length % 2 == 0) {
            counts = nums.length / 2;
        } else {
            counts = nums.length / 2 + 1;
        }
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            if (entry.getValue() >= counts) return entry.getKey();
        }

        return -1;
    }

    // 2 数组 快排(nlogn) 然后n遍历.找一共出现多少次.出现次数大于n/2的就是结果

    // 3.分治算法解决,不是太懂.
}
