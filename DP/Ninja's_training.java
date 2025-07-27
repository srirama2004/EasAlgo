
/*
Explanation:
A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.



Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.
*/

class Solution {
    public int ninjaTraining(int[][] matrix) {
int n=matrix.length;
int[][]dp=new int[n][4];
dp[0][0]=Math.max(matrix[0][1],matrix[0][2]);
dp[0][1]=Math.max(matrix[0][0],matrix[0][2]);
dp[0][2]=Math.max(matrix[0][1],matrix[0][0]);
dp[0][3]=Math.max(matrix[0][0],Math.max(matrix[0][1],matrix[0][2]));
for(int day=1;day<n;day++){
    for(int last=0;last<4;last++){
        dp[day][last]=0;
        for(int task=0;task<3;task++){
            if(task!=last){
                int act=matrix[day][task]+dp[day-1][task];
                dp[day][last]=Math.max(dp[day][last],act);
            }
        }
    }
}
return dp[n-1][3];
    }
}
