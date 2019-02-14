//similar to 15 //remember we record bestSum, not the difference between sum and target
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums==null || nums.length<3) return -1;
        Arrays.sort(nums);
        int bestSum=nums[0]+nums[1]+nums[2];
        for (int i=0;i<nums.length-2;i++) { //note: i<nums.length-2
            int left=i+1;
            int right=nums.length-1;
            while (left<right) {
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(bestSum-target)>Math.abs(sum-target)) {
                    bestSum=sum;
                }
                if (sum<target) {
                    left++;
                } else {
                    right--;
                }
            }            
        }
        return bestSum;
    }
}
