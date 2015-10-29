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
		/**
		 * 
		 */
		private static final long serialVersionUID = 1;

		{
			put(Operation.ADDITION, (wert1, wert2) -> {
				return wert1 + wert2;
			});
			put(Operation.SUBTRAKTION, (wert1, wert2) -> {
				return wert1 - wert2;
			});
			put(Operation.MULTIPLIKATION, (wert1, wert2) -> {
				return wert1 * wert2;
			});
			put(Operation.DIVISION, (wert1, wert2) -> {

				return wert1 / wert2;
			});
		}
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
		if (zahl2 == 0 && operation == Operation.DIVISION) {
			throw new Exception("Fehler! Es darf nicht durch 0 geteilt werden!");
		}
		return map.get(operation).apply(zahl1, zahl2);
	}
}
