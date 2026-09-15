1class Solution {
2    public int majorityElement(int[] nums) {
3        HashMap<Integer, Integer> hash = new HashMap<>();
4        int res = 0;
5        int majority = 0;
6
7        for (int n : nums) {
8            hash.put(n, 1 + hash.getOrDefault(n, 0));
9            if (hash.get(n) > majority) {
10                res = n;
11                majority = hash.get(n);
12            }
13        }
14
15        return res;        
16    }
17}