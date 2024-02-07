package Begin.QueueAndStack;

import java.util.ArrayList;
import java.util.List;

public class MinStackTest {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}

class MinStack {

    private List<Integer> data;
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int val) {
        data.add(val);
    }

    public void pop() {
        if(data.isEmpty()){
            return;
        }
        data.remove(data.size() - 1 );
    }

    public int top() {
        if(data.isEmpty()){
            return -1;
        }
        return data.get(data.size() - 1 );
    }

    public int getMin() {
        if(data.isEmpty()){
            return -1;
        }
        return data.stream().sorted().findFirst().get();
    }
}
