// In Pre-order traversal we have to print left first than right than root

//In this i'm gonna write code in recursive way as well as in interative way using 2 stack.

// First create Node class

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{ 
    int val;
    Node left;
    Node right;

    public Node(int val){
       this.val = val;
       this.left = null;
       this.right = null;
    }

    public Node(int val, Node left, Node right){
      this.val = val;
      this.left = left;
      this.right = right;
    }
}



public class PostOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    // Make more children for better visualization
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    // postOrder(root);

    List<Integer> result = PostOrder(root);
    System.out.println(result);
    }

        // Recursive way 

     public static void postOrder (Node root){
        // Check if root is empty so we return
        if(root == null){
            return;
        }

        // If root is not empty call postOrder for left
        postOrder(root.left);
        // call postOrder for right for after left
        postOrder(root.right);

        // After that print root
        System.out.println(root.val + " ");
    }

    // Iterative way using 2 stack
    public static List<Integer> PostOrder(Node root){
       Stack<Node> st1 = new Stack<Node>();
       Stack <Node> st2 = new Stack<Node>();
       List<Integer> postOrder = new ArrayList<>();

       if(root == null) return postOrder;
       st1.push(root);
        
       while(!st1.isEmpty()){
         Node current  = st1.pop();
         st2.push(current);

         if(current.left != null) st1.push(current.left);
         if(current.right != null) st1.push(current.right);
       }
       
       while(!st2.isEmpty()){
        postOrder.add(st2.pop().val);
       }

       return postOrder;
    }
}

// Time complexity for this is O(N)
// Space complexity for this is O(2N) cause we use 2 stack.