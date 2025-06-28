
/*
Explanation:
Given the root of a binary tree, return the top view of the binary tree.
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Return nodes from the leftmost node to the rightmost node. Also if 2 nodes are outside the shadow of the tree and are at the same position then consider the left ones only(i.e. leftmost). 
*/

class Solution {
     static class Pair<  K , V  > {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public List<Integer> topView(TreeNode root) {
       List< Integer > ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
          Queue< Pair < TreeNode ,Integer > > q = new LinkedList<>();
          q.add(new Pair<>(root,0));
        Map< Integer, Integer > mpp = new TreeMap<>();
        while(!q.isEmpty()){
                Pair<TreeNode,Integer>it=q.poll();
                TreeNode node=it.getKey();
                int line=it.getValue();
                if(!mpp.containsKey(line)){
                    mpp.put(line,node.data);
                }
                if(node.left!=null)
                q.add(new Pair(node.left,line-1));
                   if(node.right!=null)
                q.add(new Pair(node.right,line+1));
        }
           for (Integer value : mpp.values()) {
            ans.add(value);
        }
return ans;
    }   
}
