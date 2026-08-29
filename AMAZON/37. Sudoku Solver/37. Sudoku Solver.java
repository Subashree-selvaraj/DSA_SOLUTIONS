1import java.util.*;
2
3class Solution {
4
5    public void solveSudoku(char[][] board) {
6        solve(board);
7    }
8
9    private boolean solve(char[][] board) {
10
11        // Find an empty cell
12        for (int row = 0; row < 9; row++) {
13
14            for (int col = 0; col < 9; col++) {
15
16                if (board[row][col] == '.') {
17
18                    // Try numbers 1 to 9
19                    for (char num = '1'; num <= '9'; num++) {
20
21                        // Check whether number can be placed
22                        if (isValid(board, row, col, num)) {
23
24                            // Place number
25                            board[row][col] = num;
26
27                            // Recursively solve remaining cells
28                            if (solve(board)) {
29                                return true;
30                            }
31
32                            // Wrong choice → undo
33                            board[row][col] = '.';
34                        }
35                    }
36
37                    // No number worked
38                    return false;
39                }
40            }
41        }
42
43        // No empty cells → Sudoku solved
44        return true;
45    }
46
47    private boolean isValid(char[][] board, int row, int col, char num) {
48
49        // Check row
50        for (int j = 0; j < 9; j++) {
51
52            if (board[row][j] == num) {
53                return false;
54            }
55        }
56
57        // Check column
58        for (int i = 0; i < 9; i++) {
59
60            if (board[i][col] == num) {
61                return false;
62            }
63        }
64
65        // Find starting position of 3x3 box
66        int startRow = (row / 3) * 3;
67        int startCol = (col / 3) * 3;
68
69        // Check 3x3 box
70        for (int i = startRow; i < startRow + 3; i++) {
71
72            for (int j = startCol; j < startCol + 3; j++) {
73
74                if (board[i][j] == num) {
75                    return false;
76                }
77            }
78        }
79
80        return true;
81    }
82}