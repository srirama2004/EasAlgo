
/*
Explanation:
Given a matrix mat of size N x M where every element is either ‘O’ or ‘X’. Replace all ‘O’ with ‘X’ that is surrounded by ‘X’. An ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below, above, left, and right of it.
*/

class Solution {
     private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    private boolean isValid(int i, int j, 
                            int n, int m) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        return true;
    }
    private void dfs(int row,int col,boolean[][]vis,char[][]mat){
        vis[row][col]=true;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(isValid(nrow,ncol,n,m) && !vis[nrow][ncol] && mat[nrow][ncol]=='O')
            dfs(nrow,ncol,vis,mat);
        }
    }
    public char[][] fill(char[][] mat) {
         int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int j=0;j<m;j++){
            if(!vis[0][j] && mat[0][j]=='O')
            dfs(0,j,vis,mat);
             if(!vis[n-1][j] && mat[n-1][j]=='O')
            dfs(n-1,j,vis,mat);
        }
        for(int j=0;j<n;j++){
            if(!vis[j][0] && mat[j][0]=='O')
            dfs(j,0,vis,mat);
             if(!vis[j][m-1] && mat[j][m-1]=='O')
            dfs(j,m-1,vis,mat);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='O' && !vis[i][j])
                mat[i][j]='X';
            }
        }
        return mat;
    }
}
