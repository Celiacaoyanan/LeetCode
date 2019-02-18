//key is the alphabetic order of the words with the same chars, value is the list of actual words
//aet:[eat,tea,ate]
//abt:[bat]
//ant:[nat,tan]
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        if (strs==null || strs.length==0) return result;
        
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] sc=strs[i].toCharArray();//change string to char[] 
            Arrays.sort(sc);
            String s=String.valueOf(sc);//char[] to string
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                map.put(s,new ArrayList<>());
                map.get(s).add(strs[i]);
            }            
        }
        for (ArrayList each : map.values()) {
            result.add(each);
        }
        return result;        
    }
}
