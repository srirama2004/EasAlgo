
/*
Explanation:
Given the root node of a binary search tree (BST) and an integer k.
Return the kth smallest and largest value (1-indexed) of all values of the nodes in the tree.
Return the 1st integer as kth smallest and 2nd integer as kth largest in the returned array.
*/

class Solution {
     private int k;
    private int result;
    public int kthSmallest(TreeNode root,int k){
        this.k=k;
        this.result=-1;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode node){
        if(node!=null){
            inorder(node.left);
            if(--k==0){
            result=node.data;
            return;
        }
        inorder(node.right);
        }
    }
     public int kthLargest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        reverseInorder(root);
        return result;
    }
    private void reverseInorder(TreeNode node) {
        if (node != null) {
            reverseInorder(node.right);
            if (--k == 0) {
                result = node.data;
                return;
            }
            reverseInorder(node.left);
        }
    }
    public List<Integer> kLargesSmall(TreeNode root, int k) {
          List<Integer> result = new ArrayList<>();
        result.add(kthSmallest(root, k));
        result.add(kthLargest(root, k));
        return result;
    }
}
