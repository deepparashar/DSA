// In this code file i will be solving question regarding Binary tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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

class Pair {
    Node node;
    int val;
    
    public Pair(Node node, int val){
        this.node = node;
        this.val = val;
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


   //  4). Same or identical tree
   //  https://leetcode.com/problems/same-tree/description/

    public boolean isSameTree(Node p, Node q) {
            if(p == null || q == null){
            return p == q;
        }
       return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

       
       // 5). Tree boundry traversal
        // https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
    
        boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
    
    void addLeft(Node root, ArrayList<Integer> ans){
        Node curr = root.left;
        while(curr !=null){
        if(!isLeaf(curr)) ans.add(curr.val);
        
            if(curr.left != null) curr = curr.left;
            else{
            curr = curr.right;
            }
        
        }
    }
    
     void addRight(Node root, ArrayList<Integer> ans){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        while(curr !=null){
        if(!isLeaf(curr)) temp.add(curr.val);
        
            if(curr.right != null) curr = curr.right;
            else{
            curr = curr.left;
            }
        
        
        
        }
        for(int i = temp.size()-1; i >= 0; --i){
            ans.add(temp.get(i));
        }
    }
    
     void addLeaf(Node root, ArrayList<Integer> ans){
         if(isLeaf(root)){
             ans.add(root.val);
             return;
         }
         
         if (root.left != null) addLeaf(root.left, ans);
         if (root.right != null) addLeaf(root.right, ans);
     }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(!isLeaf(root)) ans.add(root.val); 
        
        addLeft(root, ans);
        addLeaf(root, ans);
        addRight(root, ans);
        return ans;
        
    }

     // 6). Top view of binary tree
     //  https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

     public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()){
            Pair it= q.poll();
            int li = it.val;
            Node temp = it.node;
            
            if(map.get(li) == null) map.put(li, temp.val);
            
            if(temp.left != null){
                q.add(new Pair(temp.left, li - 1));
            }
            
             if(temp.right != null){
                q.add(new Pair(temp.right, li + 1));
            }
            
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
          ans.add(entry.getValue()); 
    }  
     return ans;    
    }
         

    // 7). Binary Tree Right Side View
    //https://leetcode.com/problems/binary-tree-right-side-view/description/

     private void revPre(Node root, int level, List<Integer> ans){
        if(root == null){
          return;
        }
        if(level == ans.size()){
            ans.add(root.val);
        }
         
         revPre(root.right, level + 1, ans);
         revPre(root.left, level + 1, ans);

       
      }

    public List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        revPre(root, 0, ans);
         return ans;
    }

    // 8). Symmetric Tree
    //  https://leetcode.com/problems/symmetric-tree/description/

    private boolean helper(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

    public boolean isSymmetric(Node root) {
        if(root == null) return true;

       return helper(root.left, root.right);
    }

    // 9).  Binary Tree Paths
    // https://leetcode.com/problems/binary-tree-paths/description

    public void helper (Node root, String path, List<String> ans){
        if(root == null) return;

        if(path.isEmpty()){
            path += root.val;
        }else{
            path+= "->" + root.val;
        }


        if(root.left == null && root.right == null){
            ans.add(path);
        }

        helper(root.left, path, ans);
        helper(root.right, path, ans);
    } 

      public List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root, "", ans);
        return ans;
      }

      // 10). Lowest Common Ancestor of a Binary Tree
      // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

      public Node lowestCommonAncestor(Node root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        } else{
            return root;
        }
      }


      // 11). Children sum parent
      // https://www.geeksforgeeks.org/problems/children-sum-parent/1

      public boolean isSumProperty(Node root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        int sum = 0;
        if(root.left != null){
            sum+= root.left.val;
        }

        if(root.right != null){
            sum+=root.right.val;
        }

        return (root.val == sum)
            && isSumProperty(root.left)
             && isSumProperty(root.right);

      }

      // 12). Count Complete Tree Nodes
      // https://leetcode.com/problems/count-complete-tree-nodes/description/
       public int countNodes(Node root) {
      if (root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        
        if (left == right) {
            return (1 << left) - 1; // 2^left - 1
        }

        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

   
    public int getHeightLeft(Node root) {
        int count = 0;
        while (root != null) { 
            count++;
            root = root.left;
        }
        return count;
    }

    
    public int getHeightRight(Node root) {
        int count = 0;
        while (root != null) { 
            count++;
            root = root.right;
        }
        return count;
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