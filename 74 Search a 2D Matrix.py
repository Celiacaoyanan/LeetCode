2 binary search   note to several special cases []  [[]]
Use binary search to find which row it might be in, then use binary search to search in that row
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        # special case []
        if (len(matrix)==0): 
            return False
        
        # special case [[],[]]
        flag=0
        for m in matrix:
            if len(m)!=0:
                flag=1
        if flag==0:
            return False
        
        # rowFirst stores the first element in every row
        rowFirst=[]
        for row in matrix:
            rowFirst.append(row[0])
         
        # first binaty search to find the row number
        start=0
        end=len(rowFirst)-1  //Note: len()-1
        
        while (start+1<end):
            mid=start+(end-start)/2
            if (target==rowFirst[mid]):
                return True
            elif (target<rowFirst[mid]):
                end=mid
            else:
                start=mid

        if (rowFirst[start]==target or rowFirst[end]==target):
            return True
        if (target<rowFirst[start]):
            return False
        if (target>rowFirst[start] and target<rowFirst[end]):
            rowNum=start
        if (target>rowFirst[end]):
            rowNum=end
        
        # second binary search to seach in that row
        start=0
        end=len(matrix[rowNum])-1
        while (start+1<end):
            mid=start+(end-start)/2
            if (target==matrix[rowNum][mid]):
                return True
            elif (target<matrix[rowNum][mid]):
                end=mid
            else:
                start=mid
                
        if (target==matrix[rowNum][start] or target==matrix[rowNum][end]):
            return True
        return False
