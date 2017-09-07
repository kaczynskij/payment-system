package jk.personal.transactions;

import jk.personal.db.PayrollDatabase;
import jk.personal.model.Employee;
import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.method.HoldMethod;
import jk.personal.model.method.PaymentMethod;
import jk.personal.model.schedule.PaymentSchedule;

public abstract class AddEmployeeTransaction implements Transaction {

  private int empId;
  private String name;
  private String address;

  public AddEmployeeTransaction(int empId, String name, String address) {
    this.empId = empId;
    this.name = name;
    this.address = address;
  }

  public abstract PaymentClassification getClassification();

  public abstract PaymentSchedule getSchedule();

  public void execute() {
    PaymentClassification pc = getClassification();
    PaymentSchedule ps = getSchedule();
    PaymentMethod pm = new HoldMethod();

    Employee e = new Employee(this.empId, this.name, this.address);
    e.setClassification(pc);
    e.setSchedule(ps);
    e.setMethod(pm);
    PayrollDatabase.globalPayrollDatabase.addEmployee(empId, e);
  }

}
