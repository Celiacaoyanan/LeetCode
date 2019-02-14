//sort array, iterate i, move left and right // note: how to skip the duplicates for i/left/right //Arrays.sort()
// -4   -1   -1   0   1   2   
//  i   left              right
//For every i, target=-nums[i], find nums[left]+nums[right]=target, if nums[left]+nums[right]<target, move left one step right, if nums[left]+nums[right]>target, move right one step left 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums==null || nums.length<3) return result;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            int target=-nums[i];
            twoSum(nums,left,right,target,result);          
        }
        return result;
    }
    
    public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> result) {
        while (left<right) {
            if (nums[left]+nums[right]==target) {
                List<Integer> tri=new ArrayList<>();
                tri.add(-target);//add -target not target
                tri.add(nums[left]);
                tri.add(nums[right]);
                result.add(tri);
                
                left++;
                right--;
                while (left<right && nums[left-1]==nums[left]) left++;// use while not if
                while (left<right && nums[right+1]==nums[right]) right--;
            } else if (nums[left]+nums[right]<target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
