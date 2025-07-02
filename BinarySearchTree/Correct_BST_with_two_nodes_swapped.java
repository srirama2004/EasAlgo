
/*
Explanation:
Given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.Recover the tree without changing its structure.
*/

class Solution {
    private TreeNode first=null,middle=null,last=null,prev=null;
    void recoverTree(TreeNode root) {
        //your code goes here
        inorder(root);
        if(first!=null && last !=null){
            int t=first.data;
            first.data=last.data;
            last.data=t;
        }
        else   if(first!=null && middle !=null){
            int t=first.data;
            first.data=middle.data;
            middle.data=t;
        }
    }
    private void inorder(TreeNode node){
        if(node==null)
        return;
        inorder(node.left);
        if(prev!=null && prev.data>node.data){
            if(first==null){
                first=prev;
                middle=node;
            }
            else{
                last=node;
            }
        }
        prev=node;
        inorder(node.right);
    }
}
