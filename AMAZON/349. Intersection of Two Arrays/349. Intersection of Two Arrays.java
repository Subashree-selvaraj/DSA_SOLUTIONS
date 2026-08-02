1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        HashSet<Integer> set=new HashSet<Integer>();
4         ArrayList<Integer> ans = new ArrayList<>();
5        for(int x:nums1){
6            set.add(x);
7        }
8         for (int num : nums2) {
9
10            if (set.contains(num)) {
11
12                ans.add(num);
13
14                set.remove(num); // avoid duplicates
15            }
16        }
17        int result[] = new int[ans.size()];
18
19        for (int i = 0; i < ans.size(); i++) {
20            result[i] = ans.get(i);
21        }
22
23        return result;
24
25        
26    }
27}