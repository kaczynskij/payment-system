package jk.personal.transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Test;
import jk.personal.db.PayrollDatabase;
import jk.personal.model.Employee;
import jk.personal.model.classification.HourlyClassification;
import jk.personal.model.classification.PaymentClassification;
import jk.personal.model.method.HoldMethod;
import jk.personal.model.method.PaymentMethod;
import jk.personal.model.schedule.PaymentSchedule;
import jk.personal.model.schedule.WeeklySchedule;

public class AddHourlyEmployeeTransactionTest {

  PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;

  @After
  public void tearDown() {
    database.clear();
  }

  @Test
  public void testAddHourlyEmployee() {
    int empId = 1;
    Transaction t = new AddHourlyEmployeeTransaction(empId, "Bob", "Home", 20.00);
    t.execute();

    validateHourlyEmployee(empId, "Bob", 20.00);
  }
  
  @Test
  public void testAddMultipleHourlyEmployees() {
    int empId = 1;
    int empId3 = 3;
    
    Transaction t = new AddHourlyEmployeeTransaction(empId, "Bob", "Home", 20.00);
    t.execute();
    
    Transaction t2 = new AddHourlyEmployeeTransaction(empId3, "Mary", "Mars", 10.00);
    t2.execute();
        
    validateHourlyEmployee(empId, "Bob", 20.00);
    validateHourlyEmployee(empId3, "Mary", 10.00);
  }
  

  private void validateHourlyEmployee(int empId, String expectedName, double expectedHourlyRate) {
    Employee e = database.getEmployee(empId);
    assertEquals(expectedName, e.getName());

    PaymentClassification pc = e.getClassification();
    HourlyClassification hc = (HourlyClassification) pc;
    assertNotNull(hc);

    assertEquals(expectedHourlyRate, hc.getHourlyRate(), 0.001);
    PaymentSchedule ps = e.getSchedule();
    WeeklySchedule ws = (WeeklySchedule) ps;
    assertNotNull(ws);

    PaymentMethod pm = e.getMethod();
    HoldMethod hm = (HoldMethod) pm;
    assertNotNull(hm);
  }

}
