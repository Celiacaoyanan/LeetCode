class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=result[1]=-1;
        if (nums==null || nums.length==0) return result;
        
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while (start+1<end) {
            mid=start+(end-start)/2;
            if (target<nums[mid]) {
                end=mid;
            } else if (target>nums[mid]) {
                start=mid;
            } else {
                int left=mid;
                int right=mid;
                while (left>=start && nums[left]==target) {
                    left--;
                }
                while (right<=end && nums[right]==target) {
                    right++;
                }
                result[0]=left+1;
                result[1]=right-1;
                return result;
            }
        }
        if (nums[start]==target && nums[end]!=target) {
            result[0]=result[1]=start;
        }
        if (nums[end]==target && nums[start]!=target) {
            result[0]=result[1]=end;
        }
        if (nums[end]==target && nums[start]==target) {
            result[0]=start;
            result[1]=end;
        }
        return result;
    }
}
