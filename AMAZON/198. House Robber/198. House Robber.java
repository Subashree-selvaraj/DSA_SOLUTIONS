1class Solution {
2    public int rob(int[] money) {
3        int n = money.length;
4
5        if (n == 1) {
6            return money[0];
7        }
8
9        int[] dp = new int[n];
10
11        dp[0] = money[0];
12
13        dp[1] = Math.max(money[0], money[1]);
14
15        for (int i = 2; i < n; i++) {
16
17            int take = money[i] + dp[i - 2];
18
19            int skip = dp[i - 1];
20
21            dp[i] = Math.max(take, skip);
22        }
23
24        return dp[n - 1];
25    }
26}