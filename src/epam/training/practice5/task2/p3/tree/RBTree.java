package tree;

import tree.exception.DuplicateTreeValueException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RBTree<T extends Comparable<T>> implements Iterable<T> {
    private final Node LEAF = new Node();
    private Node head = LEAF;

    public boolean insert(T value) {
        Node current;
        try {
            current = positionFor(value);
        } catch (DuplicateTreeValueException e) {
            return false;
        }

        if (current.parent == null) {    // head is null
            head = current;
        } else {
            fixParentReferences(current);
        }

        insertFix(current);
        return true;
    }

    private Node positionFor(T value) throws DuplicateTreeValueException {
        Node current = head;
        Node parent = null;

        while (current != LEAF) {
            if (current.key == value)
                throw new DuplicateTreeValueException();
            parent = current;
            current = move(current, value);
        }

        current = new Node(value, Color.RED, parent);
        return current;
    }

    private void fixParentReferences(Node inserted) {
        T insertedValue = inserted.key;
        T parentValue = inserted.parent.key;
        if (insertedValue.compareTo(parentValue) < 0) {
            inserted.parent.left = inserted;
        } else {
            inserted.parent.right = inserted;
        }
    }

    private void insertFix(Node item) {
        insert1(item);
    }

    private void insert1(Node node) {
        if (node.parent == null)
            node.color = Color.BLACK;
        else
            insert2(node);
    }

    private void insert2(Node node) {
        if (node.parent.color == Color.RED)
            insert3(node);
    }

    private void insert3(Node node) {
        Node uncle = uncle(node);
        if (uncle != null && uncle.color == Color.RED) {
            node.parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            Node grand = grandParent(node);
            grand.color = Color.RED;
            insert1(node);
        } else {
            insert4(node);
        }
    }

    private void insert4(Node node) {
        Node grand = grandParent(node);

        if (isRightChild(node) && node.parent == grand.left) {
            rotateLeft(node.parent);
            node = node.left;
        } else if (isLeftChild(node) && node.parent == grand.right) {
            rotateRight(node.parent);
            node = node.right;
        }
        insert5(node);
    }

    private void insert5(Node node) {
        Node grand = grandParent(node);
        node.parent.color = Color.BLACK;
        grand.color = Color.RED;
        if (isLeftChild(node) && node.parent == grand.left) {
            rotateRight(grand);
        } else {
            rotateLeft(grand);
        }
    }

    public boolean delete(T value) {
        Node toDelete = findNode(value);
        if (toDelete == null)
            return false;

        Node child = toDelete.right == LEAF ? toDelete.left : toDelete.right;

        replace(toDelete, child);

        if (toDelete.color == Color.BLACK) {
            if (child.color == Color.BLACK) {
                child.color = Color.BLACK;
            } else
                deleteFixUp(child);
        }

        return true;
    }


    private Node findNode(T value) {
        Node current = head;
        while (current != LEAF) {
            if (value.compareTo(current.key) == 0)
                return current;
            else
                current = move(current, value);
        }

        return null;
    }

    private void deleteFixUp(Node bottom) {
        delete1(bottom);
    }

    private void delete1(Node node) {
        if (node.parent == null) {
            delete2(node);
        }
    }

    private void delete2(Node node) {
        Node sibling = sibling(node);

        if (sibling.color == Color.RED) {
            node.parent.color = Color.RED;
            sibling.color = Color.BLACK;
            if (isLeftChild(node)) {
                rotateLeft(node.parent);
            } else {
                rotateRight(node.parent);
            }
        }
        delete3(node);
    }

    private void delete3(Node node) {
        Node sibling = sibling(node);

        if ((node.parent.color == Color.BLACK) && (sibling.color == Color.BLACK) &&
                (sibling.left.color == Color.BLACK) && (sibling.right.color == Color.BLACK)) {
            sibling.color = Color.RED;
            delete1(node.parent);
        } else {
            delete4(node);
        }
    }

    private void delete4(Node node) {
        Node sibling = sibling(node);

        if ((node.parent.color == Color.RED) && (sibling.color == Color.BLACK) &&
                (sibling.left.color == Color.BLACK) && (sibling.right.color == Color.BLACK)) {

            sibling.color = Color.RED;
            node.parent.color = Color.BLACK;
        } else {
            delete5(node);
        }
    }

    private void delete5(Node node) {
        Node sibling = sibling(node);

        if (isLeftChild(node) && (sibling.right.color == Color.BLACK) &&
                (sibling.left.color == Color.RED)) {

            sibling.color = Color.RED;
            sibling.left.color = Color.BLACK;
            rotateRight(sibling);
        } else if (isRightChild(node) && (sibling.left.color == Color.BLACK) &&
                (sibling.right.color == Color.RED)) {
            sibling.color = Color.RED;
            sibling.right.color = Color.BLACK;
            rotateLeft(sibling);
        }
        delete6(node);
    }

    private void delete6(Node node) {
        Node sibling = sibling(node);

        sibling.color = node.parent.color;
        node.parent.color = Color.BLACK;

        if (isLeftChild(node)) {
            sibling.right.color = Color.BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = Color.BLACK;
            rotateRight(node.parent);
        }
    }

    private Node sibling(Node node) {
        if (isLeftChild(node))
            return node.parent.right;
        else return node.parent.left;
    }

    private void rotateLeft(Node oldRoot) {
        Node newRoot = oldRoot.right;

        replace(oldRoot, newRoot);

        oldRoot.right = newRoot.left;    // set newRoot->left to oldRoot->right
        newRoot.left.parent = oldRoot;

        oldRoot.parent = newRoot;    // change relative references
        newRoot.left = oldRoot;
    }

    private void rotateRight(Node oldRoot) {
        Node newRoot = oldRoot.left;

        replace(oldRoot, newRoot);

        oldRoot.left = newRoot.right;    // set newRoot->right to oldRoot->left
        newRoot.right.parent = oldRoot;

        oldRoot.parent = newRoot;    // change relative references
        newRoot.right = oldRoot;
    }

    private void replace(Node replaced, Node replacement) {
        replacement.parent = replaced.parent;
        if (replaced.parent != null) {
            fixParentReferences(replacement);
        } else {
            head = replacement;
            head.color = Color.BLACK;
        }
    }

    private Node grandParent(Node node) {
        if (node.parent == null) {
            return null;
        } else {
            return node.parent.parent;
        }
    }

    private Node uncle(Node node) {
        Node grandParent = grandParent(node);
        if (grandParent == null)
            return null;
        if (node.parent == grandParent.left) {
            return grandParent.right;
        } else {
            return grandParent.left;
        }
    }

    private Node move(Node branch, T value) {
        return (value.compareTo(branch.key) < 0) ? branch.left : branch.right;
    }

    private boolean isLeftChild(Node item) {
        return item == item.parent.left;
    }

    private boolean isRightChild(Node item) {
        return !isLeftChild(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<T> {
        private Node next;

        private TreeIterator() {
            next = head;
            if (next == LEAF)
                return;

            while (next.left != LEAF) {
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return next != LEAF;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node returned = next;

            // If you can walk right, walk right, then fully left.
            // otherwise, walk up until you come from left.
            if (next.right != LEAF) {
                next = next.right;
                while (next.left != LEAF)
                    next = next.left;
                return returned.key;
            }

            while (true) {
                if (next.parent == null) {
                    next = LEAF;
                    return returned.key;
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return returned.key;
                }
                next = next.parent;
            }
        }
    }

    private class Node {
        Color color;
        T key;
        Node parent;
        Node left;
        Node right;

        private Node() {
            this.color = Color.BLACK;
        }

        public Node(T key, Color color, Node parent) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = RBTree.this.LEAF;
            this.right = RBTree.this.LEAF;
        }
    }

    private enum Color {
        RED, BLACK
    }
}