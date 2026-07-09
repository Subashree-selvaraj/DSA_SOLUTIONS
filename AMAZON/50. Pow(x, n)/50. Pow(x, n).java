1class Solution {
2    public double myPow(double x, int n) {
3        long num = n; 
4        if (num < 0) {
5            x = 1 / x;
6            num = -num;
7        }
8        
9        double pow = 1; 
10        while (num > 0) {
11            if ((num & 1) != 0) { // If the current bit is 1 (odd number)
12                pow *= x;
13            }
14            x *= x;               // Square the base
15            num >>>= 1;           // Bitwise right shift (divide by 2)
16        }
17        
18        return pow;
19    }
20}