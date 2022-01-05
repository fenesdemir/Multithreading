
public class Yolcu {
	
	public int yolcuSayisi;
	public int gidilecekKat;
	
	public Yolcu(int yolcuSay, int kat) {
		this.yolcuSayisi = yolcuSay;
		this.gidilecekKat = kat;
	}
	
	public void setYolcu(int yolcu) {
		this.yolcuSayisi = yolcu;
	}
	
	public void setKat(int kat) {
		this.gidilecekKat = kat;
	}
	
	public int getYolcu() {
		return this.yolcuSayisi;
	}
	
	public int getKat() {
		return this.gidilecekKat;
	}	

}
