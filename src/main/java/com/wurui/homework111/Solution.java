package com.wurui.homework111;

import com.wurui.util.TreeUtil;
import com.wurui.util.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: . 二叉树的最小深度
 * @author: wurui
 * @create: 2018-12-29 17:07
 **/
public class Solution {
    /**
     * 使用广度优先算法(BFS)
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int high = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            TreeNode temp;
            high++;
            for (int i = 0; i < length; i++) {
                temp = queue.poll();
                if (temp.left == null && temp.right == null) return high;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return high;
    }

    /**
     * 使用深度优先算法(DFS)
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        if (root.right == null) {
            return minDepth2(root.left) + 1;
        }

        if (root.left == null) {
            return minDepth2(root.right) + 1;
        }

        return Math.min(minDepth2(root.left) + 1, minDepth2(root.right) + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeUtil.generateTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.minDepth2(TreeUtil.generateTreeNode(new Integer[]{1, 2})));
    }
}
