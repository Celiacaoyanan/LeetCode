class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0; i<nums1.length; i++)
        {
            if (map.containsKey(nums1[i]))
            {
                map.put(nums1[i], map.get(nums1[i])+1);
            } else 
            {
                map.put(nums1[i], 1);
            }
        }
        
        List<Integer> result=new ArrayList<Integer>();
        for (int j=0; j<nums2.length; j++)
        {
            if (map.containsKey(nums2[j]) && !result.contains(nums2[j])) //和350的区别所在
            {
               result.add(nums2[j]);
            }
        }
            
        int[] finalResult=new int[result.size()];
        for (int i=0; i<result.size(); i++)
        {
            finalResult[i]=result.get(i);
        }
        return finalResult;
    }
}
