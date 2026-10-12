1class Solution {
2    public List<List<Integer>> combine(int n, int k) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> comb = new ArrayList<>();
5
6        backtrack(1, comb, res, n, k);
7        return res;
8    }
9
10    private void backtrack(int start, List<Integer> comb, List<List<Integer>> res, int n, int k) {
11        if (comb.size() == k) {
12            res.add(new ArrayList<>(comb));
13            return;
14        }
15
16        for (int num = start; num <= n; num++) {
17            comb.add(num);
18            backtrack(num + 1, comb, res, n, k);
19            comb.remove(comb.size() - 1);
20        }
21    } 
22}