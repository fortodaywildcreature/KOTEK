package biblioteka1;

public class Wypozyczenie {
	Ksiazka ksiazka;
	czytelnik czytelnik;
	
	public Wypozyczenie(Ksiazka ksiazka, czytelnik czytelnik) {
		this.ksiazka = ksiazka;
		this.czytelnik = czytelnik;
	}

	public Ksiazka getKsiazka() {
		return ksiazka;
	}

	public void setKsiazka(Ksiazka ksiazka) {
		this.ksiazka = ksiazka;
	}

	public czytelnik getCzytelnik() {
		return czytelnik;
	}

	public void setCzytelnik(czytelnik czytelnik) {
		this.czytelnik = czytelnik;
	}

	@Override
	public String toString() {
		return "Wypozyczenie [ksiazka=" + ksiazka + ", czytelnik=" + czytelnik + "]";
	}


}
