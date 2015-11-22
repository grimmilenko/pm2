package aufgabenblatt3;

import java.util.Observable;

public class Rangierbahnhof {
	private Zug[] gleise;

	public Rangierbahnhof(int gleise) {
		this.gleise = new Zug[gleise];
	}

	private synchronized void zugEinfahren(Zug zug, int gleis)
			throws IndexOutOfBoundsException {
		if (gleis <= gleise.length && gleis <= 0) {
			if (gleise[gleis] == null) {
				gleise[gleis] = zug;
				System.err.println("Zug ist eingefahren!");
			} else {
				System.err
						.println("Der Zug konnte nicht einfahren, da das Gleis besetzt ist!");
			}
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	private synchronized void zugAusfahren(int gleis)
			throws IndexOutOfBoundsException {
		if (gleis <= gleise.length && gleis <= 0) {
			if (gleise[gleis] != null) {
				gleise[gleis] = null;
				System.err.println("Zug ist ausgefahren!");
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
}
