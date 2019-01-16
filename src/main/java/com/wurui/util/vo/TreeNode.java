package com.wurui.util.vo;

/**
 * @description:
 * @author: wurui
 * @create: 2018-12-06 14:48
 **/
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + (left == null ? "" : "," + left.toString())  + (right == null ? "" : "," + right.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        return val != null ? val.equals(treeNode.val) : treeNode.val == null;
    }

    @Override
    public int hashCode() {
        return val != null ? val.hashCode() : 0;
    }
}
