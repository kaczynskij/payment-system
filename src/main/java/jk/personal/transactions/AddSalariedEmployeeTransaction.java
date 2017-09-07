package jk.personal.transactions;

import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.classification.SalariedClassification;
import jk.personal.model.schedule.MonthlySchedule;
import jk.personal.model.schedule.PaymentSchedule;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction {

  private double salary;

  public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
    super(empId, name, address);
    this.salary = salary;
  }

  @Override
  public PaymentClassification getClassification() {
    return new SalariedClassification(salary);
  }

  @Override
  public PaymentSchedule getSchedule() {
    return new MonthlySchedule();
  }

}
