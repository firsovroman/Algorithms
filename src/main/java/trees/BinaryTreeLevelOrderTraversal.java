package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// обход по уровням
public class BinaryTreeLevelOrderTraversal {


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

        System.out.println(levelOrder(root)); // [[1], [2, 3], [4, 5]]
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
            return result;
        }

        Deque<TreeNode> dequeTemp = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();
                list.add(node.val);
                dequeTemp.push(node);
            }


            while (!dequeTemp.isEmpty()) {
                TreeNode node = dequeTemp.pop();

                if (node.right != null) {
                    deque.push(node.right);
                }

                if (node.left != null) {
                    deque.push(node.left);
                }
            }

            result.add(list);
        }

        return result;
    }
}
