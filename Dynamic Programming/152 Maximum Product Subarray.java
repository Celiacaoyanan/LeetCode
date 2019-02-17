class Solution {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int[] min=new int[nums.length];
        int[] max=new int[nums.length];
        
        int result=nums[0];//result cant be equal to 0, because [-2], output should be -2
        min[0]=max[0]=nums[0];
        for (int i=1;i<nums.length;i++) {// there is i-1 later, so i must start from 1
            min[i]=max[i]=nums[i];//if nums[i]==0, min[i]=max[i]=nums[i],0以及0前面的都不取，从当前i开始取
            if (nums[i]>0) {
                //求max时，如果前面的乘上当前的比只取当前的还要小，那就从当前开始取，前面的都不要了
                min[i]=Math.min(min[i],min[i-1]*nums[i]);
                max[i]=Math.max(max[i],max[i-1]*nums[i]);
            } else if (nums[i]<0) {
                min[i]=Math.min(min[i],max[i-1]*nums[i]);
                max[i]=Math.max(max[i],min[i-1]*nums[i]);
            }
            result=Math.max(result,max[i]);
        }
        return result;
    }
}
