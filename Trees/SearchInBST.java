//! Search in a Binary Search Tree
// You are given the root of a binary search tree (BST) and an integer val.

/*  Find the node in the BST that the node's value equals val and 
return the subtree rooted with that node. If such a node does not exist, return null.*/

package Trees;
import java.util.Scanner;

public class SearchInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Insert a value into the BST
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Search for a node in the BST
    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // Display the subtree using inorder traversal
    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        TreeNode root = null;

        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        System.out.print("Enter value to search: ");
        int target = sc.nextInt();

        TreeNode result = searchBST(root, target);

        if (result == null) {
            System.out.println("Node not found");
        } else {
            System.out.print("Subtree inorder: ");
            inorder(result);
            System.out.println();
        }

        sc.close();
    }
}