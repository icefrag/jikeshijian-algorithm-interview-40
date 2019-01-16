package com.wurui.homework98;

import com.wurui.util.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:  判断二叉树是否为 搜索二叉树.
 * @author: wurui
 * @create: 2018-12-06 15:07
 **/
public class Solution {
    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        InOrderTraverse(node, list);

        System.out.println(list);

        boolean result = true;

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && list.get(i) >= list.get(i + 1)) {
                result = false;
                break;
            }

        }

        return result;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param list
     */
    public void InOrderTraverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        InOrderTraverse(node.left, list);
        list.add(node.val);
        InOrderTraverse(node.right, list);
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(treeNode1));
    }
}
