package jk.personal.model.classification;

public class HourlyClassification implements PaymentClassification {

  private double hourlyRate;

  public HourlyClassification(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  public double getHourlyRate() {
    return this.hourlyRate;
  }

  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }



}
