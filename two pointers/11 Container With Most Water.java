//When you consider a1 and aN, then the area is (N-1) * min(a1, aN). The base (N-1) is the maximum possible.
//This implies that if there was a better solution possible, it will definitely have the Height greater than min(a1, aN), which means the minimum is greater, so we discard the smaller one, If a1 < aN, then the problem reduces to solving the same thing for a2, aN.  Else, it reduces to solving the same thing for a1, aN-1

class Solution {
    public int maxArea(int[] height) {
        if (height.length==0 || height.length==1) return 0;
        int max=0;
        int left=0;
        int right=height.length-1;
        while (left<right) {
            int v=(right-left)*Math.min(height[left],height[right]);
            max=Math.max(max,v);
            if (height[left]<height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
