// traverse from the left, if meet the val, put the right element to the current location 
class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        while (left<=right) {//must have =, eg: [1] 1
            if (nums[left]==val) {
                nums[left]=nums[right];
                right--;
            } else {
                left++;
            }
        }
        return right+1;
    }
}
