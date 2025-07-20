
/*
Explanation:
You are given an integer n representing the number of digits in a number, and an array arr[] containing digits from 0 to 9. Your have to count how many n-digit positive integers can be formed such that at least one digit from the array arr[] appears in the number.
*/

class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        int total=9*(int)Math.pow(10,(n-1));
        int size=set.size();
        int rem=10-size;
        int sub=set.contains(0)?rem * (int)Math.pow(rem, n-1):((rem-1)*(int)Math.pow(rem,(n-1)));
        return total-sub;
    }
}
