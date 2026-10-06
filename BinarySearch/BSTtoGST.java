package BinarySearch;


//! 1038. Binary Search Tree to Greater Sum Tree
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

// As a reminder, a binary search tree is a tree that satisfies these constraints:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:


// Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
// Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

// ! Using ArrayList TC:O(n) SC:O(n) soln 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<TreeNode> list=new ArrayList<>();
        inorder(root,list);
        Collections.reverse(list);
        int sum=0;
        for(int i=0;i<list.size();i++){
           int val=list.get(i).val;
           sum+=val;
           list.get(i).val=sum;

        }
        return root;
    }
      private void inorder(TreeNode root,ArrayList<TreeNode>list ){
            if(root==null)return;
            inorder(root.left,list);
            list.add(root);
            inorder(root.right,list);
        }
}


// ! Using only sum variable TC:O(n) SC:O(h)
class Solution {
      int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)return null;
      
        bstToGst(root.right);
        sum+=root.val;
        root.val=sum;
        bstToGst(root.left);
        return root;
    }
}