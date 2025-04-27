package code;

/*
    Codigo extraído del EJERCICIO 96 del cuaderno de ejercicios
*/

public class BinaryTree {
    // Root node pointer. Will be null for an empty tree.
    private Node root;

    /*
    --Node--
    The binary tree is built using this nested node class.
    Each node stores one data element, and has left and right
    sub-tree pointer which may be null.
    The node is a "dumb" nested class -- we just use it for storage; it does not have any methods.
    */
    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    /**
    * Creates an empty binary tree -- a null root pointer.
    */
    public void BinaryTree() {
        root = null;
    }

    /**
    * Returns true if the given target is in the binary tree. Uses a recursive
    * helper.
    *
    * @param data
    * @return
    */
    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    /**
    * Recursive lookup -- given a node, recur down searching for the given
    * data.
    */
    private boolean lookup(Node node, int data) {
        if (node == null) {
            return (false);
        }

        if (data == node.data) {
            return (true);
        } else if (data < node.data) {
            return (lookup(node.left, data));
        } else {
            return (lookup(node.right, data));
        }
    }

    /**
    * Inserts the given data into the binary tree. Uses a recursive helper.
    *
    * @param data
    */
    public void insert(int data) {
        root = insert(root, data);
    }


    /**
    * Recursive insert -- given a node pointer, recur down and insert the given
    * data into the tree. Returns the new node pointer (the standard way to
    * communicate a changed pointer back to the caller).
    */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return (node); // in any case, return the new pointer to the caller
    }

    public int size() {
        return (size(root));
    }

    private int size(Node node) {
        if (node == null) {
            return (0);
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    /**
    * Returns the max root-to-leaf depth of the tree. Uses a recursive helper
    * that recurs down to find the max depth.
    *
    * @return
    */
    public int maxDepth() {
        return (maxDepth(root));
    }

    private int maxDepth(Node node) {
        if (node == null) {
        return (0);
        } else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            // use the larger + 1
            return (Math.max(lDepth, rDepth) + 1);
        }
    }

    /**
    * Returns the min value in a non-empty binary search tree. Uses a helper
    * method that iterates to the left to find the min value.
    *
    * @return
    */
    public int minValue() {
        return (minValue(root));
    }

    /**
    * Finds the min value in a non-empty binary search tree.
    */
    private int minValue(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return (current.data);
    }

    /**
    * Prints the node values in the "inorder" order. Uses a recursive helper to
    * do the traversal.
    *
    * @return
    */
    @Override
    public String toString() {
        return aStringBuilder(root).toString();
    }

    private StringBuilder aStringBuilder(Node node) {
        StringBuilder sb = new StringBuilder("");
        if (node == null) {
        return sb;
        }
        // left, node itself, right
        return aStringBuilder(node.left).
        append(new StringBuilder(" " + node.data + " ")).
        append(aStringBuilder(node.right));
    }

    @Override
    public boolean equals(Object other) {
        /*
        Compares the receiver to another tree to
        see if they are structurally identical.
        */
        return (sameTree(root, ((BinaryTree) other).root));
    }

    /**
    * Recursive helper -- recurs down two trees in parallel, checking to see if
    * they are identical.
    */
    boolean sameTree(Node a, Node b) {
        // 1. both empty -> true
        if (a == null && b == null) {
            return (true);
        } // 2. both non-empty -> compare them
        else if (a != null && b != null) {
            return (a.data == b.data
            && sameTree(a.left, b.left)
            && sameTree(a.right, b.right));
        } // 3. one empty, one not -> false
        else {
            return (false);
        }
    }

    /**
    * Prints the node values in the "postorder" order. Uses a recursive helper
    * to do the traversal.
    */
    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        // first recur on both subtrees
        printPostorder(node.left);
        printPostorder(node.right);
        // then deal with the node
        System.out.print(node.data + " ");
    }
}
