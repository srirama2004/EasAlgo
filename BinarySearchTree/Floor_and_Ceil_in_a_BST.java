
/*
Explanation:
Given a root of binary search tree and a key(node) value, find the floor and ceil value for that particular key value.

Floor Value Node: Node with the greatest data lesser than or equal to the key value. 
Ceil Value Node: Node with the smallest data larger than or equal to the key value.
If a particular floor or ceil value is not present then output -1.
*/

class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
        int floor=-1;
        int ceil=-1;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.data==key){
                floor=cur.data;
                ceil=cur.data;
                break;
            }
            else if(cur.data<key){
                floor=cur.data;
                cur=cur.right;
            }
            else{
                ceil=cur.data;
                cur=cur.left;
            }
        }
        return Arrays.asList(floor,ceil);
    }
}
