//f[i] record the max money we can get from robbing the first i houses
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int[] f=new int[nums.length+1];
        f[0]=0;
        f[1]=nums[0];
        for (int i=2;i<=nums.length;i++) {
            f[i]=Math.max(f[i-1],f[i-2]+nums[i-1]);
        }
        return f[nums.length];
    }
}
