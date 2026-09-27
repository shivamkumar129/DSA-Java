package Arrays;

import java.util.*;

public class EvenFirst {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(firstUniqueEven(arr));
        sc.close();
    }


    static int firstUniqueEven(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(num%2==0){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        for(int num:nums){
            if(num%2==0 && map.get(num)==1){
                return num;
            }
        }
        return -1;
    }
}
