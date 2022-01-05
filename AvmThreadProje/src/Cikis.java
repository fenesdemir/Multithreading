import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Cikis extends Thread{
	
public void run(AvmKat kat1, AvmKat kat2, AvmKat kat3, AvmKat kat4) {
	
	Timer timerCikis = new Timer();
	timerCikis.schedule(new TimerTask()
	{
	    @Override
	    public void run()
	    {
	    	
	    	Random rn = new Random();
    		int hangiKat = rn.nextInt(4) + 1;
    		
    		if(hangiKat == 1) {
    			if(kat1.getKatMusteri() >= 5) {
    				int yolcuSayi = rn.nextInt(5) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat1.katKuyruk.add(y);
    				kat1.setKuyrukMusteri(kat1.getKuyrukMusteri() + yolcuSayi);
    				kat1.setKatMusteri(kat1.getKatMusteri() - yolcuSayi);
    				System.out.println("1.Katta " + y.getYolcu() + " kisi kuyruga girdi.");
    				
    				System.out.println("1.Kat: Kattakiler: " + kat1.getKatMusteri() + " Kuyruk: " + kat1.getKuyrukMusteri());
    				for(int i = 0; i < kat1.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat1.katKuyruk.get(i).getYolcu() + "," + kat1.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}else if(kat1.getKatMusteri() < 5 && kat1.getKatMusteri() > 0) {
    				int yolcuSayi = rn.nextInt(kat1.getKatMusteri()) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat1.katKuyruk.add(y);
    				kat1.setKuyrukMusteri(kat1.getKuyrukMusteri() + yolcuSayi);
    				kat1.setKatMusteri(kat1.getKatMusteri() - yolcuSayi);
    				System.out.println("1.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("1.Kat: Kattakiler: " + kat1.getKatMusteri() + " Kuyruk: " + kat1.getKuyrukMusteri());
    				for(int i = 0; i < kat1.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat1.katKuyruk.get(i).getYolcu() + "," + kat1.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}
    		}else if(hangiKat == 2) {
    			if(kat2.getKatMusteri() >= 5) {
    				int yolcuSayi = rn.nextInt(5) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat2.katKuyruk.add(y);
    				kat2.setKuyrukMusteri(kat2.getKuyrukMusteri() + yolcuSayi);
    				kat2.setKatMusteri(kat2.getKatMusteri() - yolcuSayi);
    				System.out.println("2.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("2.Kat: Kattakiler: " + kat2.getKatMusteri() + " Kuyruk: " + kat2.getKuyrukMusteri());
    				for(int i = 0; i < kat2.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat2.katKuyruk.get(i).getYolcu() + "," + kat2.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}else if(kat2.getKatMusteri() < 5 && kat2.getKatMusteri() > 0) {
    				int yolcuSayi = rn.nextInt(kat2.getKatMusteri()) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat2.katKuyruk.add(y);
    				kat2.setKuyrukMusteri(kat2.getKuyrukMusteri() + yolcuSayi);
    				kat2.setKatMusteri(kat2.getKatMusteri() - yolcuSayi);
    				System.out.println("2.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("2.Kat: Kattakiler: " + kat2.getKatMusteri() + " Kuyruk: " + kat2.getKuyrukMusteri());
    				for(int i = 0; i < kat2.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat2.katKuyruk.get(i).getYolcu() + "," + kat2.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}   			
    		}else if(hangiKat == 3) {
    			if(kat3.getKatMusteri() >= 5) {
    				int yolcuSayi = rn.nextInt(5) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat3.katKuyruk.add(y);
    				kat3.setKuyrukMusteri(kat3.getKuyrukMusteri() + yolcuSayi);
    				kat3.setKatMusteri(kat3.getKatMusteri() - yolcuSayi);
    				System.out.println("3.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("3.Kat: Kattakiler: " + kat3.getKatMusteri() + " Kuyruk: " + kat3.getKuyrukMusteri());
    				for(int i = 0; i < kat3.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat3.katKuyruk.get(i).getYolcu() + "," + kat3.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}else if(kat3.getKatMusteri() < 5 && kat3.getKatMusteri() > 0) {
    				int yolcuSayi = rn.nextInt(kat3.getKatMusteri()) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat3.katKuyruk.add(y);
    				kat3.setKuyrukMusteri(kat3.getKuyrukMusteri() + yolcuSayi);
    				kat3.setKatMusteri(kat3.getKatMusteri() - yolcuSayi);
    				System.out.println("3.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("3.Kat: Kattakiler: " + kat3.getKatMusteri() + " Kuyruk: " + kat3.getKuyrukMusteri());
    				for(int i = 0; i < kat3.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat3.katKuyruk.get(i).getYolcu() + "," + kat3.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    	    		
    			}
    		}else if(hangiKat == 4) {
    			if(kat4.getKatMusteri() >= 5) {
    				int yolcuSayi = rn.nextInt(5) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat4.katKuyruk.add(y);
    				kat4.setKuyrukMusteri(kat4.getKuyrukMusteri() + yolcuSayi);
    				kat4.setKatMusteri(kat4.getKatMusteri() - yolcuSayi);
    				System.out.println("4.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("4.Kat: Kattakiler: " + kat4.getKatMusteri() + " Kuyruk: " + kat4.getKuyrukMusteri());
    				for(int i = 0; i < kat4.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat4.katKuyruk.get(i).getYolcu() + "," + kat4.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}else if(kat4.getKatMusteri() < 5 && kat4.getKatMusteri() > 0) {
    				int yolcuSayi = rn.nextInt(kat4.getKatMusteri()) + 1;
    				Yolcu y = new Yolcu(yolcuSayi, 0);
    				kat4.katKuyruk.add(y);
    				kat4.setKuyrukMusteri(kat4.getKuyrukMusteri() + yolcuSayi);
    				kat4.setKatMusteri(kat4.getKatMusteri() - yolcuSayi);
    				System.out.println("4.Katta " + y.getYolcu()  + " kisi kuyruga girdi.");
    				
    				System.out.println("4.Kat: Kattakiler: " + kat4.getKatMusteri() + " Kuyruk: " + kat4.getKuyrukMusteri());
    				for(int i = 0; i < kat4.katKuyruk.size(); i++) {
    	    			System.out.print("[" + kat4.katKuyruk.get(i).getYolcu() + "," + kat4.katKuyruk.get(i).getKat() + "] ");
    	    		}
    	    		System.out.println("\n");
    				
    			}
    		}
	    	
	    }
	}, 0, 1000);
		    		
	}	

}
