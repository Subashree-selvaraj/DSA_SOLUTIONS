1class Solution {
2    public void rotate(int[][] matrix) {
3        int n=matrix.length;
4        
5        //traverse
6        for(int i=0;i<n;i++){
7            for(int j=i;j<n;j++){
8                int temp=matrix[i][j];
9                matrix[i][j]=matrix[j][i];
10                matrix[j][i]=temp;
11            }
12        }
13        //reverse each row using two pointer
14        for(int i=0;i<n;i++){
15            int left=0;
16            int right=n-1;
17            while(left<right){
18                int temp=matrix[i][left];
19                matrix[i][left]=matrix[i][right];
20                matrix[i][right]=temp;
21                left++;
22                right--;
23            }
24        }
25
26        
27    }
28}