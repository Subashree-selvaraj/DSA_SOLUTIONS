1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        
4        int[] dp=new int[amount+1];
5        Arrays.fill(dp,amount+1);
6        dp[0]=0;
7        
8        for(int i=1;i<=amount;i++){
9            for(int coin:coins){
10                if(coin<=i){
11                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
12                }
13            }
14        }
15
16        if(dp[amount]==amount+1){
17            return -1;
18        }
19        return dp[amount];
20
21
22
23
24
25    }
26}