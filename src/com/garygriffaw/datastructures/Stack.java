package com.garygriffaw.datastructures;

public class Stack<T> {

    private LinkedList list;

    public Stack() {
        list = new LinkedList<T>();
    }

    public <T> void push(T newValue) {
        list.addLast(newValue);
    }

    public T pop() {
        if(isEmpty())
            throw new IllegalStateException();

        return (T) list.removeLast();
    }

    public T peek() {
        if(isEmpty())
            throw new IllegalStateException();

        return (T) list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
