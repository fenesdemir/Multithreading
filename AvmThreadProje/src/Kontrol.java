import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Kontrol extends Thread{
	
	public boolean sadeceBir;
	
	public Kontrol( boolean birAsansorMu) {
		this.sadeceBir = birAsansorMu;
	}
	
	public void run(Asansor as2, Asansor as3, Asansor as4, Asansor as5, ArrayList<AvmKat> katlar, ArrayList<Boolean> kontrol) {
			
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
		    @Override
		    public void run()
		    {
		    						
					//20'nin ustu kontrolu
					for(int i = 0; i < katlar.size(); i++) {
						
						if(katlar.get(i).getKuyrukMusteri() > 20 && kontrol.get(i) == false) {
							
							if(as2.isAktifMi() == false) {
								
								as2.setAktifMi(true);
								System.out.println(i + ".katta kuyruk uzadi. Ikinci asansor aktif hale geliyor.");
								as2.run(katlar.get(0), katlar.get(1), katlar.get(2), katlar.get(3), katlar.get(4));
								setSadeceBir(false);
								kontrol.set(i, true);
								
							}else if(as3.isAktifMi() == false) {
								
								as3.setAktifMi(true);
								System.out.println(i + ".katta kuyruk uzadi. Ucuncu asansor aktif hale geliyor.");
								setSadeceBir(false);
								kontrol.set(i, true);
								
							}else if(as4.isAktifMi() == false) {
								
								as4.setAktifMi(true);
								System.out.println(i + ".katta kuyruk uzadi. Dorduncu asansor aktif hale geliyor.");
								setSadeceBir(false);
								kontrol.set(i, true);
								
							}else if(as5.isAktifMi() == false) {
								
								as5.setAktifMi(true);
								System.out.println(i + ".katta kuyruk uzadi. Besinci asansor aktif hale geliyor.");
								setSadeceBir(false);
								kontrol.set(i, true);
								
							}					
							
						}
						
					}
					
					//20'nin alti kontrolu
					
					if(isSadeceBir() == false) {
						
						for(int i = 0; i < katlar.size(); i++) {
							
							if(katlar.get(i).getKuyrukMusteri() < 20 && kontrol.get(i) == true) {
								
								if(as2.isAktifMi() == true && as2.getAsansordekiSayi() == 0) {
									
									as2.setAktifMi(false);
									System.out.println(i + ".katta kuyruk azaldi. Ikinci asansor pasif hale geliyor.");
									kontrol.set(i, false);
									
								}else if(as3.isAktifMi() == true && as3.getAsansordekiSayi() == 0) {
									
									as3.setAktifMi(false);
									System.out.println(i + ".katta kuyruk azaldi. Ucuncu asansor pasif hale geliyor.");
									kontrol.set(i, false);
									
								}else if(as4.isAktifMi() == true && as4.getAsansordekiSayi() == 0) {
									
									as4.setAktifMi(false);
									System.out.println(i + ".katta kuyruk azaldi. Dorduncu asansor pasif hale geliyor.");
									kontrol.set(i, false);
									
								}else if(as5.isAktifMi() == true && as5.getAsansordekiSayi() == 0) {
									
									as5.setAktifMi(false);
									System.out.println(i + ".katta kuyruk azaldi. Besinci asansor pasif hale geliyor.");
									kontrol.set(i, false);
									
								}					
								
							}
							
						}
						
						if(as2.isAktifMi() == false && as3.isAktifMi() == false && as4.isAktifMi() == false && as5.isAktifMi() == false) {
							setSadeceBir(true);
						}
										
					}
					    	
		    }
		}, 0, 200);
    		   	    			
	}

	public boolean isSadeceBir() {
		return sadeceBir;
	}

	public void setSadeceBir(boolean sadeceBir) {
		this.sadeceBir = sadeceBir;
	}

}
