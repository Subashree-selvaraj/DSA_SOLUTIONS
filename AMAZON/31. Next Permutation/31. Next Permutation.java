1class Solution {
2    public void nextPermutation(int[] nums) {
3        int i=nums.length-2;
4
5        while(i>=0 && nums[i]>=nums[i+1]){
6            i--;
7        }
8
9        if(i>=0){
10            int j=nums.length-1;
11            while(nums[j]<=nums[i]){
12                j--;
13            }
14            swap(nums,i,j);
15        }
16
17        reverse(nums,i+1,nums.length-1);
18
19    }
20
21    void swap(int[] nums,int i,int j){
22        int temp=nums[i];
23        nums[i]=nums[j];
24        nums[j]=temp;
25    }
26
27    void reverse(int[] arr,int left,int right){
28        while(left<right){
29            swap(arr,left,right);
30            left++;
31            right--;
32        }
33    }
34}