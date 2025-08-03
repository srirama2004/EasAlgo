
/*
Explanation:
You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation is represented as an array [v, r1, c1, r2, c2], where:

v is the value to be added
(r1, c1) is the top-left cell of a submatrix
(r2, c2) is the bottom-right cell of the submatrix (inclusive)
For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2). Return the final matrix after applying all operations.
*/

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int n=0;n<opr.length;n++){
            int num=opr[n][0];
            int istart=opr[n][1];
            int jstart=opr[n][2];
            int iend=opr[n][3];
            int jend=opr[n][4];
            for(int i=istart;i<=iend;i++){
                for(int j=jstart;j<=jend;j++){
                    mat[i][j]+=num;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            ArrayList<Integer> ans=new ArrayList<Integer>();
            for(int j=0;j<mat[0].length;j++){
                ans.add(mat[i][j]);
            }
            res.add(ans);
        }
        
        return res;
    }
}
