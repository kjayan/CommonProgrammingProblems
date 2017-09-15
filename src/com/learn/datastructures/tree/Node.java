package com.learn.datastructures.tree;

public class Node {

    private int data;
    private Node left;
    private Node right;
    private int hd;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, int hd) {
        this.data = data;
        this.hd = hd;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                ", hd=" + hd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return data == node.data;
    }

    @Override
    public int hashCode() {
        return data;
    }
}
