1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int m=matrix.length;
4        int n=matrix[0].length;
5
6        int left=0;
7        int right=m*n-1;
8
9        while(left<=right){
10            int mid = left + (right - left) / 2;
11            
12            int row = mid / n;
13            int col = mid % n;
14            
15            int value = matrix[row][col];
16
17            if(value==target){
18                return true;
19            }
20            if(value<target){
21                left=mid+1;
22
23            }
24            else {
25                right=mid-1;
26            }
27        }
28        return false;
29    }
30}