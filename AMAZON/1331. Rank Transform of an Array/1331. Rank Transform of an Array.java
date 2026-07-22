1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int[] sorted = arr.clone();
4        Arrays.sort(sorted);
5
6        int m = 0;
7        for (int x : sorted) {
8            if (m == 0 || sorted[m - 1] != x) {
9                sorted[m++] = x;
10            }
11        }
12
13        int[] unique = Arrays.copyOf(sorted, m);
14        for (int i = 0; i < arr.length; i++) {
15            arr[i] = Arrays.binarySearch(unique, arr[i]) + 1;
16        }
17
18        return arr;
19    }
20}