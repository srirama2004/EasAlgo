
/*
Explanation:
Given the root node of a binary search tree (BST) and an integer key. Return the Inorder predecessor and successor of the given key from the provided BST.



If predecessor or successor is missing then return -1.
*/

class Solution {
    List<Integer> succPredBST(TreeNode root, int key) {
        //your code goes here
        List<Integer> result=new ArrayList<>();
        TreeNode succ=null;
        TreeNode pred=null;
        while(root!=null){
            if(root.data==key){
                if(root.right!=null)
                succ=findMin(root.right);
                if(root.left!=null)
                pred=findMax(root.left);
                break;
            }
            else if(root.data>key){
                succ=root;
                root=root.left;
            }
            else{
                pred=root;
                root=root.right;
            }
        }
        if(pred!=null)
        result.add(pred.data);
        else
        result.add(-1);
          if(succ!=null)
        result.add(succ.data);
        else
        result.add(-1);
        return result;
    }
    private TreeNode findMax(TreeNode node){
        while(node.right!=null)
        node=node.right;
        return node;
    }
        private TreeNode findMin(TreeNode node){
        while(node.left!=null)
        node=node.left;
        return node;
    }
}
