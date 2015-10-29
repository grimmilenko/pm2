/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * Klasse zur Repraesentation eines einfachen Rechners
 * 
 * @author Nico Grimm
 *
 */
public class Rechner {

	/**
	 * Enum zur Verwaltung der zu beherschenden Rechenarten des Rechners
	 * 
	 * @author Nico Grimm
	 *
	 */
	public enum Operation {
		ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION
	}

	private Map<Operation, BinaryOperator<Double>> map = new HashMap<Operation, BinaryOperator<Double>>() {
		// put(Operation.ADDITION, DoubleDoubleZuDouble add = (wert1, wert2) ->
		// {
		// return wert1 + wert2;};);
	};

	/**
	 * Methode zum berechnen zweier Zahlen mit einer bestimmten Rechenoperation
	 * 
	 * @param operation
	 *            Rechenoperation, die ausgefuehrt werden soll
	 * @param zahl1
	 *            Erste Zahl
	 * @param zahl2
	 *            Zweite Zahl
	 * @return Gibt das Ergebnis der Berechnung wieder
	 * @throws Exception
	 *             Bei Division darf nicht durch 0 geteilt werden und bei
	 *             unbekannter Rechenoperation
	 */
	public double berechne(Operation operation, double zahl1, double zahl2)
			throws Exception {
		switch (operation) {
		case ADDITION:
			DoubleDoubleZuDouble add = (wert1, wert2) -> {
				return wert1 + wert2;
			};
			return add.werteAus(zahl1, zahl2);
		case SUBTRAKTION:
			DoubleDoubleZuDouble sub = (wert1, wert2) -> {
				return wert1 - wert2;
			};
			return sub.werteAus(zahl1, zahl2);
		case MULTIPLIKATION:
			DoubleDoubleZuDouble mul = (wert1, wert2) -> {
				return wert1 * wert2;
			};
			return mul.werteAus(zahl1, zahl2);
		case DIVISION:
			DoubleDoubleZuDouble div = (wert1, wert2) -> {
				return wert1 / wert2;
			};
			if (zahl2 == 0) {
				throw new Exception("Es darf nicht durch 0 geteilt werden!");
			}
			return div.werteAus(zahl1, zahl2);
		default:
			throw new Exception(
					"Die gewuenschte Rechenoperation ist nicht Verfuegbar!");
		}

	}

}
