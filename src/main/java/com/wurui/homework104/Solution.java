package com.wurui.homework104;

import com.wurui.util.vo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 二叉树的最大深度
 * @author: wurui
 * @create: 2018-12-29 10:39
 **/
public class Solution {
    // BFS算法
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int max = 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (deque.size() > 0) {
            max++;
            int length = deque.size();

            TreeNode temp;
            for (int i = 0; i < length; i++) {
                temp = deque.pop();
                if (temp.left != null)deque.addLast(temp.left);
                if (temp.right != null)deque.addLast(temp.right);
            }
        }

        return max;
    }

    // dfs算法(深度优先,或者叫分治算法吧)
    public int maxDepth2(TreeNode root) {
        if(root == null)return 0;

        int left_h = maxDepth2(root.left);
        int right_h = maxDepth2(root.right);

        return Math.max(left_h,right_h) + 1;
    }
}
