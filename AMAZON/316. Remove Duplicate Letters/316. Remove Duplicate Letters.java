1class Solution {
2    public String removeDuplicateLetters(String s) {
3        int[] lastIndex = new int[26];
4        for (int i = 0; i < s.length(); i++){
5            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
6        }
7        
8        boolean[] seen = new boolean[26]; // keep track seen
9        Stack<Integer> st = new Stack();
10        
11        for (int i = 0; i < s.length(); i++) {
12            int curr = s.charAt(i) - 'a';
13            if (seen[curr]) continue; // if seen continue as we need to pick one char only
14            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
15                seen[st.pop()] = false; // pop out and mark unseen
16            }
17            st.push(curr); // add into stack
18            seen[curr] = true; // mark seen
19        }
20
21        StringBuilder sb = new StringBuilder();
22        while (!st.isEmpty())
23            sb.append((char) (st.pop() + 'a'));
24        return sb.reverse().toString();
25    }
26}