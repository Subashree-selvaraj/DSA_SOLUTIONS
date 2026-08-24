1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> subset = new ArrayList<>();
5
6        createSubset(nums, 0, res, subset);
7        return res;        
8    }
9
10    private void createSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
11        if (index == nums.length) {
12            res.add(new ArrayList<>(subset));
13            return;
14        }
15
16        subset.add(nums[index]);
17        createSubset(nums, index + 1, res, subset);
18
19        subset.remove(subset.size() - 1);
20        createSubset(nums, index + 1, res, subset);
21    }    
22}