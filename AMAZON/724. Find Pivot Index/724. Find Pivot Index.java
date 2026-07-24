1class Solution {
2    public int pivotIndex(int[] nums) {
3        int total = 0;
4
5        // Find total sum
6        for (int i = 0; i < nums.length; i++) {
7            total = total + nums[i];
8        }
9
10        int leftSum = 0;
11
12        for (int i = 0; i < nums.length; i++) {
13
14            int rightSum = total - leftSum - nums[i];
15
16            if (leftSum == rightSum) {
17                return i;
18            }
19
20            leftSum = leftSum + nums[i];
21        }
22
23        return -1;
24    }
25}