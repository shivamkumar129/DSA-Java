
// ! Brute Force approach
// class Solution {
//     public int countSubstrings(String s) {
//         int cnt=0;

//         for(int i=0;i<s.length();i++){
//           for(int j=i;j<s.length();j++){
//             if(isPalindrome(s,i,j)){
//                 cnt++;
//             }
//           }
//         }
//         return cnt;
//     }
//     private boolean isPalindrome(String str,int l ,int r){
//         while(l<r){
//             if(str.charAt(l)!=str.charAt(r)){
//                 return false;
//             }
//         }
//         return true;


// ! Optimal 
class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            count+=expand(s,i,i);
            count+=expand(s,i,i+1);
        }
        return count;

    }
    private int expand(String s,int l,int r){
        int cnt=0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
}
