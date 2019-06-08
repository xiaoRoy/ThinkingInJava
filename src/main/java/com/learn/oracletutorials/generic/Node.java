package com.learn.oracletutorials.generic;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    private static class NodeErased {
        private Object data;
        private Node next;

        public NodeErased(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }


    private static class NodeWithBound<T extends Comparable<T>> {
        private T data;
        private Node<T> next;

        public NodeWithBound(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    private static class NodeWithBoundErased{
        private Comparable data;
        private Node node;

        public NodeWithBoundErased(Comparable data, Node node) {
            this.data = data;
            this.node = node;
        }

        public Comparable getData() {
            return data;
        }
    }
}
