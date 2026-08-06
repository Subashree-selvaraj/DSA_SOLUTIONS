1class Solution {
2    static String[] keypad={,,abc,def,ghi,jkl,mno,pqrs,tuv,wxyz};
3
4   
5    public void possibleWords(String s,String ans,List<String> list){
6        if(s.length()==0){
7            list.add(ans);
8            return;
9
10        }
11        String key=keypad[s.charAt(0)-48];
12        for(int i=0;i<key.length();i++){
13            possibleWords(s.substring(1),ans+key.charAt(i),list);
14        }
15       
16
17    }
18    
19
20    
21    public List<String> letterCombinations(String digits) {
22        List<String> list = new ArrayList<>();
23        if (digits == null || digits.isEmpty()) {
24            return list;
25        }
26        possibleWords(digits, , list);
27        return list;   
28        
29    }
30}
31