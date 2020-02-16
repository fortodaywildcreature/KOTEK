package biblioteka1;

import java.util.ArrayList;

public class Ksiazka {
	private String autor;
	private String tytul;
	private String isbn;
	private int liczba_egzemplarzy;
	private int liczba_wypozyczonych_egzemplarzy;
	
	public Ksiazka (String autor, String tytul, String isbn, int liczba_egzemplarzy, int liczba_wypozyczonych_egzemplarzy) {
		this.autor = autor;
		this.tytul = tytul;
		this.isbn = isbn;
		this.liczba_egzemplarzy = liczba_egzemplarzy;
		this.liczba_wypozyczonych_egzemplarzy = liczba_wypozyczonych_egzemplarzy;
		
	}
	boolean wypozycz() {
		if (liczba_egzemplarzy - liczba_wypozyczonych_egzemplarzy > 0) {
			liczba_wypozyczonych_egzemplarzy += 1;
			return true;
		}
		else
			return false;
	}
	
	boolean zwroc() {
		if (liczba_wypozyczonych_egzemplarzy > liczba_egzemplarzy) {
			liczba_egzemplarzy += 1;
			return true;
		}
		else
			return false;
	}
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getLiczba_egzemplarzy() {
		return liczba_egzemplarzy;
	}
	public void setLiczba_egzemplarzy(int liczba_egzemplarzy) {
		this.liczba_egzemplarzy = liczba_egzemplarzy;
	}
	public int getLiczba_wypozyczonych_egzemplarzy() {
		return liczba_wypozyczonych_egzemplarzy;
	}
	public void setLiczba_wypozyczonych_egzemplarzy(int liczba_wypozyczonych_egzemplarzy) {
		this.liczba_wypozyczonych_egzemplarzy = liczba_wypozyczonych_egzemplarzy;
	}
	@Override
	public String toString() {
		return "Ksiazka [autor=" + autor + ", tytul=" + tytul + ", isbn=" + isbn + ", liczba_egzemplarzy="
				+ liczba_egzemplarzy + ", liczba_wypozyczonych_egzemplarzy=" + liczba_wypozyczonych_egzemplarzy + "]";
	}

	

}
