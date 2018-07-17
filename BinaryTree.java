/**
 * Simple Binary Tree creation that takes a sorted array of integers when instantiated
 */

public class BinaryTree {

    int[] dataSet;
    Node root;

    public BinaryTree(int[] dataSet) {
        this.dataSet = dataSet;
        this.root = new Node(dataSet[dataSet.length / 2], null, null);

        for (int i = dataSet.length / 2 - 1; i >= 0; i--) {
            insertion(dataSet[i]);
        }
        for (int i = dataSet.length / 2 + 1; i < dataSet.length; i++) {
            insertion(dataSet[i]);
        }
    }

    class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public void insertion(int value) {
        if (value < root.value) {
            Node availableLeftNode = lastNodeLeft(root);
            availableLeftNode.leftChild = new Node(value, null, null);
        } else {
            Node availableRightNode = lastNodeRight(root);
            availableRightNode.rightChild = new Node(value, null, null);
        }
    }

    public Node lastNodeLeft(Node root) {
        if (root.leftChild != null)
            root = lastNodeLeft(root.leftChild);

        return root;
    }

    public Node lastNodeRight(Node root) {
        if (root.rightChild != null)
            root = lastNodeRight(root.rightChild);

        return root;
    }
}

class Testing {

    public static void main(String[] args) {

        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i + 1;
        }

        BinaryTree tree = new BinaryTree(arr);
    }

}
