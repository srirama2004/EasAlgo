
/*
Explanation:
Given the root of a binary tree, the value of a target node target, and an integer k. Return an array of the values of all nodes that have a distance k from the target node.
The answer can be returned in any order (N represents null).
*/

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null){
                parentMap.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right,node);
                queue.add(node.right);
            }
            
        }
        List<Integer>res=new ArrayList<>();
        Set<TreeNode>visited=new HashSet<>();
        queue.add(target);
        visited.add(target);
        int cudis=0;
        while(!queue.isEmpty()){
            if(cudis==k){
                while(!queue.isEmpty()){
                    res.add(queue.poll().data);
                }
                return res;
            }
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            cudis++;
        }
return res;
    }
}
