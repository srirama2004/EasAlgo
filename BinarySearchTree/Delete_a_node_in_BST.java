
/*
Explanation:
Given the root node of a binary search tree (BST) and a value key. Return the root node of the BST after the deletion of the node with the given key value.

Note: As there can be many correct answers, the compiler returns true if the answer is correct, otherwise false.
*/

class Solution {
    private TreeNode connector(TreeNode root){
        if(root.left==null)
        return root.right;
        if(root.right==null)
        return root.left;
        TreeNode leftChild=root.left;
        TreeNode leftmost=root.right;
        while(leftmost.left!=null)
        leftmost=leftmost.left;
        leftmost.left=leftChild;
        return root.right;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //your code goes here
        if(root==null)
        return null;
        if(root.data==key)
        return connector(root);
        TreeNode node=root;
        while(node!=null){
            if(node.data>key){
                if(node.left!=null && node.left.data==key){
                    node.left=connector(node.left);
                    break;
                }
                else
                node=node.left;
            }
        else{
             if(node.right!=null && node.right.data==key){
                    node.right=connector(node.right);
                    break;
                }
                else
                node=node.right;
        }
        }
        return root;
    }
}
