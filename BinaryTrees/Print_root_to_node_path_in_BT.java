
/*
Explanation:
Given the root of a binary tree. Return all the root-to-leaf paths in the binary tree.
A leaf node of a binary tree is the node which does not have a left and right child
*/

class Solution {
    public List<List<Integer>> allRootToLeaf(TreeNode root) { 
           List<List<Integer>> allPaths = new ArrayList<>();
     
        List<Integer> currentPath = new ArrayList<>();
    
        dfs(root, allPaths,currentPath);
        
        return allPaths;
    }
    private void dfs(TreeNode node,  List<List<Integer>> allPaths,List<Integer>cpath){
        if(node==null){
            return;
        }
        cpath.add(node.data);
        if(node.left==null && node.right==null)
        allPaths.add(new ArrayList<>(cpath));
        else{
            dfs(node.left,allPaths,cpath);
            dfs(node.right,allPaths,cpath);
        }
        cpath.remove(cpath.size()-1);
    }
}
