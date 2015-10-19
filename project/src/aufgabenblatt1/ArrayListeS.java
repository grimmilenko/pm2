package aufgabenblatt1;

public class ArrayListeS {
  
	 public static ArrayListe<Integer> liste = new ArrayListe<Integer>(0);
	public ArrayListeS(){
		//ArrayListe<Integer> liste = new ArrayListe<Integer>();
         liste.hinzufuegen(2);
          //liste.hinzufuegen(4);
          
	
	}
	
	public static boolean erstesElementZahl(){
//		ArrayListe[] elemente;
//         elemente = new ArrayListe[0];
		//ArrayListe<Integer> liste = new ArrayListe<Integer>();
        //liste.hinzufuegen(2);
		
		
		System.out.println(liste.get(0));
  		if ( liste.get(0) instanceof Integer) {
			//throw new Exception("list does not contain integer")
  			  return true;
			  
		}
		return false;
	}
	
	public static void main(String[] args) {
		ArrayListeS liste = new ArrayListeS();
	     System.out.println(erstesElementZahl());
	    ArrayListe<String> listen =new ArrayListe<String>(3);
	    listen.hinzufuegen("Hallo");
	    listen.hinzufuegen("Hier");
	}
}
