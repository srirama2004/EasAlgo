
/*
Explanation:
Compute the binary tree's vertical order traversal given its root.
The left and right children of a node at location (row, col) will be at (row + 1, col - 1) and (row + 1, col + 1), respectively. The tree's root is located at (0, 0).

*/

class Solution {
    static class Tuple{
         TreeNode node;
        int x;
        int y; 
        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)
        return res;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> nodesMap=new TreeMap<>();
        Queue<Tuple>q=new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            TreeNode node=t.node;
            int x=t.x;
            int y=t.y;
            nodesMap.putIfAbsent(x,new TreeMap<>());
             nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodesMap.get(x).get(y).offer(node.data);
            if(node.left!=null)
            q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null)
            q.offer(new Tuple(node.right,x+1,y+1));
        }
for(TreeMap<Integer,PriorityQueue<Integer>>yMap :nodesMap.values()){
    List<Integer>col=new ArrayList<>();
    for(PriorityQueue<Integer>nodes:yMap.values()){
        while(!nodes.isEmpty()){
            col.add(nodes.poll());
        }
    }
    res.add(col);
}
return res;
    }   
}
