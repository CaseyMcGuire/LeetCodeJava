package main.com.leetcode.problems.problem0690;

import java.util.*;

public class Solution {
  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> idToEmployee = new HashMap<>();
    for (Employee employee : employees) {
      idToEmployee.put(employee.id, employee);
    }
    List<Integer> pendingEmployeesId = new ArrayList<>();
    int importanceValue = 0;
    pendingEmployeesId.add(id);
    while (!pendingEmployeesId.isEmpty()) {
      List<Integer> nextLevel = new ArrayList<>();
      for (Integer employeeId : pendingEmployeesId) {
        Employee curEmployee = idToEmployee.get(employeeId);
        importanceValue += curEmployee.importance;
        nextLevel.addAll(curEmployee.subordinates);
      }
      pendingEmployeesId = nextLevel;
    }
    return importanceValue;
  }
}

class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
 }
