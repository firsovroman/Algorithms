import data_structures.linked_list.ListNode;

import java.util.*;

public class CodeTemplates {

    private static final int MINIMUM_POSSIBLE_ANSWER = 0;
    private static final Integer START_NODE = 1;
    private static final int CRITERIA = 2;
    private static final int MAXIMUM_POSSIBLE_ANSWER = 100;
    private static final boolean BOOLEAN = true;

    /** Два указателя: один вход, противоположные концы */
    public int fns(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        boolean CONDITION = true;

        while (left < right) {
            // делаем здесь некоторую логику с левым и правым
            if (CONDITION) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }


    /** Два указателя: два входа, оба выхода. */
    public int fn(int[] arr1, int[] arr2) {
        int i = 0, j = 0, ans = 0;
        boolean CONDITION = true;

        while (i < arr1.length && j < arr2.length) {
            // do some logic here
            if (CONDITION) {
                i++;
            } else {
                j++;
            }
        }

        while (i < arr1.length) {
            // do logic
            i++;
        }

        while (j < arr2.length) {
            // do logic
            j++;
        }

        return ans;
    }

    /** Sliding window */
    public int fnn(int[] arr) {
        int left = 0, ans = 0, curr = 0;
        boolean WINDOW_CONDITION_BROKEN = false;

        for (int right = 0; right < arr.length; right++) {
            // do logic here to add arr[right] to curr

            while (WINDOW_CONDITION_BROKEN) {
                // remove arr[left] from curr
                left++;
            }

            // обновляем результат ans
        }
        return ans;
    }


    /** Построить префиксную сумму */
    public int[] fnn2(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }



    /** Эффективное построение строки */
    public String fn(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }

        return sb.toString();
    }

    /** Linked list: быстрый и медленный указатель */
    public int fn(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int ans = 0;

        while (fast != null && fast.next != null) {
            // do logic
            slow = slow.next;
            fast = fast.next.next;
        }

        return ans;
    }

    /** Reversing a linked list */
    public ListNode fnn(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }


    /** Найти количество подмассивов, соответствующих точным критериям */
    public int fnw(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int ans = 0, curr = 0;

        for (int num: arr) {
            // do logic to change curr
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }


    /** Монотонно возрастающий стек */
    public int fnn3(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int num: arr) {
            // для монотонного убывания просто переверните > на <
            while (!stack.empty() && stack.peek() > num) {
                // do logic
                stack.pop();
            }

            stack.push(num);
        }

        return ans;
    }


    /** Binary tree: DFS (рекурсивно) */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        // do logic
        dfs(root.left);
        dfs(root.right);
        return ans;
    }



    /** Binary tree: DFS (Итеративно) */
    public int dfss(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            // do logic
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return ans;
    }




    /** Binary tree: слева направо, начиная с корня */
    public int fn(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            // do logic for current level

            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                // do logic
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return ans;
    }

    /** Graph: (поиск в глубину) (Итеративно) */
    public int fnq(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(START_NODE);
        seen.add(START_NODE);
        int ans = 0;

        while (!stack.empty()) {
            int node = stack.pop();
            // do some logic
            for (int neighbor: graph[node]) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }

        return ans;
    }


    /** Graph: (поиск в ширину) (Итеративно) */
    public int fn(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(START_NODE);
        seen.add(START_NODE);
        int ans = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            // do some logic
            for (int neighbor: graph[node]) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return ans;
    }





    /** Найти k верхних элементов с кучей */
    public int[] fn(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(CRITERIA);
        for (int num: arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }

        return ans;
    }


    /** Бинарный поиск */
    public int fnb(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // do something
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // left is the insertion point
        return left;
    }

    /** Бинарный поиск: повторяющиеся элементы, крайняя левая точка вставки. */
    public int fnn(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }



    /** Бинарный поиск: повторяющиеся элементы, крайняя правая точка вставки. */
    public int fnr(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }



    /** Бинарный поиск: для жадных задач */
    public int fn(int[] arr) {
        int left = MINIMUM_POSSIBLE_ANSWER;
        int right = MAXIMUM_POSSIBLE_ANSWER;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    public boolean check(int x) {
        // эта функция реализуется в зависимости от задачи
        return BOOLEAN;
    }


    /** Если ищете максимум: */
    public int fn2(int[] arr) {
        int left = MINIMUM_POSSIBLE_ANSWER;
        int right = MAXIMUM_POSSIBLE_ANSWER;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
    public boolean check2(int x) {
        // эта функция реализуется в зависимости от задачи
        return BOOLEAN;
    }

}

class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

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