package com.ravi;

public class Queue<X> {
    private X[] data;
    private int front;
    private int end;

    public Queue() {
        this(1000);
    }

    public Queue(int size) {
        this.front = -1;
        this.end = -1;
        this.data = (X[]) new Object[size];
    }

    public void enqueue(X item) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full");
        }

        if (size() == 0) {
            front++;
            end++;
        } else {
            end++;
        }
        data[end] = item;
    }

    public X dequeue() {
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        X var = data[front];
        data[front] = null;
        if (front == end) {
            front = -1;
            end = -1;
        } else {
            front++;
        }
        return var;
    }

    public boolean contains(X var) {
        if (size() == 0) {
            return false;
        }

        for (int i = front; i < end; i++) {
            if (data[i].equals(var)) {
                return true;
            }
        }

        return false;
    }

    public X access(int position) {
        if (size() == 0) {
            throw new IllegalStateException("No items found in queue");
        }

        if (position > size()) {
            throw new IllegalStateException("Position outside range");
        }

        int index = 0;
        for (int i = front; i < end; i++) {
            if (index == position) {
                return data[index];
            }
            index++;
        }
        throw new IllegalArgumentException("Item not found");
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }
}
