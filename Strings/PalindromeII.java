class Solution {
    public boolean validPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return isPalindrome(s,start+1,end) ||isPalindrome(s,start,end-1);
            }
            start++;
            end--;
        }
        return true;
    }
    private boolean isPalindrome(String str,int l,int r){
         
        while(l<r){
         if(str.charAt(l)!=str.charAt(r)){
            return false;
         }
         l++;
         r--;
        }
        return true;
    }
}