package jk.personal.model;

import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.method.PaymentMethod;
import jk.personal.model.schedule.PaymentSchedule;

public class Employee {

  private PaymentClassification pc;
  private PaymentSchedule ps;
  private PaymentMethod pm;
  private int empId;
  private String name;
  private String address;

  public Employee(int empId, String name, String address) {
    this.empId = empId;
    this.name = name;
    this.address = address;
  }

  public int getEmpId() {
    return this.empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setClassification(PaymentClassification pc) {
    this.pc = pc;
  }

  public PaymentClassification getClassification() {
    return this.pc;
  }

  public void setSchedule(PaymentSchedule ps) {
    this.ps = ps;
  }

  public PaymentSchedule getSchedule() {
    return this.ps;
  }

  public void setMethod(PaymentMethod pm) {
    this.pm = pm;
  }

  public PaymentMethod getMethod() {
    return this.pm;
  }



}
