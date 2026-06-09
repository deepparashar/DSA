package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class LevelOrderTraversal {

    // level order traversal

     public List<List<Integer>> levelOrder(Node root) {
         Queue<Node> q = new LinkedList<Node>();
        List<List<Integer>> li  = new LinkedList<List<Integer>>();
        if(root == null) return li;
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> subLi = new LinkedList<Integer>();

            for(int i = 0; i <levelNum; i++){

                Node node = q.poll();

               if(node.left != null){
                q.offer(node.left);
               }
               if(node.right != null){
                q.offer(node.right);
               }
               subLi.add(node.val);
            }
            li.add(subLi);
        }
        return li;
    }

    // TC = O(N); 
    // SC = O(N);

    public static void main(String[] args) {
        
    }
}
