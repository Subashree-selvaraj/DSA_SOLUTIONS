1class Solution {
2    public int numIslands(char[][] grid) {
3        int ans=0;
4        for(int i=0;i<grid.length;i++){
5            for(int j=0;j<grid[0].length;j++){
6                if(grid[i][j]=='1'){
7                    ans+=1;
8                    dfs(grid,i,j);
9                }
10            }
11        }
12        return ans;
13    }
14    public void dfs(char[][]  grid,int i ,int j){
15        if(i<0||i>=grid.length || j<0 || j>=grid[i].length ||  grid[i][j]=='0'){
16            return;
17        }
18        grid[i][j]='0';
19        dfs(grid,i+1,j);
20        dfs(grid,i,j+1);
21        dfs(grid,i,j-1);
22        dfs(grid,i-1,j);
23
24    }
25}