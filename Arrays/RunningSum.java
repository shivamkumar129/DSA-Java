
package Arrays;
// 1480. Running Sum of 1d Array
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

 


// Example 1:

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
class Solution {
    public int[] runningSum(int[] nums) {
        int[]ans=new int[nums.length];
       int runnigSum=0;
        for(int i=0;i<nums.length;i++){
           
            runnigSum+=nums[i];
             ans[i]=runnigSum;
        }
        return ans;
    }
}