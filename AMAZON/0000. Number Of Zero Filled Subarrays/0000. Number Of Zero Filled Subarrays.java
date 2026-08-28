1class Solution {
2    public long zeroFilledSubarray(int[] nums) {
3        long count = 0;
4        long total = 0;
5
6        for (int num : nums) {
7            if (num == 0) {
8                count++;
9                total += count;
10            } else {
11                count = 0;
12            }
13        }
14
15        return total;
16    }
17}