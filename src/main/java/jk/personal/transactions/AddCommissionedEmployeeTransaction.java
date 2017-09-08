package jk.personal.transactions;

import jk.personal.model.classification.CommissionedClassification;
import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.schedule.BiweeklySchedule;
import jk.personal.model.schedule.PaymentSchedule;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction {

  private double salary;
  private double commissionRate;

  public AddCommissionedEmployeeTransaction(int empId, String name, String address, double salary,
      double commissionRate) {
    super(empId, name, address);
    this.salary = salary;
    this.commissionRate = commissionRate;
  }

  @Override
  public PaymentClassification getClassification() {
    return new CommissionedClassification(salary, commissionRate);
  }

  @Override
  public PaymentSchedule getSchedule() {
    return new BiweeklySchedule();
  }

}
