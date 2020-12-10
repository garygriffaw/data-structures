package com.garygriffaw.datastructures;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private Node first;
    private Node last;
    private int size;

    public <T> void addFirst (T newValue) {
        Node newNode = new Node(newValue);

        if(isEmpty())
            last = newNode;
        else
            newNode.next = first;

        first = newNode;
        size++;
    }

    public <T> void addLast(T newValue) {
        Node newNode = new Node(newValue);

        if(isEmpty())
            first = newNode;
        else
            last.next = newNode;

        last = newNode;
        size++;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();

        if(hasOnlyOneNode()) {
            first = null;
            last = null;
        } else {
            Node oldFirst = first;
            first = first.next;
            oldFirst.next = null;
        }

        size--;
    }

    public void removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        if(hasOnlyOneNode()) {
            first = null;
            last = null;
        } else {
            Node previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    public <T> boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public <T> int indexOf(T value) {
        Node current = first;
        int idx = 0;

        while(current != null) {
            if(current.value == value)
                return idx;

            current = current.next;
            idx++;
        }

        return -1;
    }

    public void reverse() {

        if(isEmpty() || hasOnlyOneNode())
            return;

        Node previous = first;
        Node current = first.next;

        while(current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        Node temp = first;
        first = last;
        last = temp;
        last.next = null;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public Node getNth(int pos) {
        if(isEmpty() || pos <= 0 || pos > size)
            return null;

        Node current = first;
        for(int i = 1; i < pos; i++)
            current = current.next;

        return current;
    }

    public Node getNthFromEnd(int pos) {
        if(isEmpty() || pos <= 0 || pos > size)
            return null;

        Node lead = first;
        for(int i = 1; i < pos; i++)
            lead = lead.next;

        Node current = first;
        while(lead.next != null) {
            lead = lead.next;
            current = current.next;
        }

        return current;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean hasOnlyOneNode() {
        return !isEmpty() && (first == last);
    }

    private Node getPrevious(Node node) {
        Node current = first;

        while (current.next != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }

        return null;
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "[]";

        Node current = first;
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        while(true) {
            sb.append(current.value);
            if(current.next == null)
                return sb.append("]").toString();
            else
                sb.append(", ");
            current = current.next;
        }
    }

}

