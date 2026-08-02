1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3                HashMap<Integer,Integer> map = new HashMap<>();
4
5        for(int x : nums1){
6            map.put(x, map.getOrDefault(x,0)+1);
7        }
8
9        ArrayList<Integer> ans = new ArrayList<>();
10
11        for(int x : nums2){
12
13            if(map.containsKey(x) && map.get(x) > 0){
14
15                ans.add(x);
16
17                map.put(x, map.get(x)-1);
18            }
19        }
20
21        int res[] = new int[ans.size()];
22
23        for(int i=0;i<ans.size();i++)
24            res[i]=ans.get(i);
25
26        return res;
27
28
29    }
30}