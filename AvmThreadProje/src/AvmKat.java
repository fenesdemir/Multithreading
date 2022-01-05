
import java.util.ArrayList;

public class AvmKat {
	
	public int katMusteri;
	public int kuyrukMusteri;
	ArrayList<Yolcu> katKuyruk = new ArrayList<Yolcu>();
	
	public AvmKat(int kat, int kuyruk) {
		this.katMusteri = kat;
		this.kuyrukMusteri = kuyruk;
	}
	
	public void setKatMusteri(int kat) {
		this.katMusteri = kat;
	}
	
	public int getKatMusteri() {
		return this.katMusteri;
	}
	
	public void setKuyrukMusteri(int musteri) {
		this.kuyrukMusteri = musteri;
	}
	
	public int getKuyrukMusteri() {
		return this.kuyrukMusteri;
	}

}
