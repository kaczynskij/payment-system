package jk.personal.transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Test;
import jk.personal.db.PayrollDatabase;
import jk.personal.model.Employee;
import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.classification.SalariedClassification;
import jk.personal.model.method.HoldMethod;
import jk.personal.model.method.PaymentMethod;
import jk.personal.model.schedule.MonthlySchedule;
import jk.personal.model.schedule.PaymentSchedule;

public class AddSalariedEmployeeTransactionTest {

  PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;

  @After
  public void tearDown() {
    database.clear();
  }

  @Test
  public void testAddSalariedEmployee() {
    int empId = 1;
    Transaction t = new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 2500.00);
    t.execute();

    Employee e = database.getEmployee(empId);
    assertEquals("Bob", e.getName());

    PaymentClassification pc = e.getClassification();
    SalariedClassification sc = (SalariedClassification) pc;
    assertNotNull(sc);

    assertEquals(2500.00, sc.getSalary());
    PaymentSchedule ps = e.getSchedule();
    MonthlySchedule ms = (MonthlySchedule) ps;
    assertNotNull(ms);

    PaymentMethod pm = e.getMethod();
    HoldMethod hm = (HoldMethod) pm;
    assertNotNull(hm);

  }

  @Test
  public void testAddMultipleSalariedEmployees() {
    int empId = 1;
    int empId2 = 2;

    Transaction t = new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 2500.00);
    t.execute();

    Transaction t2 = new AddSalariedEmployeeTransaction(empId2, "Mary", "Mars", 1000.00);
    t2.execute();

    validateSalariedEmployee(empId, "Bob", 2500.00);
    validateSalariedEmployee(empId2, "Mary", 1000.00);

  }

  private void validateSalariedEmployee(int empId, String expectedName, double expectedSalary) {
    Employee e = database.getEmployee(empId);
    assertEquals(expectedName, e.getName());

    PaymentClassification pc = e.getClassification();
    SalariedClassification sc = (SalariedClassification) pc;
    assertNotNull(sc);

    assertEquals(expectedSalary, sc.getSalary());
    PaymentSchedule ps = e.getSchedule();
    MonthlySchedule ms = (MonthlySchedule) ps;
    assertNotNull(ms);

    PaymentMethod pm = e.getMethod();
    HoldMethod hm = (HoldMethod) pm;
    assertNotNull(hm);
  }

}
