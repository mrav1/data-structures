package com.ravi;

public class BinaryTree<X extends Comparable<X>> {
    private Node root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(X item) {
        Node node = new Node(item);
        if (root == null) {
            root = node;
            size++;
        } else {
            insert(root, node);
        }
    }

    public boolean contains(X item) {
        if (getNode(item) == null) {
            return false;
        }

        return true;
    }

    public boolean delete(X item) {
        if (this.root == null) {
            return false;
        }

        unlink(this.root, item);
        return true;
    }

    private Node unlink(Node root, X key) {

        int var = key.compareTo(root.getData());
        if (var < 0) {
            root.left = unlink(root.left, key);
        } else if (var > 0) {
            root.right = unlink(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root.setData(minValue(root.right));
            unlink(root.getRight(), root.getData());
        }
        return root;
    }

    private X minValue(Node right) {
        X min = right.data;
        while (right.left != null) {
            min = right.left.data;
            right = right.left;
        }
        return min;
    }

    private Node getNode(X item) {
        Node currentNode = this.root;
        while (currentNode != null) {
            int var = item.compareTo(currentNode.getData());
            if (var == 0) {
                return currentNode;
            } else if (var < 0) {
                currentNode = currentNode.getLeft();
                return getNode(item);
            } else {
                currentNode = currentNode.getRight();
                return getNode(item);
            }
        }
        return null;
    }

    private void insert(Node parent, Node node) {
        if (parent.getData().compareTo(node.data) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
                node.setParent(parent);
                size++;
            } else {
                insert(parent.getLeft(), node);
            }
        } else if (parent.getData().compareTo(node.data) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(node);
                node.setParent(parent);
                size++;
            } else {
                insert(parent.getRight(), node);
            }
        } else {
            // Handle the equals case, which is not true for binary tree nodes expected to be unique
            insert(parent.getRight(), node);

        }
    }

    public int size() {
        return size;
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X data;

        public Node(X value) {
            this.data = value;
            left = null;
            right = null;
            parent = null;
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

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getData() {
            return data;
        }

        public void setData(X data) {
            this.data = data;
        }
    }
}
