//use index pointer to point to the part that have already been deduplicated
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) return 0;        
        int index=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[index]!=nums[i]) {
                index++;
                nums[index]=nums[i];
            }
        }   
        return index+1;// cant return index++, because it means return index then index+1
    }
}
