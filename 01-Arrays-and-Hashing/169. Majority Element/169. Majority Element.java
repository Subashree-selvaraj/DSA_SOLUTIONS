1class Solution {
2    public int majorityElement(int[] nums) {
3        int candidate = 0;
4        int count = 0;
5        
6        for (int num : nums) {
7            if (count == 0) {
8                candidate = num;
9            }
10            
11            if (num == candidate) {
12                count++;
13            } else {
14                count--;
15            }
16        }
17        
18        return candidate;
19 
20    }
21}