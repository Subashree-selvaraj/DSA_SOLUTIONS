1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left < right) {
7            int mid = left + (right - left) / 2;
8            if(mid%2==1){
9                mid--;
10            }
11
12            if (nums[mid] == nums[mid + 1]) {
13                
14                left = mid + 2 ;
15            } else {
16                
17                right = mid;
18            }
19        }
20
21        return nums[left];
22    }
23}