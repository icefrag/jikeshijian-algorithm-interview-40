//package com.wurui.homework04;
//
///**
// * @description:
// * @author: wurui
// * @create: 2018-10-30 16:49
// **/
//public class Solution {
//
//    //两两交换链表中的节点
//    //
//    //
//    //
//    public ListNode swapPairs(ListNode head) {
//    }
//
//    public static void main(String[] args){
//        ListNode head1 = new ListNode(1);
//        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
//        head1.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//        Solution s1 = new Solution();
//        System.out.println("start---------------->" +head1);
//
//        System.out.println("end---------------->" +s1.swapPairs(head1));
//    }
//}
//
//
//class ListNode {
//    public int val;
//    public ListNode next;
//    public ListNode(int x) {
//        val = x;
//    }
//
//    @Override
//    public String toString() {
//        return val + (next==null?"[]":"["+next.toString()+"]");
//    }
//}
