1class Solution {
2    public int maxSubArray(int[] nums) {
3        int currentSum=0;
4        int maxSum=Integer.MIN_VALUE;
5        for (int x:nums){
6            currentSum+=x;
7            maxSum=Math.max(maxSum,currentSum);
8            if (currentSum<0){
9                currentSum=0;
10            }
11        }
12        return maxSum;
13    }
14}