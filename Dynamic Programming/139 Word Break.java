//f[i] store whether the first i char (1~i) can be break
//for location i, check from j=1~i,whether there exist 1~j can be break, and j+1~i can be break, if there exist such j, then f[i]==true
// 注意此类题，同一个位置，f里面存的index比string的index大一位， 比如第一位在f里是f(1)，在string里的位置是0
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || s.length()==0) return true;
        boolean[] f=new boolean[s.length()+1];
        
        f[0]=true;
        for (int i=1;i<=s.length();i++) {
            for (int j=1;j<=i;j++) {
                if (f[i-j]==false) continue;//1~i-j cant be break, move to another j
                if(f[i-j]==true) {
                    if (wordDict.contains(s.substring(i-j,i))) {
                        f[i]=true;
                        break;//break out of second loop
                    }
                }
            }
        }
        return f[s.length()];
    }
}
