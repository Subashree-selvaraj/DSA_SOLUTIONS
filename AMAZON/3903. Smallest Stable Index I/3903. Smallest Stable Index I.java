1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n=nums.length;
4        int[] minRight=new int[n];
5        minRight[n-1]=nums[n-1];
6        for(int i=n-2;i>=0;i--){
7            minRight[i]=Math.min(nums[i],minRight[i+1]);        
8        }
9
10        int maxLeft=Integer.MIN_VALUE;
11        for(int i=0;i<n;i++){
12            maxLeft=Math.max(maxLeft,nums[i]);
13            if(maxLeft-minRight[i] <= k){
14                return i;
15            }
16        }
17        return -1;
18    }
19}