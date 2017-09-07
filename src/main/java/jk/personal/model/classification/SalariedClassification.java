package jk.personal.model.classification;

public class SalariedClassification implements PaymentClassification {

  private double salary;
  
  public SalariedClassification(double salary) {
    this.salary = salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  public Object getSalary() {
    return this.salary;
  }
  
}
