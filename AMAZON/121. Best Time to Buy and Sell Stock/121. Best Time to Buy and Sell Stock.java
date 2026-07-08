1class Solution {
2    public int maxProfit(int[] prices) {
3        int left=0,right=1,maxProfit=0;
4        while(right<prices.length){
5            if(prices[right]>prices[left]){
6                int profit=prices[right]-prices[left];
7                maxProfit=Math.max(profit,maxProfit);
8            }
9            else{
10                left=right;
11            }
12            right++;
13            
14           
15        }
16        return maxProfit;
17    }
18}