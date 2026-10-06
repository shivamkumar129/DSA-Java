package BinarySearch;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class IsBST {
    
    public boolean isValidBST(TreeNode root) {
       ArrayList<Integer>arr=new ArrayList<>();
       inorder(root,arr);
       for(int i=1;i<=arr.size()-1;i++){
        if(arr.get(i)<=arr.get(i-1)){
            return false;
        }
       }
       return true;

    }
    private void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
    

// ! Optimal without arrayList 

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
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left))return false;
        if(prev!=null && root.val<=prev.val)return false;
        prev=root;
       return isValidBST(root.right);
    }
}