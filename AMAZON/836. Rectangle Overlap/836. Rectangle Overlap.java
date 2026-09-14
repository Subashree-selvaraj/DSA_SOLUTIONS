1class Solution {
2    public boolean isRectangleOverlap(int[] r1, int[] r2) {
3        return r1[0] < r2[2] && r2[0] < r1[2] &&
4               r1[1] < r2[3] && r2[1] < r1[3];
5    }
6}