1class Solution {
2    public int pivotIndex(int[] nums) {
3        int n = nums.length;
4
5        int[] prefix = new int[n];
6        prefix[0] = nums[0];
7
8        for (int i = 1; i < n; i++) {
9            prefix[i] = prefix[i - 1] + nums[i];
10        }
11
12        int total = prefix[n - 1];
13
14        for (int i = 0; i < n; i++) {
15
16            int leftSum = (i == 0) ? 0 : prefix[i - 1];
17            int rightSum = total - prefix[i];
18
19            if (leftSum == rightSum)
20                return i;
21        }
22
23        return -1;
24    }
25}