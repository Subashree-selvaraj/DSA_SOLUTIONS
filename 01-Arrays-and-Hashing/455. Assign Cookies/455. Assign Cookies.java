1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        Arrays.sort(g);
4        Arrays.sort(s);
5        int i = 0, j = 0;
6        int count = 0;
7
8        while(i<g.length && j<s.length){
9            if (s[j] >= g[i]) {
10                count++;
11                i++;
12                j++;
13            } else {
14                j++;
15            }
16        }
17        return count;
18
19    }
20}