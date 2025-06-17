
/*
Explanation:
Given an integer array nums. Return the number of inversions in the array.
Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
It indicates how close an array is to being sorted.
A sorted array has an inversion count of 0.
An array sorted in descending order has maximum inversion.
*/

class Solution {
    private long merge(int[]arr,int low,int mid,int high){
        int[]temp=new int[high-low+1];
        int left=low;
        int right=mid+1;
        int index=0;
        long cnt=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right])
            temp[index++]=arr[left++];
            else{
                temp[index++]=arr[right++];
                cnt+=(mid-left+1);
            }
        }
        while(left<=mid){
            temp[index++]=arr[left++];
        }
        while(right<=high){
            temp[index++]=arr[right++];
        }
        System.arraycopy(temp,0,arr,low,high-low+1);
        return cnt;
    }
    private long mergeSort(int[]arr,int low,int high){
        long cnt=0;
        if(low<high){
            int mid=low+(high-low)/2;
            cnt+=mergeSort(arr,low,mid);
            cnt+=mergeSort(arr,mid+1,high);
            cnt+=merge(arr,low,mid,high);
        }
        return cnt;
    }
    public long numberOfInversions(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}
