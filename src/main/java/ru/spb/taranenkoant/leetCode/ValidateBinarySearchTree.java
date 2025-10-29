package ru.spb.taranenkoant.leetCode;


import ru.spb.taranenkoant.leetCode.additional.TreeNode;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 29.10.2025
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        // Проверяем, находится ли значение узла в допустимом диапазоне
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Для левого поддерева: все значения должны быть < текущего узла
        // Для правого поддерева: все значения должны быть > текущего узла
        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(-1), null);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
}
