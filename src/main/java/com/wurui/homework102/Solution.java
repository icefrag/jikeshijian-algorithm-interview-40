package com.wurui.homework102;

import com.wurui.util.vo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 二叉树的层次遍历
 * @author: wurui
 * @create: 2018-12-28 10:30
 **/
public class Solution {

    /**
     * 广度搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }


        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (deque.size() > 0) {
            List<Integer> current = new ArrayList<>();
            int length = deque.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = deque.pop();
                current.add(temp.val);

                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
            }

            result.add(current);
        }

        return result;
    }
}
