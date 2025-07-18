
/*
Explanation:
Given a number n, find the maximum possible LCM that can be obtained by selecting three numbers less than or equal to n.
Note: LCM stands for Lowest Common Multiple.
*/

class Solution {
    int lcmTriplets(int n) {
        int ans;
        if (n < 3) {
            ans = n;
        }
        else if (n % 2 != 0) {
            ans = n * (n - 1) * (n - 2);
        }
        else if (n % 3 != 0) {
            ans = n * (n - 1) * (n - 3);
        }
    else {
            ans = (n - 1) * (n - 2) * (n - 3);
        }

        return ans;
    }
}
