1class Solution {
2    public int numRescueBoats(int[] people, int limit) {
3        Arrays.sort(people);
4
5        int left = 0;
6        int right = people.length - 1;
7
8        int boats=0;
9
10        while(left<=right){
11            if(people[left]+people[right]<=limit){
12                left++;
13                right--;
14            }
15            else{
16                right--;
17            }
18            boats++;
19        }
20        return boats;
21    }
22}