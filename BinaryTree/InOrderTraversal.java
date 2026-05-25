// In In-order traversal we have to print left first than root than right

//In this i'm gonna write code in recursive as well as interative way using stack.


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

public class InOrderTraversal {
    public static void main(String[] args) {
        
          Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    // Make more children for better visualization
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println("Pre-order traversal: ");
    inOrder(root);


    }

     // Recursive Pre-order traversal
    public static void inOrder(Node root){
      
        if(root == null)
            return;

        
        // Call for left child
        inOrder(root.left);
        // Print root val
        System.out.print(root.val + " ");
        // Call for right child
       inOrder(root.right);
}
}
