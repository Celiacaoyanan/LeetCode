//similar to 15  //fix i and j, move left and right // note: iterate range of i and j, how to skip duplicates
//1   2   3   4   5   6   7
//i   j  left             right
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums==null || nums.length<4) return result;
        Arrays.sort(nums);
        
        for (int i=0;i<nums.length-3;i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            
            for (int j=i+1;j<nums.length-2;j++) {
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=nums.length-1;
                while (left<right) {
                    if (nums[i]+nums[j]+nums[left]+nums[right]==target) {
                        List<Integer> q=new ArrayList<>();
                        q.add(nums[i]);
                        q.add(nums[j]);
                        q.add(nums[left]);
                        q.add(nums[right]);
                        result.add(q);
                        
                        left++;
                        right--;
                        while (left<right && nums[left]==nums[left-1]) left++;
                        while (left<right && nums[right]==nums[right+1]) right--;
                    } else if (nums[left]+nums[right]<target-nums[i]-nums[j]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
