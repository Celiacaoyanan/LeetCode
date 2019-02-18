class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> map1=new HashSet<>();
        HashSet<String> map2=new HashSet<>();
        for (int i=0;i+9<s.length();i++) {
            String tmp=s.substring(i,i+10);            
            if (!map1.add(tmp)) {// hashset returns false, if this value has already existed
                map2.add(tmp);
            } else {
                map1.add(tmp);
            }
        }        
        return new ArrayList(map2);
    }
}
