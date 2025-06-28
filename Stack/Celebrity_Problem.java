
/*
Explanation:
A celebrity is a person who is known by everyone else at the party but does not know anyone in return. Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise, determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.
*/

class Solution {
    public int celebrity(int[][] M) {
      int top=0;
      int down=M.length-1;
      while(top<down){
        if(M[top][down]==1)
        top++;
        else if(M[down][top]==1)
        down--;
        else{
            top++;
            down--;
        }
      }
      if(top>down)
      return -1;
      for(int i=0;i<M.length;i++){
        if(i==top)
        continue;
         if(M[top][i]==1 || M[i][top]==0)
         return -1;
      }
      return top;
    }
}
