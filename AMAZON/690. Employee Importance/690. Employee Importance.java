1/*
2// Definition for Employee.
3class Employee {
4    public int id;
5    public int importance;
6    public List<Integer> subordinates;
7};
8*/
9
10class Solution {
11    public int getImportance(List<Employee> employees, int id) {
12        for(Employee e:employees){
13            if(e.id==id){
14                int total=e.importance;
15                for(int sub:e.subordinates){
16                    total+=getImportance(employees,sub);
17                }
18                return total;
19            }
20            
21        }
22        return 0;
23    }
24}