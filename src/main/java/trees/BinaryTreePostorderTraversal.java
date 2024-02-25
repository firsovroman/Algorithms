package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//  Первый обход левого поддерева. Затем пройдите правое поддерево. Наконец, посетите корень.
public class BinaryTreePostorderTraversal {


    public static void main(String[] args) {
        // Пример использования:
        /*
                    1
                   / \
                  2   3
                 / \
                4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        System.out.println(postorderTraversal(root)); // [4, 5, 2, 3, 1]
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val); // добавляем в начало списка

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;
    }

}
