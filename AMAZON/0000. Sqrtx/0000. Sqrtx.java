1class Solution {
2    public int mySqrt(int x) {
3        if (x < 2) return x;
4
5        int left = 1, right = x / 2;
6        
7        while (left <= right) {
8            int mid = left + (right - left) / 2;
9            long square = (long) mid * mid;
10
11            if (square == x) {
12                return mid;
13            } else if (square < x) {
14                left = mid + 1;
15            } else {
16                right = mid - 1;
17            }
18        }
19
20        return right;      
21
22
23    }
24}