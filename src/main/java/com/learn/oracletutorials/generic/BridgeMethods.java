package com.learn.oracletutorials.generic;

public class BridgeMethods {

     static class Node<T> {
        private T data;

        public Node(T data) {
            this.data = data;
        }

         public void setData(T data) {
             this.data = data;
         }

         public T getData() {
             return data;
         }
     }

     static class IntegerNode extends Node<Integer> {

        public IntegerNode(Integer data) {
            super(data);
        }
    }

    static class NodeErased {
         private Object data;

        public NodeErased(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    static class IntegerNodeErased extends NodeErased {
        public IntegerNodeErased(Object data) {
            super(data);
        }

        // Bridge method generated by the compiler
        //
        public void setData(Object data) {
            setData((Integer) data);
        }

        public void setData(Integer data) {
            super.setData(data);
        }
    }
}
