1class Solution {
2    public int maxArea(int[] height) {
3        int left=0;
4        int right=height.length-1;
5        int max=-1;
6        while(left<right){
7            int w=right-left;
8            int h=Math.min(height[left],height[right]);
9            max=Math.max(max,w*h);
10            if(height[left]<height[right]){
11                left++;
12            }
13            else right--;
14
15        }
16        return max;
17    }
18} 