package aufgabenblatt03;

import java.util.Observable;
import java.util.Observer;

public class Lokfuehrer extends Thread implements Observer {

  private final boolean istReinfahrer;
  private Zug zug;
  private int zielgleis;

  public Lokfuehrer(Rangierbahnhof bahnhof) {

    zielgleis = (int) Math.random() * bahnhof.anzahlGleise;
    bahnhof.addObserver(this);

    if (Math.random() < 0.5) {
      istReinfahrer = true;
      zug = new Zug();
    } else
      istReinfahrer = false;
  }

  public Zug getZug() {
    return zug;
  }
  public void setZug(Zug zug){
    this.zug = zug;
  }
  public int getZielgleis(){
    return zielgleis;
  }

  public void arbeite(Rangierbahnhof bahnhof) {

    while (!isInterrupted()) {

      if (istReinfahrer) {
        try {
          bahnhof.zugFaehrtEin(this);
          return;
        } catch (Exception e) {
          try {
            wait();
          } catch (InterruptedException e1) {
            e1.printStackTrace();
            return;
          }
        }

      } else {

        try {
          bahnhof.zugFaehrtAus(this);
          return;
        } catch (Exception e) {
          try {
            wait();
          } catch (InterruptedException e1) {
            e1.printStackTrace();
            return;
          }

        }
      }
    }
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    // TODO Auto-generated method stub

  }

}
