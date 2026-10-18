package Arrays;
//! 1004. Max Consecutive Ones III
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int max_ans=0;
        int zeroCount=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                zeroCount++;
            }while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            max_ans=Math.max(max_ans,r-left+1);
        }
        return max_ans;
    }
}
