package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// "Прямой обход." (Pre-order Traversal) Сначала посещение корня. Затем пройдите через левое поддерево. Наконец, пройдите правое поддерево.
public class BinaryTreePreorderTraversal {

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


        System.out.println(preorderTraversal(root)); // [1, 2, 4, 5, 3]
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            list.add(curNode.val);

            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return list;
    }

}