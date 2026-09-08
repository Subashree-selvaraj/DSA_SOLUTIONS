1class Solution {
2    public int countCommas(int n) {
3        int totalCommas=0;
4
5        for(int i=1000;i<=n;i*=1000){
6            totalCommas+=(n-i+1);
7        }
8        return totalCommas;
9    }
10}