//1.先对一个数组构建map  2.然后将map和另一个数组比较有相同的就放到result里  3.最后将arraylist转化为array
//map的相关操作put/get
// array/ArrayList的相关操作
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        for (int i=0; i<nums1.length; i++)
        {
            if (m.containsKey(nums1[i]))
            {
                m.put(nums1[i], m.get(nums1[i])+1);
            } 
            else
            {
                m.put(nums1[i], 1);
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();// in order to add elements dynamically
        for (int j=0; j<nums2.length; j++)
        {
            if (m.containsKey(nums2[j]) && m.get(nums2[j])>0)
            {
                result.add(nums2[j]);
                m.put(nums2[j], m.get(nums2[j])-1);
            }
        }
        
        //change from arraylist to array
        int[] finalResult=new int[result.size()];
        for (int i=0; i<result.size(); i++)
        {
            finalResult[i]=result.get(i);//note: different ways to get the elements
        }
        return finalResult;
    }
}
