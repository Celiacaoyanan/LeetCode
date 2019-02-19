class Solution(object):
    def search(self, nums, target):                          
        """                                                            
        :type nums: List[int]                                           
        :type target: int                                          
        :rtype: bool
        """                                                        
        if len(nums)==0 or nums==None:            
            return False                            
        start=0
        end=len(nums)-1
        while (start+1<end):
            while start+1<end and nums[start] == nums[end]: // difference with I, locate mid accurately
                start += 1
            mid=start+(end-start)/2
            if (nums[mid]==target):
                return True
            if (nums[mid]>=nums[start]): # case1
                if (target>=nums[start] and target<=nums[mid]):
                    end=mid
                else:
                    start=mid
            elif (nums[mid]<=nums[end]): # case2
                if (target>=nums[mid] and target<=nums[end]):
                    start=mid
                else:
                    end=mid

        if (nums[start]==target):
            return True
        if (nums[end]==target):
            return True
        return False
