package ru.spb.taranenkoant.leetCode;


import ru.spb.taranenkoant.leetCode.additional.TreeNode;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 28.10.2025
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.getRight() == null && root.getLeft() == null) {
            return 1;
        }

        int countRight = 0;
        int countLeft = 0;

        if (root.getRight() != null) {
            countRight++;
            countRight += maxDepth(root.getRight());
        }

        if (root.getLeft() != null) {
            countLeft++;
            countLeft += maxDepth(root.getLeft());
        }

        return Math.max(countLeft, countRight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        TreeNode rightTwenty = new TreeNode(20);
        rightTwenty.setRight(new TreeNode(15));
        rightTwenty.setLeft(new TreeNode(7));
        root.setRight(rightTwenty);
        int i = new MaximumDepthOfBinaryTree().maxDepth(root);
        System.out.println(i);
    }
}
