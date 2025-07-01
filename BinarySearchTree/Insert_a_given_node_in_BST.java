
/*
Explanation:
Given the root node of a binary search tree (BST) and a value val to insert into the tree. Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST. Note that the compiler output shows true if the node is added correctly, else false.
*/

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //your code goes here
        if(root==null)
        return new TreeNode(val);ert
        TreeNode cur=root;
        while(true){
            if(val<cur.data){
                if(cur.left==null){
                    cur.left=new TreeNode(val);
                    break;
                }
                else
                cur=cur.left;
            }
            else{
                 if(cur.right==null){
                    cur.right=new TreeNode(val);
                    break;
                }
                else
                cur=cur.right;
            }
        }
        return root;
    }
}
