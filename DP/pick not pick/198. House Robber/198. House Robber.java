1class Solution {
2    public int rob(int[] nums) {
3        int n=nums.length;
4        if(n==1){
5            return nums[0];
6        }
7        int[] dp=new int[n];
8        dp[0]=nums[0];
9        dp[1]=Math.max(nums[1],nums[0]);
10        for(int i=2;i<n;i++){
11            int pick=nums[i]+dp[i-2];
12            int notPick=dp[i-1];
13
14            dp[i]=Math.max(pick,notPick);
15        }
16        return dp[n-1];
17    }
18}