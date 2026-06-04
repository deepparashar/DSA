// In this code file i will be solving question regarding Binary tree

import javax.swing.tree.TreeNode;

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

public class Question {

    // 1). Finding maximum depth in binary tree
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
       
     public static int maxDepth(Node root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right); // we add 1 because of root node

        // for this time & space complexity = O(N) 
    }

    // 2). Diameter of binary tree
    // https://leetcode.com/problems/diameter-of-binary-tree/description/

     public int diameterOfBinaryTree(Node root) {
       int maxi[] = new int[1];
        find(root, maxi);
       return maxi[0];
    }

     private int find(Node root, int[] maxi){
     if(root == null){
        return 0;
     }

     int lh = find(root.left, maxi);
     int rh = find(root.right, maxi);

     maxi[0] = Math.max(maxi[0], lh + rh);

     return 1 + Math.max(lh, rh);

    }
    
    // 3). Maximum path sum
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/

    int max = Integer.MIN_VALUE; // global max to store maximum path sum.
    public int maxPathSum(Node root) {
        helper(root);
        return max;
    }

    private int helper(Node root){
        if(root == null){
            return 0;
        }

        int lh = Math.max(0, helper(root.left));  // To avoid -ve 
        int rh = Math.max(0, helper(root.right));

       int pathMax = lh + rh + root.val;  
       max = Math.max(max, pathMax);   

       return root.val + Math.max(lh, rh);

    }


    public static void main(String[] args) {
             Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    // Make more children for better visualization
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    
    }
}