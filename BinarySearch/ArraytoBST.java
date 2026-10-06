package BinarySearch;

// 108. Convert Sorted Array to Binary Search Tree
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

// Example 1:


// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
      return  convert(nums,0,n-1);
    }
    private TreeNode convert(int[]nums,int start,int end){
        if(start>end)return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
       root.left=convert(nums,start,mid-1);
       root.right= convert(nums,mid+1,end);
        return root;
        
    }
}