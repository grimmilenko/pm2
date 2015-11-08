package aufgabenblatt2;

import java.util.Comparator;

public class AutoSortieren implements Comparator <Rennauto> {

	@Override
	public int compare(Rennauto a0, Rennauto a1) {
		// TODO Auto-generated method stub
		 double ergebnis =0.0 ;
		 int returnWert =0 ;
		 ergebnis = a0.getGefahreneZeit() - a1.getGefahreneZeit();
		if( ergebnis < 0.0){
			returnWert = -1;
		}
		else{ 
			if(ergebnis > 0.0){
				returnWert = 1;
			}
		}
		return returnWert;
	}

}
