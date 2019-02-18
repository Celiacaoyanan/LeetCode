// key:target-nums[i]  value:I
//traverse all elements, if map doesn’t contain nums[i], the put (target-nums[i],i) in the map, otherwise there must exist an element nums[j] in the previous to satisfy that nums[j]+nums[i]=target, so return i, j
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        if (nums==null || nums.length==0) return result;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                result[0]=map.get(nums[i]);
                result[1]=i;
            } else {
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
}
