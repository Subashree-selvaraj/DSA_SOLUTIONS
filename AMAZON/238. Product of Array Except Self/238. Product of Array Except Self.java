1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int pre[] = new int[n];
5        int suff[] = new int[n];
6        pre[0]=1;
7        suff[n-1]=1;
8
9        for(int i=1;i<n;i++){
10            pre[i]=pre[i-1]*nums[i-1];
11        }
12        for(int i = n - 2; i >= 0; i--) {
13            suff[i] = suff[i + 1] * nums[i + 1];
14        }
15
16        int ans[] = new int[n];
17        for(int i = 0; i < n; i++) {
18            ans[i] = pre[i] * suff[i];
19        }
20        return ans;
21
22
23    }
24}