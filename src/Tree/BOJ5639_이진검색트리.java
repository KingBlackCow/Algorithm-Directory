package Tree;

import java.io.IOException;
import java.util.Scanner;

public class BOJ5639_이진검색트리 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = new Node(N);
        while(sc.hasNext()) {
            try {
                N = sc.nextInt();
                root = insertNode(root, N);
            } catch (Exception e) {

                break;
            }

        }
        postOrder(root);
    }
    public static class Node{
        Node left;
        Node right;
        int weight;
        public Node(int v) {
            this.weight = v;
        }

    }
    public static Node insertNode(Node node, int N) {
        Node cnt = null;
        if(node == null) {
            return new Node(N);
        }

        if(node.weight > N) {
            cnt = insertNode(node.left, N);
            node.left = cnt;
        }else {
            cnt = insertNode(node.right, N);
            node.right = cnt;
        }
        return node;
    }

    public static void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.weight);
        }
    }
}
