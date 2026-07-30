1class Solution {
2
3    public int titleToNumber(String columnTitle) {
4
5        int ans = 0;
6
7        for (int i = 0; i < columnTitle.length(); i++) {
8
9            char ch = columnTitle.charAt(i);
10
11            int value = ch - 'A' + 1;
12
13            ans = ans * 26 + value;
14        }
15
16        return ans;
17    }
18}