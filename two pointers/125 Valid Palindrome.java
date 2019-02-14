//two pointers, one start from beginning, the other start from the end, note is how to skip the non letter/digit char
// Character.isLetter(c)   Character.isDigit(c)   Character.toLowerCase 
// the range from begin to left, and from right to end, there 2 parts must be symmetrical, so no matter left++  right-- to pass non letter, they won’t pass left or right, at most, left=right 
class Solution {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0) return true;
        int left=0;
        int right=s.length()-1;
        while (left<right) {
            while (left<s.length() && !isChar(s.charAt(left))) left++;// move left to the first letter/digit location             if (left==s.length()) return true; //  for empty string “.,,,”  
            while (right>=0 && !isChar(s.charAt(right))) right--;  // move right to the first letter/digit location   
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;   
    }
    
    public boolean isChar(char c) {
        if (Character.isLetter(c) || Character.isDigit(c)) return true;
        return false;
    }
}
