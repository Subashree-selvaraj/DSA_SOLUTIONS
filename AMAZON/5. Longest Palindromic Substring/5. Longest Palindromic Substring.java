1class Solution {
2    public String longestPalindrome(String s) {
3        String ans = ;
4        for(int i=0;i<s.length();i++){
5            String p1=expand(s,i,i);
6            String p2=expand(s,i,i+1);
7
8            if(p1.length()>ans.length()){
9                ans=p1;
10            }
11            if(p2.length()>ans.length()){
12                ans=p2;
13            }
14
15        }
16        return ans;
17        
18    }
19
20    String expand(String str,int left,int right){
21        
22        while( left>=0 && right<str.length()
23        && str.charAt(left)==str.charAt(right)){
24            left--;
25            right++;
26        }
27        return str.substring(left+1,right);
28    }
29}
30