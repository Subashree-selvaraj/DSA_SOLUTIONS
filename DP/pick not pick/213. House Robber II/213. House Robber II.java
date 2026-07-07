1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4
5        if (n == 1)
6            return nums[0];
7
8        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
9    }
10    private int robRange(int[] nums,int start,int end){
11        int prev2 = 0;
12        int prev1 = 0;
13
14        for (int i = start; i <=end; i++) {
15
16            int pick = nums[i] + prev2;
17            int notPick = prev1;
18
19            int curr = Math.max(pick, notPick);
20
21            prev2 = prev1;
22            prev1 = curr;
23        }
24
25        return prev1;
26    }
27}