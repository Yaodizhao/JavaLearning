package LeetCode.困难;

//循环双端队列
public class s622MyCircularDeque {
    
    int[] myqueue;
    int front, rear;
    //  循环队列空满二义性标志
    int flag = 0;
    
    public s622MyCircularDeque(int k) {
        myqueue = new int[k];
        front = 0;
        rear = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + myqueue.length) % myqueue.length;
        myqueue[front] = value;
        flag = 1;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        myqueue[rear] = value;
        rear = (rear + 1) % myqueue.length;
        flag = 1;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % myqueue.length;
        flag = 0;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + myqueue.length) % myqueue.length;
        flag = 0;
        return true;
    }
    
    public int getFront() {
        if (isEmpty())
            return - 1;
        return myqueue[rear];
    }
    
    public int getRear() {
        if (isEmpty())
            return - 1;
        if (front == 0)
            return myqueue[myqueue.length - 1];
        else
            return myqueue[front - 1];
    }
    
    public boolean isEmpty() {
        return front == rear && flag == 0;
    }
    
    public boolean isFull() {
        return front == rear % myqueue.length && flag == 1;
    }
}

