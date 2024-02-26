package trees.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  Обход в порядке возрастания (inorder) - который сначала посещает левое поддерево, затем корень и, наконец, правое поддерево.

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
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

        System.out.println(inorderTraversal2(root)); // [4, 2, 5, 1, 3]
    }


    //  Обход по порядку (inorder) - который сначала посещает левое поддерево, затем корень и, наконец, правое поддерево.
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

}

