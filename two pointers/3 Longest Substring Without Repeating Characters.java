//256 chars // fix slow pointer, move fast pointer, use an array to record whether the char that fast pointer point to has appeared or not, if no, move fast pointer one step right and set corresponding array to be 1, if yes, move slow pointer and set the corresponding array to 0
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map=new int [256];
        int slow=0;
        int fast=0;
        int length=0;
        for (slow=0; slow<s.length(); slow++) {
            while (fast<s.length() && map[s.charAt(fast)]==0) {
                map[s.charAt(fast)]=1;
                length=Math.max(length, fast-slow+1);
                fast++;                
            }
            map[s.charAt(slow)]=0;
        }
        return length;
    }
}
