package jk.personal.model.classification;

public class CommissionedClassification implements PaymentClassification {

  private double salary;
  private double commissionRate;

  public CommissionedClassification(double salary, double commissionRate) {
    this.salary = salary;
    this.commissionRate = commissionRate;
  }

  public double getSalary() {
    return this.salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getCommissionRate() {
    return this.commissionRate;
  }

  public void setCommissionRate(double commissionRate) {
    this.commissionRate = commissionRate;
  }



}
