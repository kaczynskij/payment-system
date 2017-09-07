package jk.personal.db;

import java.util.HashMap;
import java.util.Map;
import jk.personal.model.Employee;

public class PayrollDatabase {

  public static PayrollDatabase globalPayrollDatabase = new PayrollDatabase();

  private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();


  public Employee getEmployee(int empId) {
    return employees.get(empId);
  }

  public void addEmployee(int empId, Employee e) {
    employees.put(empId, e);
  }

  public void clear() {
    employees.clear();
  }

}
