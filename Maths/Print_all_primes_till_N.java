
/*
Explanation:
You are given an integer n.
Print all the prime numbers till n (including n).
Sieve of Eratosthenes algorithm
*/

class Solution {
        public ArrayList<Integer> primeTillN(int n) {
            //your code goes here
            boolean[] isPrime=new boolean[n+1];
            for(int i=0;i<=n;i++){
              isPrime[i]=true;
            }
            ArrayList<Integer>ans=new ArrayList<>();
            for(long i=2;i<=n;i++){
              if(isPrime[(int)i]){
                ans.add((int)i);
                for(long val=i*i;val<=n;val+=i){
                  isPrime[(int)val]=false;
                }
              }
            }
            return ans;
                  }
}

