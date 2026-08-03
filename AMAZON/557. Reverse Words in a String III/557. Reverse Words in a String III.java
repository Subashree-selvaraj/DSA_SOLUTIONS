1class Solution {
2    public String reverseWords(String s) {
3        // Split the input string into words and reverse each word
4        String[] words = s.split( );
5        StringBuilder result = new StringBuilder();
6        for (String word : words) {
7            StringBuilder reversedWord = new StringBuilder(word).reverse();
8            result.append(reversedWord).append( );
9        }
10        result.deleteCharAt(result.length() - 1);  // Remove the extra space at the end
11        
12        // Convert StringBuilder to String
13        return result.toString();        
14    }
15}