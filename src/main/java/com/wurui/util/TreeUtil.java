package com.wurui.util;

import com.wurui.util.vo.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: wurui
 * @create: 2018-12-20 10:57
 **/
public abstract class TreeUtil {
    public static TreeNode generateTreeNode(Integer[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return null;
        }

        int index = 1;
        List<TreeNode> first = new ArrayList<>();
        List<TreeNode> second = new ArrayList<>();

        TreeNode root = new TreeNode(arrays[0]);
        first.add(root);

        do {
            index = doeach(first,second,arrays,index);
            index = doeach(second,first,arrays,index);
        }while (index < arrays.length - 1);

        return root;
    }


    private static int doeach(List<TreeNode> first,List<TreeNode> second,Integer[] arrays,int index){
        for (Iterator<TreeNode> iterator = first.iterator(); iterator.hasNext(); ) {
            TreeNode next =  iterator.next();
            if (index <= arrays.length - 1){
                next.left = new TreeNode(arrays[index]);
                index ++ ;
                second.add(next.left);
            }

            if (index <= arrays.length - 1){
                next.right = new TreeNode(arrays[index]);
                index ++ ;
                second.add(next.right);
            }

            iterator.remove();

            if (index > arrays.length - 1)break;
        }

        return index;
    }

    public static void main(String[] args){
        TreeNode node = TreeUtil.generateTreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(node);
    }
}
