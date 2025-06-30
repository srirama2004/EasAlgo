
/*
Explanation:
Given root of binary tree, return the Inorder traversal of the binary tree.
Morris Inorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of O(1) without recursion or an external data structure.
*/

class Solution {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer>inorder=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
            inorder.add(cur.data);
            cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur)
                prev=prev.right;
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    inorder.add(cur.data);
                    cur=cur.right;
                }
            }
        }
        return inorder;
    }
}
