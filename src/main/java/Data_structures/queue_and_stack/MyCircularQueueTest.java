package Data_structures.queue_and_stack;

class MyCircularQueue {

    int[] arr;
    int capacity;
    int size;
    int header;
    int tail;


    public MyCircularQueue(int k) {
        capacity = k;
        arr = new int[capacity];
        size = 0;
        header = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            header = 0;
        }
        tail = (tail + 1) % capacity;
        arr[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (header == tail) {
            header = -1;
            tail = -1;
        } else {
            header = (header + 1) % capacity;
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[header];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }
}

public class MyCircularQueueTest {

    public static void main(String[] args) {

        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }

}
