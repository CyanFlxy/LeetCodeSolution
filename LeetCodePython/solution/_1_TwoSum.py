

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        indexMap = {}
        length = len(nums)

        for index1 in range(length):
            v = nums[index1]
            diff = target - v

            if indexMap.get(diff, -1) != -1:
                return [indexMap.get(diff), index1]
            else:
                indexMap[v] = index1

        return None


result = Solution().twoSum([3, 2, 4, 3, 4], 8)
print(result)
