1class Solution {
2
3
4    private int gcd(int a,int b){
5        while(b!=0){
6            int temp=b;
7            b=a%b;
8            a=temp;
9        }
10
11        return a;
12    }
13
14    public int findGCD(int[] nums) {
15
16        int min=nums[0];
17        int max=nums[0];
18
19        for(int x:nums){
20            if(x<min){
21                min=x;
22            }
23
24            if(x>max){
25                max=x;
26            }
27        }
28
29        return gcd(min,max);
30    }
31}