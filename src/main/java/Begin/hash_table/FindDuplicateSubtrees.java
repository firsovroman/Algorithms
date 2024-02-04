package Begin.hash_table;

import java.util.*;

public class FindDuplicateSubtrees {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        TreeNode four3 = new TreeNode(4);


        root.left = two;
        root.right = three;

        two.left = four;

        three.left = two2;
        three.right = four2;

        two2.left = four3;

        System.out.println(findDuplicateSubtrees(root));

    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // Рекурсивно обходим дерево и строим строковое представление каждого поддерева
        traverse(root, map, result);

        return result;
    }

    // Рекурсивный метод для обхода дерева
    private static String traverse(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) {
            return "#"; // Пустое поддерево
        }

        // Строим уникальную строку для текущего поддерева
        String treeString = node.val + "," + traverse(node.left, map, result) + "," + traverse(node.right, map, result);

        int count = map.getOrDefault(treeString, 0);
        if (count == 1) {
            result.add(node);
        }

        map.put(treeString, count + 1);

        return treeString;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
