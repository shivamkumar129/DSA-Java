package Strings;

// 438. Find All Anagrams in a String
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        int pCount[]=new int[26];
        for(int i=0;i<m;i++){
           pCount[p.charAt(i)-'a']++;
        }
        for(int i=0;i<=n-m;i++){
            int[]sCount=new int[26];
            for(int j=i;j<=i+m-1;j++){
                sCount[s.charAt(j)-'a']++;
            }
            if(Arrays.equals(pCount,sCount))list.add(i);
        }
        return list;
    }
}


// !Optimal solution using two HashMaps
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer>res=new ArrayList<>();
        if(s.length()<p.length())return res;
        HashMap<Character,Integer>pMap=new HashMap<>();
         HashMap<Character,Integer>sMap=new HashMap<>();
         for(char ch:p.toCharArray()){
            pMap.put(ch,pMap.getOrDefault(ch,0)+1);
         }
         int left=0,count=p.length();
         for(int right=0;right<s.length();right++){
            char ch =s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(pMap.containsKey(ch) && sMap.get(ch)<=pMap.get(ch)){
                count--;
            }
            if(right-left+1>p.length()){
                char leftChar=s.charAt(left);
                if(pMap.containsKey(leftChar) && sMap.get(leftChar)<=pMap.get(leftChar)){
                    count++;
                }
                sMap.put(leftChar,sMap.get(leftChar)-1);
                left++;
            }
            if(count==0){
                res.add(left);
            }
         }
         return res;
    }
}

// ! Using Single HashMap 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
  
        ArrayList<Integer>res=new ArrayList<>();
        if(s.length()<p.length())return res;
        HashMap<Character,Integer>Map=new HashMap<>();
         for(char ch:p.toCharArray()){
            Map.put(ch,Map.getOrDefault(ch,0)+1);
         }
         int left=0,count=p.length();
         for(int right=0;right<s.length();right++){
            char ch =s.charAt(right);
            int val = Map.getOrDefault(ch,0);
            if(val>0){
                count--;
               
            }
             Map.put(ch,val-1);
            if(right-left+1>p.length()){
                char leftChar=s.charAt(left);
                int leftVal=Map.getOrDefault(leftChar,0);
                if(leftVal>=0){
                    count++;
                }
                Map.put(leftChar,leftVal+1);
                left++;
            }
            if(count==0){
                res.add(left);
            }
         }
         return res;
    }
}
