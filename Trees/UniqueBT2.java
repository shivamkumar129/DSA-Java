package Trees;

// 95. Unique Binary Search Trees II
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

// Example 1:


// Input: n = 3
// Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// Example 2:

// Input: n = 1
// Output: [[1]]
 

// Constraints:
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

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    public List<TreeNode> build(int start, int end) {

        // Store all possible trees
        List<TreeNode> result = new ArrayList<>();

        // No numbers available
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every number as root
        for (int root = start; root <= end; root++) {

            // Create all possible left subtrees
            List<TreeNode> leftTrees =
                build(start, root - 1);

            // Create all possible right subtrees
            List<TreeNode> rightTrees =
                build(root + 1, end);

            // Combine every left tree with every right tree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    // Create root
                    TreeNode rootNode = new TreeNode(root);

                    // Attach left and right
                    rootNode.left = left;
                    rootNode.right = right;

                    // Store this tree
                    result.add(rootNode);
                }
            }
        }

        return result;
    }
}