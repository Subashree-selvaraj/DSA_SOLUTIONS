1class Solution {
2
3    public boolean checkInclusion(String s1, String s2) {
4
5        if (s1.length() > s2.length())
6            return false;
7
8        int freq1[] = new int[26];
9        int freq2[] = new int[26];
10
11        // Frequency of s1 ans s2 for first window size
12        for (int i = 0; i < s1.length(); i++) {
13
14            freq1[s1.charAt(i) - 'a']++;
15            freq2[s2.charAt(i) - 'a']++;
16        }
17
18        if(Arrays.equals(freq1,freq2)){
19            return true;
20        }
21
22        // Sliding Window
23        for (int i = s1.length(); i < s2.length(); i++) {
24
25            // Add new character
26            freq2[s2.charAt(i) - 'a']++;
27
28            // Remove leftmost character
29            freq2[s2.charAt(i - s1.length()) - 'a']--;
30
31            if (Arrays.equals(freq1,freq2))
32                return true;
33        }
34
35        return false;
36    }
37}