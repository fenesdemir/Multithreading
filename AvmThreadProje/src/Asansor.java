import java.util.ArrayList;

public class Asansor extends Thread {
	
	public int hangiKat;
	public int asansorNo;
	public boolean yukariMi;
	public int hedefKat;
	public boolean aktifMi;
	public int maxKapasite;
	public int asansordekiSayi;
	ArrayList<Yolcu> asansordekiler = new ArrayList<Yolcu>();
	
	public Asansor(int no, int kat, int hedef, boolean yukAs, boolean aktif, int kapasite, int sayi) {
		this.asansorNo = no;
		this.hangiKat = kat;
		this.hedefKat = hedef;
		this.yukariMi = yukAs;
		this.aktifMi = aktif;
		this.maxKapasite = kapasite;
		this.asansordekiSayi = sayi;
	}
	
	public synchronized void run(AvmKat zemin, AvmKat kat1, AvmKat kat2, AvmKat kat3, AvmKat kat4) {
			
		if(isAktifMi() == true) {
			
			while(true) {
				
				if(getHangiKat() == 0 && isYukariMi() == true) {
					
					if(asansordekiler.size() != 0) {
						asansordekiler.clear();
						setAsansordekiSayi(0);
					}
					
					for(int i = 0; i < zemin.katKuyruk.size(); i++) {												
						ArrayList<Yolcu> cikacaklar = new ArrayList<Yolcu>();
						if(zemin.katKuyruk.get(i).getYolcu() + getAsansordekiSayi() <= getMaxKapasite()) {
							asansordekiler.add(zemin.katKuyruk.get(i));
							cikacaklar.add(zemin.katKuyruk.get(i));
							setAsansordekiSayi(getAsansordekiSayi() + zemin.katKuyruk.get(i).getYolcu());
							System.out.print(getAsansorNo() + ".Asansore zemin katta " + zemin.katKuyruk.get(i).getYolcu() + " kisi bindi.");
							System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
							for(int j = 0; j < asansordekiler.size(); j++) {
				    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
				    		}
				    		System.out.println("\n");
					    	zemin.setKuyrukMusteri(zemin.getKuyrukMusteri() - zemin.katKuyruk.get(i).getYolcu());
						}
						zemin.katKuyruk.removeAll(cikacaklar);
						cikacaklar.clear();
					}
					
					for(int i = 0; i < asansordekiler.size(); i++) {
						if(asansordekiler.get(i).getKat() > getHedefKat()) {
							setHedefKat(asansordekiler.get(i).getKat());
						}
					}
					
					if(kat1.katKuyruk.size() != 0 && getHedefKat() < 1) {
						setHedefKat(1);
					}else if(kat2.katKuyruk.size() != 0 && getHedefKat() < 2) {
						setHedefKat(2);
					}else if(kat3.katKuyruk.size() != 0 && getHedefKat() < 3) {
						setHedefKat(3);
					}else if(kat4.katKuyruk.size() != 0 && getHedefKat() < 4) {
						setHedefKat(4);
					}					
									
					yukariCik(getHedefKat(), kat1, kat2, kat3, kat4);
					setYukariMi(false);
					
				}else if(getHangiKat() == getHedefKat() && isYukariMi() == false) {
					
					asagiIn(getHangiKat(), zemin, kat1, kat2, kat3, kat4);
					setYukariMi(true);
				}
				
			}
			
		}		
		
	}
	
	public synchronized void yukariCik(int hedef, AvmKat kat1, AvmKat kat2, AvmKat kat3, AvmKat kat4) {
		int sayac = 0;
		
		while(sayac <= hedef) {
			
			if(sayac == 1) {
				setHangiKat(1);
				ArrayList<Yolcu> inecekler = new ArrayList<Yolcu>();
				for(int i = 0; i < asansordekiler.size(); i++) {
					if(asansordekiler.get(i).getKat() == 1) {
						kat1.setKatMusteri(kat1.getKatMusteri() + asansordekiler.get(i).getYolcu());
						setAsansordekiSayi(getAsansordekiSayi() - asansordekiler.get(i).getYolcu());
						System.out.println("1.Katta " + getAsansorNo() + ".asansorden " + asansordekiler.get(i).getYolcu() + " kisi indi. 1.kat: Kattakiler: " + kat1.getKatMusteri() + " Kuyruk: " + kat1.getKuyrukMusteri());
						inecekler.add(asansordekiler.get(i));
					}
				}
				asansordekiler.removeAll(inecekler);
				System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
				for(int j = 0; j < asansordekiler.size(); j++) {
	    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
	    		}
	    		System.out.println("\n");
				inecekler.clear();
			}else if(sayac == 2) {
				setHangiKat(2);
				ArrayList<Yolcu> inecekler = new ArrayList<Yolcu>();
				for(int i = 0; i < asansordekiler.size(); i++) {
					if(asansordekiler.get(i).getKat() == 2) {
						kat2.setKatMusteri(kat2.getKatMusteri() + asansordekiler.get(i).getYolcu());
						setAsansordekiSayi(getAsansordekiSayi() - asansordekiler.get(i).getYolcu());
						System.out.println("2.Katta " + getAsansorNo() + ".asansorden " + asansordekiler.get(i).getYolcu() + " kisi indi. 2.kat: Kattakiler: " + kat2.getKatMusteri() + " Kuyruk: " + kat2.getKuyrukMusteri());
						inecekler.add(asansordekiler.get(i));
					}
				}
				asansordekiler.removeAll(inecekler);
				System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
				for(int j = 0; j < asansordekiler.size(); j++) {
	    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
	    		}
	    		System.out.println("\n");
				inecekler.clear();
			}else if(sayac == 3) {
				setHangiKat(3);
				ArrayList<Yolcu> inecekler = new ArrayList<Yolcu>();
				for(int i = 0; i < asansordekiler.size(); i++) {
					if(asansordekiler.get(i).getKat() == 3) {
						kat3.setKatMusteri(kat3.getKatMusteri() + asansordekiler.get(i).getYolcu());
						setAsansordekiSayi(getAsansordekiSayi() - asansordekiler.get(i).getYolcu());
						System.out.println("3.Katta " + getAsansorNo() + ".asansorden " + asansordekiler.get(i).getYolcu() + " kisi indi. 3.kat: Kattakiler: " + kat3.getKatMusteri() + " Kuyruk: " + kat3.getKuyrukMusteri());
						inecekler.add(asansordekiler.get(i));
					}
				}
				asansordekiler.removeAll(inecekler);
				System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
				for(int j = 0; j < asansordekiler.size(); j++) {
	    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
	    		}
	    		System.out.println("\n");
				inecekler.clear();
			}else if(sayac == 4) {
				setHangiKat(4);
				ArrayList<Yolcu> inecekler = new ArrayList<Yolcu>();
				for(int i = 0; i < asansordekiler.size(); i++) {
					if(asansordekiler.get(i).getKat() == 4) {
						kat4.setKatMusteri(kat4.getKatMusteri() + asansordekiler.get(i).getYolcu());
						setAsansordekiSayi(getAsansordekiSayi() - asansordekiler.get(i).getYolcu());
						System.out.println("4.Katta " + getAsansorNo() + ".asansorden " + asansordekiler.get(i).getYolcu() + " kisi indi. 4.kat: Kattakiler: " + kat4.getKatMusteri() + " Kuyruk: " + kat4.getKuyrukMusteri());
						inecekler.add(asansordekiler.get(i));
					}
				}
				asansordekiler.removeAll(inecekler);
				System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
				for(int j = 0; j < asansordekiler.size(); j++) {
	    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
	    		}
	    		System.out.println("\n");
				inecekler.clear();
			}	
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sayac++;
		}
		
	}
	
	public synchronized void asagiIn(int bulunan ,AvmKat zemin, AvmKat kat1, AvmKat kat2, AvmKat kat3, AvmKat kat4) {
		int sayac = bulunan;
		
		while(sayac >= 0) {
			
			if(sayac == 4 && kat4.katKuyruk.size() != 0) {
				setHangiKat(4);
				ArrayList<Yolcu> cikacaklar = new ArrayList<Yolcu>();
				for(int i = 0; i < kat4.katKuyruk.size(); i++) {
					if(kat4.katKuyruk.get(i).getYolcu() + getAsansordekiSayi() <= getMaxKapasite()) {
						asansordekiler.add(kat4.katKuyruk.get(i));
						cikacaklar.add(kat4.katKuyruk.get(i));
						setAsansordekiSayi(getAsansordekiSayi() + kat4.katKuyruk.get(i).getYolcu());
						System.out.println("4.Katta " + getAsansorNo() + ".asansore " + kat4.katKuyruk.get(i).getYolcu() + " kisi bindi. Yolcu sayisi: " + getAsansordekiSayi());
						System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
						for(int j = 0; j < asansordekiler.size(); j++) {
			    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
			    		}
			    		System.out.println("\n");
						kat4.setKuyrukMusteri(kat4.getKuyrukMusteri() - kat4.katKuyruk.get(i).getYolcu());
					}
				}
				kat4.katKuyruk.removeAll(cikacaklar);
				System.out.println("4.kat: Kattakiler: " + kat4.getKatMusteri() + " Kuyruk: " + kat4.getKuyrukMusteri());
				cikacaklar.clear();
			}else if(sayac == 3 && kat3.katKuyruk.size() != 0) {
				setHangiKat(3);
				ArrayList<Yolcu> cikacaklar = new ArrayList<Yolcu>();
				for(int i = 0; i < kat3.katKuyruk.size(); i++) {
					if(kat3.katKuyruk.get(i).getYolcu() + getAsansordekiSayi() <= getMaxKapasite()) {
						asansordekiler.add(kat3.katKuyruk.get(i));
						cikacaklar.add(kat3.katKuyruk.get(i));
						setAsansordekiSayi(getAsansordekiSayi() + kat3.katKuyruk.get(i).getYolcu());
						System.out.println("3.Katta " + getAsansorNo() + ".asansore " + kat3.katKuyruk.get(i).getYolcu() + " kisi bindi. Yolcu sayisi: " + getAsansordekiSayi());
						System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
						for(int j = 0; j < asansordekiler.size(); j++) {
			    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
			    		}
			    		System.out.println("\n");
						kat3.setKuyrukMusteri(kat3.getKuyrukMusteri() - kat3.katKuyruk.get(i).getYolcu());
					}
				}
				kat3.katKuyruk.removeAll(cikacaklar);
				System.out.println("3.kat: Kattakiler: " + kat3.getKatMusteri() + " Kuyruk: " + kat3.getKuyrukMusteri());
				cikacaklar.clear();	
			}else if(sayac == 2 && kat2.katKuyruk.size() != 0) {
				setHangiKat(2);
				ArrayList<Yolcu> cikacaklar = new ArrayList<Yolcu>();
				for(int i = 0; i < kat2.katKuyruk.size(); i++) {
					if(kat2.katKuyruk.get(i).getYolcu() + getAsansordekiSayi() <= getMaxKapasite()) {
						asansordekiler.add(kat2.katKuyruk.get(i));
						cikacaklar.add(kat2.katKuyruk.get(i));
						setAsansordekiSayi(getAsansordekiSayi() + kat2.katKuyruk.get(i).getYolcu());
						System.out.println("2.Katta " + getAsansorNo() + ".asansore " + kat2.katKuyruk.get(i).getYolcu() + " kisi bindi. Yolcu sayisi: " + getAsansordekiSayi());
						System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
						for(int j = 0; j < asansordekiler.size(); j++) {
			    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
			    		}
			    		System.out.println("\n");
						kat2.setKuyrukMusteri(kat2.getKuyrukMusteri() - kat2.katKuyruk.get(i).getYolcu());
					}
				}
				kat2.katKuyruk.removeAll(cikacaklar);
				System.out.println("2.kat: Kattakiler: " + kat2.getKatMusteri() + " Kuyruk: " + kat2.getKuyrukMusteri());
				cikacaklar.clear();	
			}else if(sayac == 1 && kat1.katKuyruk.size() != 0) {
				setHangiKat(1);
				ArrayList<Yolcu> cikacaklar = new ArrayList<Yolcu>();
				for(int i = 0; i < kat1.katKuyruk.size(); i++) {
					if(kat1.katKuyruk.get(i).getYolcu() + getAsansordekiSayi() <= getMaxKapasite()) {
						asansordekiler.add(kat1.katKuyruk.get(i));
						cikacaklar.add(kat1.katKuyruk.get(i));
						setAsansordekiSayi(getAsansordekiSayi() + kat1.katKuyruk.get(i).getYolcu());
						System.out.println("1.Katta " + getAsansorNo() + ".asansore " + kat1.katKuyruk.get(i).getYolcu() + " kisi bindi. Yolcu sayisi: " + getAsansordekiSayi());
						System.out.print(getAsansorNo() + ".Asansor Kuyruk: ");
						for(int j = 0; j < asansordekiler.size(); j++) {
			    			System.out.print("[" + asansordekiler.get(j).getYolcu() + "," + asansordekiler.get(j).getKat() + "] ");
			    		}
			    		System.out.println("\n");
						kat1.setKuyrukMusteri(kat1.getKuyrukMusteri() - kat1.katKuyruk.get(i).getYolcu());
					}
				}
				kat1.katKuyruk.removeAll(cikacaklar);
				System.out.println("1.kat: Kattakiler: " + kat1.getKatMusteri() + " Kuyruk: " + kat1.getKuyrukMusteri());
				cikacaklar.clear();	
			}else if(sayac == 0 ) {
				setHangiKat(0);
				if(getAsansordekiSayi() != 0) {
				System.out.println("Zemin kat. " + getAsansorNo() + ".asansorden " + getAsansordekiSayi() + " kiþi indi.");
				}
				asansordekiler.clear();	
				setAsansordekiSayi(0);
			}
			
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sayac--;
		}
		
	}

	public int getHangiKat() {
		return hangiKat;
	}

	public void setHangiKat(int hangiKat) {
		this.hangiKat = hangiKat;
	}

	public boolean isYukariMi() {
		return yukariMi;
	}

	public void setYukariMi(boolean yukariMi) {
		this.yukariMi = yukariMi;
	}

	public int getHedefKat() {
		return hedefKat;
	}

	public void setHedefKat(int hedefKat) {
		this.hedefKat = hedefKat;
	}

	public boolean isAktifMi() {
		return aktifMi;
	}

	public void setAktifMi(boolean aktifMi) {
		this.aktifMi = aktifMi;
	}

	public int getMaxKapasite() {
		return maxKapasite;
	}

	public void setMaxKapasite(int maxKapasite) {
		this.maxKapasite = maxKapasite;
	}

	public int getAsansordekiSayi() {
		return asansordekiSayi;
	}

	public void setAsansordekiSayi(int asansordekiSayi) {
		this.asansordekiSayi = asansordekiSayi;
	}

	public int getAsansorNo() {
		return asansorNo;
	}

	public void setAsansorNo(int asansorNo) {
		this.asansorNo = asansorNo;
	}
				
}
