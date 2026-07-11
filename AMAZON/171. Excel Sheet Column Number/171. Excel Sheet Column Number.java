1class Solution {
2    public int titleToNumber(String columnTitle) {
3        long ans = 0;
4
5        // Same idea as decimal parsing, but base is 26.
6        for (int i = 0; i < columnTitle.length(); i++) {
7            char ch = columnTitle.charAt(i);
8            ans = ans * 26 + (ch - 'A' + 1);
9        }
10
11        return (int) ans;
12    }
13}