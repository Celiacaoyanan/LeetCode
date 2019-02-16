class Solution {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        
        boolean[][] isPalin=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++) {
            isPalin[i][i]=true;
        }
        
        int start=0;
        int length=1;
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i)==s.charAt(i+1)) {
                isPalin[i][i+1]=true;
                start=i;
                length=2;
            }
        }
        
        for (int i=s.length()-3;i>=0;i--) {// can't do for (int i=0;i<s.length()-2;i++), eg abcba
            for (int j=i+2;j<s.length();j++) {
                if (isPalin[i+1][j-1]==true && s.charAt(i)==s.charAt(j)) {
                    isPalin[i][j]=true;
                }
                    
                if (isPalin[i][j]==true && j-i+1>length) {
                    start=i;
                    length=j-i+1;
                }                    
                
            }
        }
        return s.substring(start, start+length);
    }
}
