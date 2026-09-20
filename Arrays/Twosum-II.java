package Arrays;
import java.util.*;
 class TwosumII {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
         int target = sc.nextInt();
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(TwosumIIA(arr,target)));
        sc.close();
    }

    private static int[] TwosumIIA(int[] arr,int target) {
       int start=0;
       int end=arr.length-1;
       while(start<end){
        int sum=arr[start]+arr[end];
        if(sum==target)return new int[]{start+1,end+1};
        if(sum>target){
            end--;
        }else{
            start++;
        }
       }
       return new int[]{-1,-1};
    }
}
