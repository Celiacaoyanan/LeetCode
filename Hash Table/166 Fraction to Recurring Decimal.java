//https://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num=numerator;
        long den=denominator;
        if (num==0 || den==0) return "0";
               
        String inte;
        boolean positive;
        if ((num>0 && den<0) || (num<0 && den>0)) {
            positive=false;
        } else {
            positive=true;
        }
        num=Math.abs(num);
        den=Math.abs(den);
        if(positive==false) {
            inte="-"+String.valueOf(num/den);
        } else {
            inte=String.valueOf(num/den);
        }
                
        if (num%den!=0) {// if there is decimal part
            HashMap<Long,Integer> map=new HashMap<>();
            StringBuilder frc=new StringBuilder();
            num=num%den;
            int pos=0;
            map.put(num,pos);
            while (num!=0) {
                num=num*10;
                frc.append(num/den);
                num=num%den;
                if (map.containsKey(num)) {
                    String pre=frc.substring(0,map.get(num));
                    String loop=frc.substring(map.get(num));
                    return inte+"."+pre+"("+loop+")";//unlimited and repeated decimal
                } else {
                    pos++;
                    map.put(num,pos);
                }
            }
            return inte+"."+frc.toString();//limited decimal
        }        
        return inte;//no decimal only integer part        
    }
}
