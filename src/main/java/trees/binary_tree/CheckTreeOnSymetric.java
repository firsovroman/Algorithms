package trees.binary_tree;


/*

Определить симетрично ли дерево

               1
            /      \
           2         2
          /  \      /  \
         3    4    4    3
        / \  / \  / \   / \
        1 2  2 2  2 2   2 1
*/


import java.util.ArrayDeque;
import java.util.Queue;

public class CheckTreeOnSymetric {

    public static void main(String[] args) {
        Tree root = new Tree(1,
                        new Tree(2,
                            new Tree(3,
                                    new Tree(1),
                                    new Tree(2)),
                            new Tree(4,
                                    new Tree(2),
                                    new Tree(2))),
                        new Tree(2,
                            new Tree(4,
                                    new Tree(2),
                                    new Tree(2)),
                            new Tree(3,
                                    new Tree(2),
                                    new Tree(1))));



        System.out.println("It is symmetric? iteration result : " + Tree.isSymmetricTree_IterativeAlgorithm(root));

        System.out.println("It is symmetric? recursive result : " + Tree.isSymmetricTree_RecursiveAlgorithm(root));

    }




    public static class Tree {

        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }


        public static boolean isSymmetricTree_RecursiveAlgorithm(Tree root) {
            return isSymmetricInternal(root, root);
        }

        public static boolean isSymmetricInternal(Tree n1, Tree n2) {

            if(n1 == null && n2 != null || n1 != null && n2 == null){
                return false;
            }

            if(n1 == null && n2 == null) {
                return true;
            }

            return (n1.value == n2.value)
                    && isSymmetricInternal(n1.left, n2.right)
                    && isSymmetricInternal(n1.right, n2.left );
        }


        // итеративный обход в ширину
        public static boolean isSymmetricTree_IterativeAlgorithm(Tree root) {
            Queue<Tree> queue = new ArrayDeque();
            queue.add(root);
            queue.add(root);

            while(!queue.isEmpty()) {
                Tree node = queue.remove();
                Tree node2 = queue.remove();


                if(node.right == null && node2.left == null) {
                    continue;
                }

                if((node.right == null && node2.left != null) || (node2.right != null && node.left  == null)){
                    return false;
                }

                if(node.right.value == node2.left.value) {
                    queue.add(node.right);
                    queue.add(node2.left);
                } else {
                    return false;
                }

                if(node2.right.value == node.left.value) {
                    queue.add(node2.right);
                    queue.add(node.left);
                } else {
                    return false;
                }
            }
            return true;
        }




    }

}
