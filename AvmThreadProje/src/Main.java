
public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
    	AvmKat zemin = new AvmKat(0, 0);
    	AvmKat kat1 = new AvmKat(0, 0);
    	AvmKat kat2 = new AvmKat(0, 0);
    	AvmKat kat3 = new AvmKat(0, 0);
    	AvmKat kat4 = new AvmKat(0, 0);
    	
    	Giris giris = new Giris();
    	giris.setPriority(8);
    	Cikis cikis = new Cikis();
    	cikis.setPriority(6);
    	
    	Asansor asansor1 = new Asansor(1, 0, 0, true, true, 10 ,0);
    	asansor1.setPriority(7); 
    	
    	Asansor asansor2 = new Asansor(2, 0, 0, true, false, 10 ,0);
    	asansor2.setPriority(4);
    	Asansor asansor3 = new Asansor(3, 0, 0, true, false, 10 ,0);
    	asansor3.setPriority(3);
    	Asansor asansor4 = new Asansor(4, 0, 0, true, false, 10 ,0);
    	asansor4.setPriority(2);
    	Asansor asansor5 = new Asansor(5, 0, 0, true, false, 10 ,0);
    	asansor5.setPriority(1);
      	   	
    	giris.run(zemin);  	
    	cikis.run(kat1, kat2, kat3, kat4); 	 	
    	asansor1.run(zemin, kat1, kat2, kat3, kat4);
    	asansor2.run(zemin, kat1, kat2, kat3, kat4);
    	asansor3.run(zemin, kat1, kat2, kat3, kat4);
    	asansor4.run(zemin, kat1, kat2, kat3, kat4);
    	asansor5.run(zemin, kat1, kat2, kat3, kat4);
    	
    }
}
