
/*
Explanation:
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. Replace the colour of all of the aforementioned pixels with the newColor.
*/

class Solution {
  private int[]delrow={-1,0,1,0};
  private int[]delcol={0,1,0,-1};
  private boolean isValid(int i,int j,int n,int m){
    if(i<0 ||i>=n) return false;
    if(j<0 ||j>=m) return false;
    return true;
  }
  private void dfs(int row,int col,int[][]ans,int[][]image,int newColor,int iniColor){
    ans[row][col]=newColor;
    int n=image.length;
    int m=image[0].length;
    for(int i=0;i<4;i++){
      int newrow=row+delrow[i];
      int newcol=col+delcol[i];
      if(isValid(newrow,newcol,n,m) && image[newrow][newcol]==iniColor && ans[newrow][newcol]!=newColor){
        dfs(newrow,newcol,ans,image,newColor,iniColor);
      }
    }
  }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
             int iniColor=image[sr][sc];
             int[][]ans=new int[image.length][image[0].length];
             for(int i=0;i<image.length;i++){
              ans[i]=Arrays.copyOf(image[i],image[i].length);
             }
             dfs(sr,sc,ans,image,newColor,iniColor);
             return ans;
    }
}

