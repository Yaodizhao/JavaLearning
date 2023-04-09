package LeetCode.困难;

//循环队列
public class s641MyCircularQueue {
    
    int[] myqueue;
    int front, rear;
    //  循环队列空满二义性标志
    int flag = 0;
    
    public s641MyCircularQueue(int k) {
        myqueue = new int[k];
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        myqueue[rear] = value;
        rear = (rear + 1) % myqueue.length;
        flag = 1;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % myqueue.length;
        flag = 0;
        return true;
    }
    
    public int Front() {
        if (isEmpty())
            return - 1;
        return myqueue[front];
    }
    
    public int Rear() {
        if (isEmpty())
            return - 1;
        if (rear == 0)
            return myqueue[myqueue.length - 1];
        else
            return myqueue[rear - 1];
    }
    
    public boolean isEmpty() {
        return front == rear && flag == 0;
    }
    
    public boolean isFull() {
        return front == rear % myqueue.length && flag == 1;
    }
}

