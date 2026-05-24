// This is a beginner friendly code representation of Binary Tree (BT)

class Node {
    int val;           // Store value in node
    Node right;        // right child   
    Node left;         // left child

      //constructor
    public Node(int val) {
        this.val = val;
        this.left = null;         
        this.right = null;
    }
    
}

public class BinaryTreeRepresentation {
        public static void main(String[] args) {
                  
              // Create root node
            Node root = new Node(1);  

           root.left = new Node(2);  // left child
           root.right = new Node(3);  // right child

             // Adding more Nodes for better visualization
               root.left.left = new Node(4);
               root.left.right = new Node(5);
               root.right.left = new Node(6);
               root.right.right = new Node(7);

               //Printing tree
               System.out.println("----------Binary Tree Representation---------- ");
               System.out.println("Root Node: " + root.val);
               System.out.println("Left child: " + root.left.val);
               System.out.println("Right child: " + root.right.val);
               System.out.println("Left child children: " + "Left: " + root.left.left.val + " "+ "Right: " + root.left.right.val);
               System.out.println("Right child children: " + "Left: " + root.right.left.val + " " + "Right: " + root.right.right.val);

              System.out.println("\nNote: This printing method is hardcoded.");
        System.out.println("In future, we will create a helper function (printTree) "
                         + "to print any size of tree dynamically.");
    }
}