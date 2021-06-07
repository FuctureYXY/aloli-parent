package com.aloli.datastructure.tree;


import lombok.Data;

@Data
public class TreeNode {

    private Integer data;

    private TreeNode left;

    private TreeNode right;

    private int high;
}
