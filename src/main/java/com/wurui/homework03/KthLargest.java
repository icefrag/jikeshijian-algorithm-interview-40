package com.wurui.homework03;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: wurui
 * @create: 2018-10-30 11:02
 **/
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.offer(val);
        }else if (val > queue.peek()){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    // 实现思路,使用PriorityQueue 当内部是int时,最小的最优先出来.
    // 1.找第k大元素,只需要控制 PriorityQueue长度是k.因为 PriorityQueue使用的是小顶堆,因此最上面的元素永远是最小的.
    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int r = 0;
        r = kthLargest.add(3);   // returns 4
        System.out.println(r);
        r = kthLargest.add(5);   // returns 5
        System.out.println(r);
        r = kthLargest.add(10);  // returns 5
        System.out.println(r);
        r = kthLargest.add(9);   // returns 8
        System.out.println(r);
        r = kthLargest.add(4);   // returns 8
        System.out.println(r);
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for ( int i=0;i<100;i++){
            q.add(i);
        }

        for (Integer integer : q) {
            System.out.println(integer);
        }
    }
}
