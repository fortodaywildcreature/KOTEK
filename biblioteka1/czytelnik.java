package biblioteka1;

public class czytelnik {
	private String imie;
	private String nazwisko;
	private int numer_karty;
	
	public czytelnik(String imie, String nazwisko, int numer_karty) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.numer_karty = numer_karty;
	}
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getNumer_karty() {
		return numer_karty;
	}
	public void setNumer_karty(int numer_karty) {
		this.numer_karty = numer_karty;
	}
	@Override
	public String toString() {
		return "czytelnik [imie=" + imie + ", nazwisko=" + nazwisko + ", numer_karty=" + numer_karty + "] \n";
	}
	
		

}
