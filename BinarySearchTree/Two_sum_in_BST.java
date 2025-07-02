
/*
Explanation:
Given the root of a binary search tree and an integer k.Return true if there exist two elements in the BST such that their sum is equal to k otherwise false.
*/

class BSTIterator {
    private Stack<TreeNode> stack;
    private boolean reverse;
    public BSTIterator(TreeNode root, boolean isReverse) {
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = (reverse) ? node.right : node.left;
        }
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Get the next element in the inorder or reverse inorder traversal
    public int next() {
        TreeNode node = stack.pop();
        if (!reverse) pushAll(node.right);
        else pushAll(node.left);
        return node.data;
    }
}

class Solution {
    public boolean twoSumBST(TreeNode root, int k) {
        //your code goes here
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j<k)
            i=l.next();
            else if(i+j==k)
            return true;
            else
            j=r.next();
        }
        return false;
    }
}
