1class Solution {
2    public int[] findDiagonalOrder(int[][] mat) {
3        int m=mat.length;
4        int n=mat[0].length;
5        int arr[]=new int[m*n];
6        int i=0;
7        int row=0,col=0;
8        boolean up=true;
9
10        while(row<m && col<n){
11            if(up){
12                while(row>0 && col<n-1){
13                    arr[i++]=mat[row][col];
14                    row--;
15                    col++;
16                }
17                arr[i++]=mat[row][col];
18                if(col==n-1){
19                    row++;
20                }
21                else{
22                    col++;
23                }
24            }
25
26            else{
27                while(col>0 && row<m-1){
28                    arr[i++]=mat[row][col];
29                    row++;
30                    col--;
31                }
32                arr[i++]=mat[row][col];
33                if(row==m-1){
34                    col++;
35                }
36                else{
37                    row++;
38                }
39            }
40            up=!up;
41        }
42        return arr;
43    }
44}