1class Solution {
2    public String kthLargestNumber(String[] nums, int k) {
3        Arrays.sort(nums,(a,b)->{
4            if(a.length()!=b.length()){
5                return a.length()-b.length();
6            }
7
8            return a.compareTo(b);
9        });
10        return  nums[nums.length-k];
11    }
12}