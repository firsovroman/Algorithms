package tasks_about_tree;


/*

Нужен метод который считает сумму элементов дерева.

                20
            /        \
        7               35
      /    \          /    \
    4       9       31      40
      \            /           \
        6         28            52
*/


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CalculateSumForTree {

    public static void main(String[] args) {
        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4),
                        new Tree(9, null, new Tree(6))),
                new Tree(35,
                        new Tree(31,
                                new Tree(28),
                                null),
                        new Tree(40,
                                new Tree(38),
                                new Tree(52))));


        System.out.println("Сумма дерева sumRecursive: " + root.sumRecursive());

        System.out.println("Сумма дерева sumDeep: " + Tree.sumDeep(root));

        System.out.println("Сумма дерева sumWide: " + Tree.sumWide(root));



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


// рекурсивный обход в глубину
        public int sumRecursive() {
            int sum = value;

            if(left != null) {
                sum+=left.sumRecursive();
            }

            if(right != null) {
                sum+= right.sumRecursive();
            }

            return sum;
        }

        // итеративный обход в глубину
        public static int sumDeep(Tree root) {
            Stack<Tree> stack= new Stack<>();
            stack.push(root);

            int sum = 0;

            while(!stack.isEmpty()) {
                Tree node = stack.pop();
                sum += node.value;

                if(node.right != null) {
                    stack.push(node.right);
                }

                if(node.left != null) {
                    stack.push(node.left);
                }

            }
            return sum;
        }


        // итеративный обход в ширину
        public static int sumWide(Tree root) {
            Queue<Tree> queue = new ArrayDeque();

            queue.add(root);

            int sum = 0;

            while(!queue.isEmpty()) {
                Tree node = queue.remove();
                sum += node.value;

                if(node.right != null) {
                    queue.add(node.right);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }

            }
            return sum;
        }


    }

}
