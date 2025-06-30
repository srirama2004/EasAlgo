
/*
Explanation:
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. Ensure that a binary tree can be serialized to a string, and this string can be deserialized to the original tree structure.
*/

class Solution {
    public String serialize(TreeNode root) {
        if(root==null)
        return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur==null){
                sb.append("#,");
            }
            else{
                sb.append(cur.data).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty())
        return null;
        StringBuilder s=new StringBuilder(data);
        String str;
        int ci=s.indexOf(",");
        str=s.substring(0,ci);
        s.delete(0,ci+1);
        TreeNode root=new TreeNode(Integer.parseInt(str));
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
                while (!q.isEmpty()) {
            TreeNode node = q.poll();
            ci = s.indexOf(",");
            str = s.substring(0, ci);
            s.delete(0, ci + 1);
            if (!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                q.offer(leftNode);
            }
              ci = s.indexOf(",");
            str = s.substring(0, ci);
            s.delete(0, ci + 1);
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                q.offer(rightNode);
            }
    }
    return root;
}
}
