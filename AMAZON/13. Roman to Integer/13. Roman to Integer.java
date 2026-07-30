1class Solution {
2    public int romanToInt(String s) {
3        HashMap<Character, Integer> map = new HashMap<>();
4
5        map.put('I', 1);
6        map.put('V', 5);
7        map.put('X', 10);
8        map.put('L', 50);
9        map.put('C', 100);
10        map.put('D', 500);
11        map.put('M', 1000);
12
13        int sum = 0;
14
15        for (int i = 0; i < s.length(); i++) {
16
17            int curr = map.get(s.charAt(i));
18
19            if (i < s.length() - 1) {
20
21                int next = map.get(s.charAt(i + 1));
22
23                if (curr < next)
24                    sum -= curr;
25                else
26                    sum += curr;
27
28            } else {
29
30                sum += curr;
31            }
32        }
33
34        return sum;
35
36    }
37}