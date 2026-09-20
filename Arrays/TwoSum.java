package Arrays;
import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        // Write your solution here
        Scanner sc =new Scanner(System.in);
          System.out.println("enter size of array :");
        int n=sc.nextInt();
        System.out.println("enter target element :");
        int target=sc.nextInt();
        int[]arr=new int[n];
          System.out.println("enter  element :");
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(twoSum(arr, target)));
        sc.close();
    }
     static  int[] twoSum(int[] nums, int target) {
        
        for(int i =0;i<nums.length-1;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target)
           return new int[]{i,j};
        }
    }
   
      
    throw new IllegalArgumentException("Solution not found");
 }
}