1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        boolean[][] rowHasNumber=new boolean[9][9];
4        boolean[][] colHasNumber=new boolean[9][9];
5        boolean[][] subBoxHasNumber=new boolean[9][9];
6
7        for(int row=0;row<9;row++){
8            for(int col=0;col<9;col++){
9                char currentCell=board[row][col];
10                if (currentCell == '.') {
11                    continue;
12                }
13                int digitIndex=currentCell-'0'-1;
14                int subBoxIndex=(row/3)*3+(col/3);
15                if(rowHasNumber[row][digitIndex] ||
16                    colHasNumber[col][digitIndex] || 
17                    subBoxHasNumber[subBoxIndex][digitIndex]){
18                        return false;
19                    
20                }
21                rowHasNumber[row][digitIndex]=true;
22                colHasNumber[col][digitIndex]=true;
23                subBoxHasNumber[subBoxIndex][digitIndex]=true;
24
25            }
26        }
27        return true;
28        
29    }
30}