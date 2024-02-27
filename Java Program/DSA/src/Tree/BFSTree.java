package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Queue<Node> queue = new LinkedList<Node>();
        BFSTree.bfsusingqueue(root, queue);
    }

    private static void bfsusingqueue(Node root, Queue<Node> queue) {
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currnode = queue.poll();

            System.out.println(currnode.data);

            if (currnode.left != null) {
                queue.add(currnode.left);
            }

            if (currnode.right != null) {
                queue.add(currnode.right);
            }
        }
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data1) {
        data = data1;
        left = null;
        right = null;
    }
}
