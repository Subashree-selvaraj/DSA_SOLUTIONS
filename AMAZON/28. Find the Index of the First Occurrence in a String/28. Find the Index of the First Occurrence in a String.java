1class Solution {
2    public int strStr(String haystack, String needle) {
3        if(needle.length()>haystack.length()){
4            return -1;
5        }
6        int haystackLength=haystack.length();
7        int needleLength=needle.length();
8        for(int startIndex=0;startIndex<=haystackLength-needleLength;startIndex++){
9            int j=0;
10            while(j<needleLength && haystack.charAt(startIndex + j) == needle.charAt(j)){
11                j++;
12            }
13            if(j==needleLength){
14                return startIndex;
15            }
16        }
17        return -1;
18    }
19}