
/*
Explanation:
You are given an integer array queries of length n.
Return the prime factorization of each number in array queries in sorted order.



*/

class Solution {
  private static final int MAX_N=100000;
  private int[]SPF=new int[MAX_N+1];
  public Solution(){
    Arrays.fill(SPF,1);
  }
  private void sieve(){
    for(int i=2;i<=MAX_N;i++){
      if(SPF[i]==1){
        for(int j=i;j<=MAX_N;j+=i){
          if(SPF[j]==1)
          SPF[j]=i;
        }
      }
    }
  }
  private List<Integer>primeFact(int n){
    List<Integer> ans=new ArrayList<>();
    while(n!=1){
      ans.add(SPF[n]);
      n=n/SPF[n];
    }
    return ans;
  }
        public List<List<Integer>> primeFactors(int[] queries) {
            //your code goes here
            sieve();
            List<List<Integer>> ans=new ArrayList<>();
            for(int q:queries){
              ans.add(primeFact(q));
             
            }
             return ans;
        }
}
