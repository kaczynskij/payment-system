package jk.personal.transactions;

import jk.personal.model.classification.HourlyClassification;
import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.schedule.PaymentSchedule;
import jk.personal.model.schedule.WeeklySchedule;

public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {

  double hourlyRate;

  public AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
    super(empId, name, address);
    this.hourlyRate = hourlyRate;
  }

  @Override
  public PaymentClassification getClassification() {
    return new HourlyClassification(hourlyRate);
  }

  @Override
  public PaymentSchedule getSchedule() {
    return new WeeklySchedule();
  }

}
