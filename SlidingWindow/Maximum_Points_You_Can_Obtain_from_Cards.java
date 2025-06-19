
/*
Explanation:
Given N cards arranged in a row, each card has an associated score denoted by the cardScore array. Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row. The score is the sum of the scores of the chosen cards.
Return the maximum score that can be obtained. (Medium)
*/

class Solution {
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int l=0,lsum=0,rsum=0;
        int n=cardScore.length;
        int r=n-1;
        for(int i=0;i<k;i++)
        lsum=lsum+cardScore[i];
        int maxsum=lsum;
         for(int i=k-1;i>=0;i--){
            lsum=lsum-cardScore[i];
            rsum+=cardScore[r];
            r--;
            maxsum=Math.max(maxsum,lsum+rsum);
         }
        return maxsum;
    }
}
