1class Solution {
2    public void sortColors(int[] nums) {
3        int low=0,mid=0,high=nums.length-1;
4        while(mid<=high){
5            if(nums[mid]==0){
6                swap(nums,low,mid);
7                mid++;
8                low++;
9            }
10            else if(nums[mid]==1){
11                mid++;
12            }
13            else{
14                swap(nums,mid,high);
15                high--;
16            }
17        }
18
19       
20    }
21
22     private void swap(int[] nums,int i,int j){
23            int temp=nums[i];
24            nums[i]=nums[j];
25            nums[j]=temp;
26    }
27
28}