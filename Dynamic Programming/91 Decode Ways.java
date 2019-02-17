//f[i] record how many ways to decode in the previous i digits
class Solution {
    public int numDecodings(String s) {
        if (s==null || s.length()==0) return 0;
        int[] f=new int[s.length()+1];
        f[0]=1;
        if (s.charAt(0)=='0') {
            f[1]=0;
        } else {
            f[1]=1;
        }
        
        //对于第i位，考察前i-1位时，f[i]=f[i-1]，考察前i-2位时，f[i]+=f[i-2]
        for (int i=2;i<=s.length();i++) {
            if (s.charAt(i-1)!='0') {//第i位在s中是charAt(i-1)
                f[i]=f[i-1];
            }
            int twoDigit=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
            if (twoDigit>=10 && twoDigit<=26) {
                f[i]+=f[i-2];
            }
        }
        return f[s.length()];
    }
}
