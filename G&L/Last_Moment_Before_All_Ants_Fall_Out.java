
/*
Explanation:
We have a wooden plank of length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second, with some moving left and others right.
When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time. When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

Given an integer n and two integer arrays left[] and right[], the positions of the ants moving to the left and the right, return the time when the last ant(s) fall out of the plank.
*/

class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int m=0;
        for(int i=0; i<left.length; i++){
            int time=left[i];
            if(time>m){
                m=time;
            }
        }
        for (int i=0; i<right.length; i++){
            int time = n-right[i];
            if(time>m){
                m = time;
            }
        }
        return m;
    }
}


