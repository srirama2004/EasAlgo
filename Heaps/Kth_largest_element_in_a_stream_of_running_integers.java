
/*
Explanation:
Implement a class KthLargest to find the kth largest number in a stream. It should have the following methods:

KthLargest(int k, int [] nums) Initializes the object with the integer k and the initial stream of numbers in nums
int add(int val) Appends the integer val to the stream and returns the kth largest element in the stream.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/

class KthLargest {
    private int K;
    private PriorityQueue<Integer>pq;
    public KthLargest(int k, int[] nums) {
K=k;
pq=new PriorityQueue<>();
for(int i=0;i<nums.length;i++){
    if(pq.size()<K) pq.offer(nums[i]);
    else if(nums[i]>pq.peek()){
        pq.poll();
        pq.offer(nums[i]);
    }
}
    }

    public int add(int val) {
               if(pq.size()<K){
                pq.offer(val);
                return pq.peek();
               }
               if(val>pq.peek()){
                pq.poll();
                pq.offer(val);
               }
               return pq.peek();
    }
}
