
/*
Explanation:
You are given an 2D array queries of dimension n*2.

The queries[i] represents a range from queries[i][0] to queries[i][1] (include the end points).

Return the count of prime numbers present in between each range in queries array.
*/

class Solution {
        public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
            //your code goes here
            if(queries==null || queries.isEmpty()){
                return new ArrayList<>();
            }
            int maxVal=0;
            for(int[]query:queries){
                maxVal=Math.max(maxVal,query[1]);
            }
            boolean[]isPrime=new boolean[maxVal+1];
            for(int i=2;i<=maxVal;i++){
                isPrime[i]=true;
            }
            for(int p=2;p*p<=maxVal;p++){
                if(isPrime[p]){
                    for(int i=p*p;i<=maxVal;i+=p)
                    isPrime[i]=false;
                }
            }
            int[]primeCount=new int[maxVal+1];
            for(int i=1;i<=maxVal;i++){
                primeCount[i]=primeCount[i-1];
                if(isPrime[i])
                primeCount[i]++;
            }
            ArrayList<Integer>res=new ArrayList<>();
            for(int[]query:queries){
                int start=query[0];
                int end=query[1];
                if(start==0)
                res.add(primeCount[end]);
                else
                res.add(primeCount[end]-primeCount[start-1]);
            }
            return res;
        }
    }
