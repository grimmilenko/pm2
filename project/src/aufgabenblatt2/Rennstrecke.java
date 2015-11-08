/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Klasse zur Realisierung einer Rennstrecke
 * 
 * @author Nico
 *
 */
public class Rennstrecke {
	protected static double gefahreneStrecke = 0.0;
	protected final double STRECKE = 10.0;
	private  static double abbruch;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Rennstrecke test = new Rennstrecke();
		List<Rennauto> autos = new ArrayList<Rennauto>();
		for (int i = 0; i < 3; i++) {
			autos.add(new Rennauto(test));
		}
		for (int i = 0; i < autos.size(); i++) {
			autos.get(i).start();
		}
		for (int i = 0; i < autos.size(); i++) {
			try {
				autos.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("-----ZIEL-----");
		System.out.format("Zeit des Rennens: %.2f Sekunden!\n",
				(elapsedTime / 1000.0));
		System.out.println("-----Platzierungen-----");
		
			Collections.sort(autos, new AutoSortieren());
				
			
			
		
		
		for (int i = 0; i < autos.size(); i++) {
			System.out.format("%d.: Wagen %d: %.2f Sekunden!\n", i + 1, autos
					.get(i).getOwnId(), autos.get(i).getGefahreneZeit());
		}
		// TODO RENNABBRUCH NOCH IMPLEMENTIEREN!
		
		/**
		 * Rennabruch
		 * Neuer Thread über das Interface Runnable
		 */
		final Thread roteFlagge = new Thread( new Runnable(){
			public void run(){
				
				abbruch = Math.random();
				if( abbruch <= 0.1 && abbruch >=0.2){
					 for(int i=0; i< autos.size(); i++){
							 autos.get(i).interrupt();
					 }
				}
				
				try{
					RoteFlagge.sleep(1000);
				}
				catch(InterruptedException e){
					System.err.println(" Rote Flagge Wurde durch Interrupt geweckt");
					 
				}	
			}
		    }); 
		roteFlagge.start();
		}
	}

