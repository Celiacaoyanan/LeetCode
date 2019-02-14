//三根指针，left表示0的最后一个index，right表示2的第一个index，然后用指针i来遍历数组，根据不同的情况做swap
class Solution {
    public void sortColors(int[] nums) {
        if (nums==null || nums.length<=1) return;
        int i=0;
        int left=0;
        int right=nums.length-1;
        while (i<=right) {
            if (nums[i]==0) {
                swap(nums,i,left);
                left++;
                i++;
            } else if (nums[i]==1) {
                i++;
            } else {
                swap(nums,i,right);
                right--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp=nums[j];
        nums[j]=nums[i];
        nums[i]=tmp;
    }
}
