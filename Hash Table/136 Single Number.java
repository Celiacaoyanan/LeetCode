class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length==1) return nums[0];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue().equals(1)) return e.getKey();
        }        
        return -1;        
    }
}
