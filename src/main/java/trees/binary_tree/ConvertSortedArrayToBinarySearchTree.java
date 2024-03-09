package trees.binary_tree;


public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        printTree(sortedArrayToBST(arr));
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructBST(nums, 0, nums.length - 1);
    }

    private static TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, left, mid - 1);
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }


    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
