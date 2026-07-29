1class Solution {
2    public int[][] flipAndInvertImage(int[][] image) {
3        int n=image.length;
4
5        //flipping
6        for(int i=0;i<n;i++){
7            int left=0;
8            int right=n-1;
9
10            while(left<right){
11                int temp=image[i][left];
12                image[i][left]=image[i][right];
13                image[i][right]=temp;
14                left++;
15                right--;
16            }
17        }
18        //inverting
19        for(int i=0;i<n;i++){
20            for(int j=0;j<n;j++){
21                image[i][j]=1-image[i][j];
22            }
23        }
24        return image;
25
26
27    }
28}