package jk.personal.transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Test;
import jk.personal.db.PayrollDatabase;
import jk.personal.model.Employee;
import jk.personal.model.classification.CommissionedClassification;
import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.method.HoldMethod;
import jk.personal.model.method.PaymentMethod;
import jk.personal.model.schedule.BiweeklySchedule;
import jk.personal.model.schedule.PaymentSchedule;

public class AddCommissionedEmployeeTransactionTest {

  PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;

  @After
  public void tearDown() {
    database.clear();
  }

  @Test
  public void testAddHourlyEmployee() {
    int empId = 1;
    Transaction t = new AddCommissionedEmployeeTransaction(empId, "Bob", "Home", 2000.00, 5.00);
    t.execute();

    validateHourlyEmployee(empId, "Bob", 2000.00, 5.00);
  }

  @Test
  public void testAddMultipleHourlyEmployees() {
    int empId = 1;
    int empId3 = 3;

    Transaction t = new AddCommissionedEmployeeTransaction(empId, "Bob", "Home", 2000.00, 5.00);
    t.execute();

    Transaction t2 = new AddCommissionedEmployeeTransaction(empId3, "Mary", "Mars", 1000.00, 20.00);
    t2.execute();

    validateHourlyEmployee(empId, "Bob", 2000.00, 5.00);
    validateHourlyEmployee(empId3, "Mary", 1000.00, 20.00);
  }


  private void validateHourlyEmployee(int empId, String expectedName, double expectedSalary,
      double expectedCommissionRate) {
    Employee e = database.getEmployee(empId);
    assertEquals(expectedName, e.getName());

    PaymentClassification pc = e.getClassification();
    CommissionedClassification cc = (CommissionedClassification) pc;
    assertNotNull(cc);

    assertEquals(expectedSalary, cc.getSalary(), 0.001);
    assertEquals(expectedCommissionRate, cc.getCommissionRate(), 0.001);

    PaymentSchedule ps = e.getSchedule();
    BiweeklySchedule bs = (BiweeklySchedule) ps;
    assertNotNull(bs);

    PaymentMethod pm = e.getMethod();
    HoldMethod hm = (HoldMethod) pm;
    assertNotNull(hm);
  }

}
