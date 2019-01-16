package com.wurui.homework236;

import com.wurui.util.TreeUtil;
import com.wurui.util.vo.TreeNode;

/**
 * @description: 二叉树的最近公共祖先
 * @author: wurui
 * @create: 2018-12-10 15:50
 **/
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root ==null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }

    // 方法2
    // 如果node上有父亲节点指针的情况下,可以留 父亲nodePath,然后 p和q的path找最近一致的点.
    // 但是很多情况下node上并没有父亲node所以这个方法行不通了.
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.generateTreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = TreeUtil.generateTreeNode(new Integer[]{5,6,2,null,null,7,4});
        TreeNode q = TreeUtil.generateTreeNode(new Integer[]{1,0,8});
        System.out.println(solution.lowestCommonAncestor(root,p,q));
        p = TreeUtil.generateTreeNode(new Integer[]{5,6,2,null,null,7,4});
        q = TreeUtil.generateTreeNode(new Integer[]{4});
        System.out.println(solution.lowestCommonAncestor(root,p,q));
    }
}
