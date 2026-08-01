1class Solution {
2
3    public List<List<Integer>> permute(int[] nums) {
4
5        List<List<Integer>> ans = new ArrayList<>();
6
7        backtrack(nums, 0, ans);
8
9        return ans;
10    }
11
12    void backtrack(int[] nums, int index, List<List<Integer>> ans) {
13
14        // Base Case
15        if (index == nums.length) {
16
17            List<Integer> temp = new ArrayList<>();
18
19            for (int num : nums)
20                temp.add(num);
21
22            ans.add(temp);
23            return;
24        }
25
26        for (int i = index; i < nums.length; i++) {
27
28            // Swap
29            int t = nums[index];
30            nums[index] = nums[i];
31            nums[i] = t;
32
33            backtrack(nums, index + 1, ans);
34
35            // Swap Back
36            t = nums[index];
37            nums[index] = nums[i];
38            nums[i] = t;
39        }
40    }
41}