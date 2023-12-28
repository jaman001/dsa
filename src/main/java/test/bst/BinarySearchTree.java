package test.bst;

public class BinarySearchTree {
    Node root;

    void display() {
        displaySubTree(root);
    }

    void displaySubTree(Node node) {
        if (node != null) {
            //This is inorder traversal. Shows sorted tree
            displaySubTree(node.left);
            System.out.println(node.data);
            displaySubTree(node.right);
        }
    }

    boolean search(int data) {
        if (searchSubTree(root, data)) {
            System.out.println(data + " found");
            return true;
        } else {
            System.out.println(data + " couldn't find");
            return false;
        }

    }

    private boolean searchSubTree(Node root, int data) {
        if (root == null) {
            //Reached the bottom of the BST without finding data.
            return false;
        } else if (root.data == data) {
            return true;
        } else if (root.data > data) {
            //Go left
            return searchSubTree(root.left, data);
        } else {
            //Go right
            return searchSubTree(root.right, data);
        }
    }

    void insert(Node node) {
        //Always inserts as a leaf node
        root = insertNode(root, node);
    }

    private Node insertNode(Node root, Node node) {
        if (root == null) {
            root = node;
        } else if (root.data < node.data) {
            //Go right
            root.right = insertNode(root.right, node);
        } else {
            //Go left
            root.left = insertNode(root.left, node);
        }
        return root;
    }

    //-------DELETION CODE STATS---------------
    //Little complex but concise code
    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found");
        }
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { // node found
            //Case 1. Node is a leaf node
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) { //find a successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { //find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) { //find least value below the right child of this root node
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {//find greatest value below the left child of this root node
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
//-------DELETION CODE ENDS---------------

//-------DELETION CODE STATS---------------
//Easy to understand and verbose code
    public void deleteNode(int key) {
        root = deleteNodeHelper(root, key);
    }

    private Node deleteNodeHelper(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.data) {
            node.left = deleteNodeHelper(node.left, key);
        } else if (key > node.data) {
            node.right = deleteNodeHelper(node.right, key);
        } else {
            // Node to be deleted found

            // Case 1: Node is a leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 3: Node has two children
            Node successor = findMin(node.right);
            node.data = successor.data;
            node.right = deleteNodeHelper(node.right, successor.data);
        }
        return node;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
//-------DELETION CODE ENDS---------------

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));
        //tree.display();
        tree.search(5);
        tree.search(8);
        tree.search(0);
    }
}
