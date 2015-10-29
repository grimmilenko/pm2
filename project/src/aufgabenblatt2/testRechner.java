package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import aufgabenblatt2.Rechner.Operation;

public class testRechner {

	@Test
	public void testBerechne() throws Exception {
		Rechner test = new Rechner();

		assertEquals(10, test.berechne(Operation.ADDITION, 5, 5), 10e-5);
		assertEquals(300, test.berechne(Operation.SUBTRAKTION, 321, 21), 10e-5);
		assertEquals(210, test.berechne(Operation.MULTIPLIKATION, 10, 21),
				10e-5);
	}

	public void testDivisionDurchNull() {
		Rechner test = new Rechner();
		try {
			test.berechne(Operation.DIVISION, 6, 0);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!",
					false);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
