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
  public void after() {
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

}
