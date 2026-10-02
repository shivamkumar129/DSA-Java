// class Solution {
//     public String longestPalindrome(String s) {
//         String resl="";
//         for(int i=0;i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//              if(isPalindrome(s,i,j)==true){
//                    if(j-i+1>resl.length()){
//                     resl=s.substring(i,j+1);
//                    }
//              }
//             }

//         }
//         return resl;
//     }
//     private boolean isPalindrome(String str,int l,int r){
//         while(l<r){
//             if(str.charAt(l)!=str.charAt(r)){
//                 return false;
//             }
//             l++;
//             r--;
//         }
//         return true;
//     }
// }

class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        // Start and end indexes of the longest palindrome found
        int start = 0;
        int end = 0;

        // Treat every position as a possible center
        for (int i = 0; i < n; i++) {

            // Odd-length palindrome: center is one character
            int len1 = expand(s, i, i);

            // Even-length palindrome: center is between two characters
            int len2 = expand(s, i, i + 1);

            // Take the longer palindrome
            int len = Math.max(len1, len2);

            // If we found a longer palindrome, update its boundaries
            if (len > end - start + 1) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // substring's ending index is exclusive
        return s.substring(start, end + 1);
    }

    private int expand(String s, int l, int r) {

        // Expand while both indexes are valid
        // and characters on both sides are equal
        while (l >= 0 &&
               r < s.length() &&
               s.charAt(l) == s.charAt(r)) {

            l--;
            r++;
        }

        // l and r have moved one step outside the palindrome
        return r - l - 1;
    }
}