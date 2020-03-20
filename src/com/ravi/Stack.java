package com.ravi;

public class Stack<X> {

    private X[] data;
    private int pointer;

    public Stack() {
        this.data = (X[]) new Object[1000];
        this.pointer = 0;
    }

    public void push(X value) {
        if(this.pointer==this.data.length){
            throw new IllegalStateException("Stack overflow");
        }
        this.data[this.pointer++] = value;
    }

    public X pop() {
        if(this.pointer==0){
            throw new IllegalStateException("Stack underflow");
        }
        return this.data[--this.pointer];
    }

    public boolean contains(X value){
        for(X var: data){
            if(var.equals(value))
                return true;
        }
        return false;
    }

    public X get(int index) throws IllegalAccessException {
        for (int i = 0; i < pointer; i++) {
            if(i==index)
                return data[i];
        }

        throw new IllegalAccessException("Item not found");
    }

    public int size(){
        return pointer;
    }

}
