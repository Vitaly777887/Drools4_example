

import java.sql.Timestamp;
import java.util.Calendar;

import demo.engine.TestsRulesEngine;
import demo.model.*;
import junit.framework.TestCase;

public class TestsRulesEngineTest extends TestCase {


	private MachineResultSet machineResultSet;

	private TestsRulesEngine testsRulesEngine;

	private TestDAO testDAO;

	protected void setUp() throws Exception {
		super.setUp();
		// Set drools.schema.validating property to false
		// Ideally, this would be set only once as a JVM property for your program
		// Setting this property to false, gets rid of the following message:
		// cvc-elt.1: Cannot find the declaration of element 'rule-set'
        System.setProperty("drools.schema.validating", "false");
		machineResultSet = new MachineResultSetImpl();
		testDAO = new TestDAOImpl();
		testsRulesEngine = new TestsRulesEngine(testDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		machineResultSet = null;
		testDAO = null;
		testsRulesEngine = null;
	}

	public void testTestsRulesEngine() throws Exception {
		for (Machine machine :machineResultSet.getMachines()) {

		testsRulesEngine.assignTests(machine);
			Timestamp creationTs = machine.getCreationTs();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(creationTs);
			Timestamp testsDueTime = machine.getTestsDueTime();

			if (machine.getSerialNumber().equals("1234A")) {
				assertEquals(3, machine.getTests().size());
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST1)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST2)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST5)));

				calendar.add(Calendar.DATE, 3);
				assertEquals(calendar.getTime(), testsDueTime);
			} else if (machine.getSerialNumber().equals("1234B")) {
				assertEquals(4, machine.getTests().size());
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST5)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST4)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST3)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST2)));

				calendar.add(Calendar.DATE, 7);
				assertEquals(calendar.getTime(), testsDueTime);
			} else if (machine.getSerialNumber().equals("1234C")) {
				assertEquals(3, machine.getTests().size());
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST3)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST4)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST1)));

				calendar.add(Calendar.DATE, 3);
				assertEquals(calendar.getTime(), testsDueTime);
			} else if (machine.getSerialNumber().equals("1234D")) {
				assertEquals(2, machine.getTests().size());
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST3)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST4)));

				calendar.add(Calendar.DATE, 10);
				assertEquals(calendar.getTime(), testsDueTime);
			} else if (machine.getSerialNumber().equals("1234E")) {
				assertEquals(2, machine.getTests().size());
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST5)));
				assertTrue(machine.getTests().contains(
						testDAO.findByKey(Test.TEST4)));

				calendar.add(Calendar.DATE, 12);
				assertEquals(calendar.getTime(), testsDueTime);
			}
		}
	}

}
