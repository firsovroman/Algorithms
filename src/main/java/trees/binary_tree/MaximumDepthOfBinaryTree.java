package trees.binary_tree;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                   \
                    5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
