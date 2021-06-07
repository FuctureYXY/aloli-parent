package com.aloli.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;

public class treeTest {
    public static void main(String[] args) {
        int[]  arr = {24,39, 22, 1, 5, 14, 8, 77, 33, 11, 22};
        TreeNode treeNode =      new TreeNode();
        for (int i : arr) {
            insertTree(i,treeNode);
        }
        //midorderTraversal(treeNode);

        sequenceTraversal(treeNode);
        //出队
    }

    /**
     * 插入到树结构里面
     * 二叉查找树 二叉排序树 二叉搜索树
     * 左子树的键值小于根的键值，右子键的键值大于根的键值
     */
    public static void insertTree(int data,TreeNode treeNode){
            if(treeNode.getData()==null){
                treeNode.setData(data);
                treeNode.setHigh(treeNode.getHigh());
                return;
            }
            if(treeNode.getData()==data){
                return;
            }
            if(data>treeNode.getData()){
                TreeNode  rightNode = treeNode.getRight();
                if(rightNode==null){
                    rightNode= new TreeNode();
                    rightNode.setHigh(treeNode.getHigh()+1);
                    treeNode.setRight(rightNode);
                }
                insertTree(data,rightNode);
            }
            if(data<treeNode.getData()){
                TreeNode  leftNode = treeNode.getLeft();
                if(leftNode==null){
                    leftNode= new TreeNode();
                    leftNode.setHigh(treeNode.getHigh()+1);
                    treeNode.setLeft(leftNode);

                }
                insertTree(data,leftNode);
            }
    }

    //平衡二叉树
    public void insertBalanceTree(){

    }


    //左旋
    public static  void  sinistrogyration(){

    }

    //右旋
    public static void dextrorotation(){

    }


    /**
     * 中序遍历
     * 可以知道 中序遍历  可以按照从小到大或者从大到小来进行排序
     */
    public static  void  midorderTraversal(TreeNode treeNode){

        if(treeNode==null){
            return;
        }
        midorderTraversal(treeNode.getRight());
        System.out.println(treeNode.getData());
        midorderTraversal(treeNode.getLeft());
    }


    //层序遍历
    public static void sequenceTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedBlockingDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            System.out.println("value"+treeNode.getData()+"  hight"+treeNode.getHigh());
            if(treeNode.getLeft()!=null){
                queue.add(treeNode.getLeft());
            }
            if(treeNode.getRight()!=null){
                queue.add(treeNode.getRight());
            }
        }
    }

}

