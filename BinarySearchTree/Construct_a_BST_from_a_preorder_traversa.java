
/*
Explanation:
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
It is guaranteed that it is always possible to find a binary search tree with the given requirements for the given test cases. Note. As there can be many possible correct answers, the compiler outputs true if the solution is correct, else false.
*/


class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorderHelper(int[] preorder, int bound, int[] index) {
        if (index[0] == preorder.length || preorder[index[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = bstFromPreorderHelper(preorder, root.data, index);
        root.right = bstFromPreorderHelper(preorder, bound, index);
        return root;
    }
}

