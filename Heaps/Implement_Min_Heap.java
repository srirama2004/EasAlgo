
/*
Explanation:
You need to implement the Min Heap with the following given methods.

insert (x) -> insert value x to the min heap
getMin -> Output the minimum value from min heap
exctractMin -> Remove the minimum element from the heap
heapSize -> return the current size of the heap
isEmpty -> returns if heap is empty or not
changeKey (ind, val) -> update the value at given index to val (index will be given 0-based indexing)
initializeHeap -> Initialize the heap
*/

class Solution {
    private List<Integer> arr; 
    private int count; 
    public Solution() {
        arr = new ArrayList<>();
        count = 0;
    }
    private void heapifyUp(List<Integer> arr, int ind) {
        int parentInd = (ind - 1)/2; 
        if(ind > 0 && arr.get(ind) < arr.get(parentInd)) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(parentInd));
            arr.set(parentInd, temp);
            heapifyUp(arr, parentInd);
        } 

        return;
    }
    private void heapifyDown(List<Integer> arr, int ind) {
        int n = arr.size(); 
        int smallestInd = ind; 
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;
        if(leftChildInd < n && arr.get(leftChildInd) < arr.get(smallestInd)) 
            smallestInd = leftChildInd;
        if(rightChildInd < n && arr.get(rightChildInd) < arr.get(smallestInd)) 
            smallestInd = rightChildInd;
        if(smallestInd != ind) {
            int temp = arr.get(smallestInd);
            arr.set(smallestInd, arr.get(ind));
            arr.set(ind, temp);
            heapifyDown(arr, smallestInd);
        }
        return; 
    }
    public void initializeHeap(){
        arr.clear();
        count = 0;
    }
    public void insert(int key){
        arr.add(key);
        heapifyUp(arr, count);
        count = count+1; 
        
        return;
    }
    public void changeKey(int index, int new_val){
        if(arr.get(index) > new_val) {
            arr.set(index, new_val);
            heapifyUp(arr, index);
        }
        else {
            arr.set(index, new_val);
            heapifyDown(arr, index);
        }

        return;
    }
    public void extractMin(){
        int ele = arr.get(0);
        int temp = arr.get(count - 1);
        arr.set(count - 1, arr.get(0));
        arr.set(0, temp);
        arr.remove(count - 1); 
        count = count - 1; 
        if(count > 0) {
            heapifyDown(arr, 0);
        }
    }
    public boolean isEmpty(){
        return (count == 0);
    }
    public int getMin(){
        return arr.get(0);
    }
    public int heapSize(){
        return count;
    }
}
