import java.util.*;

public class Giris extends Thread{
			
	public void run(AvmKat zemin) {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
		    @Override
		    public void run()
		    {
		    	Random rn = new Random();
	    		int yolcuSayi = rn.nextInt(10) + 1;
	    		int kat = rn.nextInt(4) + 1;
	    		Yolcu y = new Yolcu(yolcuSayi, kat);
	    		zemin.katKuyruk.add(y);
	    		zemin.setKuyrukMusteri(zemin.getKuyrukMusteri() + yolcuSayi);
	    		System.out.println("Zemin kat: Kuyruk: " + zemin.getKuyrukMusteri());
	    		for(int i = 0; i < zemin.katKuyruk.size(); i++) {
	    			System.out.print("[" + zemin.katKuyruk.get(i).getYolcu() + "," + zemin.katKuyruk.get(i).getKat() + "] ");
	    		}
	    		System.out.println("\n");
		    }
		}, 0, 500);
    		   	    			
	}	
	
}
