package Arrays;
// 42. Trapping Rain Water
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        // left max Boundary -array
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i = 1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);

        }
        // RightMax Boundary -array2
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
         for(int i = n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);

        }
        int trappedWater =0;
         for(int i = 0;i<n;i++){
            int waterLevel =Math.min(leftMax[i],rightMax[i]);
            trappedWater+=waterLevel-height[i];

        }

       return trappedWater;
    }
}
    //! TC: O(n) SC :O(1)

class Solution {
    public int trap(int[] arr) {
        int left=0,right=arr.length-1;
        int water=0;
        int left_max=arr[left],right_max=arr[right];
        while(left<right){
            if(left_max<right_max){
                left++;
               left_max=Math.max(left_max,arr[left]);
               water+=left_max-arr[left];

            }else{
                right--;
               right_max=Math.max(right_max,arr[right]);
               water+=right_max-arr[right];
            }
        }
        return water;

    }
}