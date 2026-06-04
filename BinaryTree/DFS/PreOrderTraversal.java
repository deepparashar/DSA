package DFS;


// In Pre-order traversal we have to print root first than left than right

//In this i'm gonna write code in recursive as well as interative way using stack.

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


public class PreOrderTraversal{
   public static void main(String[] args) {
   
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    // Make more children for better visualization
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    // System.out.println("Pre-order traversal: ");
    // preOrder(root);

    System.out.println("\n\nPre-Order Traversal (Iterative): ");
        List<Integer> result = PreOrder(root);
        System.out.println(result);

   }

     // Recursive Pre-order traversal
    public static void preOrder(Node root){
      
        if(root == null)
            return;

        // Print root val
    System.out.print(root.val + " ");

       // Call for left child
    preOrder(root.left);
    // Call for right child
    preOrder(root.right);
   }


   // Pre-order traversal in iterative way (using stack)

   public static List<Integer> PreOrder(Node root){
       
        // First we have to decalre list to return
      List<Integer> preOrder = new ArrayList<Integer>();

      if(root == null){
        return preOrder;
      }
      //Declare Stack to put value in it
      Stack<Node> stack = new Stack<Node>();
  
      // we have to push root in stack
       stack.push(root);
        
       // while loop run till stack is empty
       while(!stack.isEmpty()){
        // First we have to take root out from stack
        root = stack.pop();

        // Then add it in list 
        preOrder.add(root.val);
         
        // Add right child first cause stack follows on LIFO principle (last in first out)
        if(root.right != null){
            stack.push(root.right);
        }
          
        // Add left child later
        if(root.left != null){
            stack.push(root.left);
        }
       }

      // Then return preOrder at last
      return preOrder;
   }
}