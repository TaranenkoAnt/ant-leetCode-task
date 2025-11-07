package ru.spb.taranenkoant.leetCode;


import ru.spb.taranenkoant.leetCode.additional.TreeNode;

import java.util.*;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 07.11.2025

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
public class Task102MediumBinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLevel = new ArrayList<>();
        currentLevel.add(root.val);
        result.add(currentLevel);

        List<List<Integer>> leftLevels = levelOrder(root.left);
        List<List<Integer>> rightLevels = levelOrder(root.right);

        int maxDepth = Math.max(leftLevels.size(), rightLevels.size());

        for (int i = 0; i < maxDepth; i++) {
            List<Integer> mergeLevel = new ArrayList<>();
            if (i < leftLevels.size()) {
                mergeLevel.addAll(leftLevels.get(i));
            }
            if (i < rightLevels.size()) {
                mergeLevel.addAll(rightLevels.get(i));
            }
            result.add(mergeLevel);
        }
        return result;
    }

    public List<List<Integer>> levelOrderEffective(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> lists = new Task102MediumBinaryTreeLevelOrderTraversal().levelOrderEffective(root);
        System.out.println(lists);
    }
}
