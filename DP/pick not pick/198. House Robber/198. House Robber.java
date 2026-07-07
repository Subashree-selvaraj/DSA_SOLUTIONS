1class Solution {
2    public int rob(int[] nums) {
3
4        int n = nums.length;
5
6        if (n == 1)
7            return nums[0];
8
9        int prev2 = nums[0];
10        int prev1 = Math.max(nums[0], nums[1]);
11
12        for (int i = 2; i < n; i++) {
13
14            int pick = nums[i] + prev2;
15            int notPick = prev1;
16
17            int curr = Math.max(pick, notPick);
18
19            prev2 = prev1;
20            prev1 = curr;
21        }
22
23        return prev1;
24    }
25}