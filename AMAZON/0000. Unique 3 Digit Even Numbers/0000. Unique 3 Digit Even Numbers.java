1class Solution {
2    public int totalNumbers(int[] digits) {
3        // Frequency array to store counts of digits 0 through 9
4        int[] count = new int[10];
5        for (int d : digits) {
6            count[d]++;
7        }
8        
9        int validCount = 0;
10        
11        // Loop through all possible 3-digit even numbers (100 to 998, stepping by 2)
12        for (int num = 100; num <= 998; num += 2) {
13            int h = num / 100;
14            int t = (num / 10) % 10;
15            int u = num % 10;
16            
17            // Count frequencies required for the current candidate
18            int[] req = new int[10];
19            req[h]++;
20            req[t]++;
21            req[u]++;
22            
23            // Check if our input digits have enough of each required digit
24            boolean possible = true;
25            for (int i = 0; i <= 9; i++) {
26                if (req[i] > count[i]) {
27                    possible = false;
28                    break;
29                }
30            }
31            
32            if (possible) {
33                validCount++;
34            }
35        }
36        
37        return validCount;
38    }
39}