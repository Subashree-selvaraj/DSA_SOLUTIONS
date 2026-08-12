1class Solution {
2    public int countSubstrings(String s) {
3        int count=0;
4        for(int i=0;i<s.length();i++){
5            count+=expand(s,i,i);
6            count+=expand(s,i,i+1);
7        }
8        return count;
9        
10    }
11    int expand(String str,int left,int right){
12        int count=0;
13        
14        while( left>=0 && right<str.length()
15        && str.charAt(left)==str.charAt(right)){
16            count++;
17            left--;
18            right++;
19        }
20        return count;
21    }
22
23
24}