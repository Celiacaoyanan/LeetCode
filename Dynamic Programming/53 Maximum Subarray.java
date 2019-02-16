//Divide and conquer
//1 Divide array in two halves
//2 Return the maximum of following three
//2.1 Maximum subarray sum in left half (Make a recursive call)
//2.2 Maximum subarray sum in right half (Make a recursive call)
//2.3 Maximum subarray sum such that the subarray crosses the midpoint
//2.1 and 2.2 are simple recursive calls.For 2.3,  We can easily find the crossing sum in linear time. The idea is simple, find the maximum sum starting from mid point and ending at some //point on left of mid, then find the maximum sum starting from mid + 1 and ending with sum point on right of mid + 1. Finally, //combine the two and return.
//https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        
        return helper1(nums,0,nums.length-1);
    }
    
    public int helper1(int[] nums, int start, int end) {
        if (start==end) return nums[start];
        int mid=start+(end-start)/2;
        return Math.max(Math.max(helper1(nums, start, mid), helper1(nums, mid+1, end)), helper2(nums, start, end, mid));
    }
    
    public int helper2(int[]nums, int start, int end, int mid) {
        int sum=0;
        int leftSum=Integer.MIN_VALUE;
        for (int i=mid; i>=start;i--) {
            sum+=nums[i];
            if (sum>leftSum) leftSum=sum;
        }
        
        sum=0;
        int rightSum=Integer.MIN_VALUE;;
        for (int i=mid+1; i<=end; i++) {
            sum+=nums[i];
            if (sum>rightSum) rightSum=sum;
        }
        return leftSum+rightSum;
    }
}
