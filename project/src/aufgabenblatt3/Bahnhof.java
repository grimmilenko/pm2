package aufgabenblatt03;

import java.util.Observable;

public class RangierBahnhof extends Observable {

  public final int anzahlGleise;
  private Zug[] gleiseMitZuegen;

  public Rangierbahnhof(int anzahlGleise) {
    gleiseMitZuegen = new Zug[anzahlGleise];
    this.anzahlGleise = anzahlGleise;
  }

  public synchronized void zugFaehrtEin(Lokfuehrer fuehrer) throws Exception {
    if (gleiseMitZuegen[fuehrer.getZielgleis()] == null) {
      gleiseMitZuegen[fuehrer.getZielgleis()] = fuehrer.getZug();
      deleteObserver(fuehrer);
    } else
      throw new Exception();
    setChanged();
    notifyObservers();
  }

  public synchronized void zugFaehrtAus(Lokfuehrer fuehrer) throws Exception {
    if (gleiseMitZuegen[fuehrer.getZielgleis()] != null) {
      fuehrer.setZug(gleiseMitZuegen[fuehrer.getZielgleis()]);
      gleiseMitZuegen[fuehrer.getZielgleis()] = null;
      deleteObserver(fuehrer);
    } else
      throw new Exception();
    setChanged();
    notifyObservers();
  }

}
