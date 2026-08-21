1class Solution {
2    public String reverseWords(String s) {
3        StringBuilder result = new StringBuilder();
4        StringBuilder word = new StringBuilder();
5
6        for (int i = 0; i < s.length(); i++) {
7            char ch = s.charAt(i);
8            
9            if (ch != ' ') {
10                word.insert(0, ch); // Prepend character to reverse the word
11            } else {
12                result.append(word).append( );
13                word.setLength(0); // Reset word builder
14            }
15        }
16        
17        // Append the last word which didn't hit a space
18        result.append(word);
19
20        return result.toString();
21    }
22}