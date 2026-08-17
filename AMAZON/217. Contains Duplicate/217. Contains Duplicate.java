1class Solution {
2    public boolean containsDuplicate(int[] nums) {
3        int[] freq=new int[9];
4        for(int i=0;i<nums.length;i++){
5            freq[nums[i]]++;
6        }
7
8        for(int i=0;i<freq.length;i++){
9            if(freq[i]>1){
10                return true;
11            }
12        }
13        return false;
14    }
15}