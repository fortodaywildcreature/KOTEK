package biblioteka1;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
	
	ArrayList<Ksiazka> ksiazki;
	ArrayList<czytelnik> czytelnicy;
	ArrayList<Wypozyczenie> wypozyczenia;
	
	public Biblioteka() {
		ksiazki = new ArrayList<Ksiazka>();
		czytelnicy = new ArrayList<czytelnik>();
		wypozyczenia = new ArrayList<Wypozyczenie>();
	}
	
	
	public void dodajKsiazke(Ksiazka k) {
		ksiazki.add(k);
	}

	public void dodajCzytelnika(czytelnik c) {

		czytelnicy.add(c);
	}

	public void dodajWypozyczenie(Wypozyczenie w) {
		wypozyczenia.add(w);
		
	}
	
	public void zwrocWypozyczenie(Wypozyczenie w) {

		wypozyczenia.remove(w);
	}

	public void usunKsiazke(Ksiazka k) {

		ksiazki.remove(k);
	}

	public void usunCzytelnika(czytelnik c) {

		czytelnicy.remove(c);
	}

	/*public void usunWypozyczenie(Wypozyczenie w) {
		wypozyczenia.remove(w);
		}
	*/
	
	public boolean wypozyczKsiazkeCzytelnikowi(Ksiazka k, czytelnik c) {
		if (k.wypozycz()) {
			dodajWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
	}
	
	public boolean zwrocKsiazke(Ksiazka k, Wypozyczenie w) {
		if (k.zwroc()) {
			zwrocWypozyczenie(w);
			return true;
		}
		else 
			return false;
		
	}

	public void dostepnoscKsiazki(Ksiazka k){
		if (k.getLiczba_egzemplarzy() > k.getLiczba_wypozyczonych_egzemplarzy()) {
			System.out.println("Podana przez Ciebie książka jest dostępna.");
		}
		else
			System.out.println("Niestety wszystkie ezgemplarze podanej przez Ciebie pozycji są wypożyczone.");

	}

	public void statusWypozyczen(czytelnik c){
		if (wypozyczenia.contains(c)){
			System.out.println("Czytelnik o podanym numerze karty ma wypożyczone książki");
		}
		else
			System.out.println("Czytelnik o podanym numerze karty ma wypożyczone ksiażki");

	}

	
	static Scanner sc = new Scanner(System.in);
	
	public static String getUserInput() {
		return sc.nextLine().trim();
	    }
	
	
/*	private void dodajKsiazkeU(Ksiazka m) {
		System.out.println("Podaj autora: ");
		String m1 = (getUserInput());
		System.out.println("Podaj tytuł: ");
		String m2 = (getUserInput());
		System.out.println("Podaj isbn: ");
		String m3 = (getUserInput());
		System.out.println("Podaj liczbę dostepnych egzemplarzy: ");
		int liczba1 = Integer.parseInt(getUserInput());
		System.out.println("Podaj liczbę wypożyczonych egzemplarzy: ");
		int liczba2 = Integer.parseInt(getUserInput());
		Ksiazka m = new Ksiazka (m1, m2, m3, liczba1, liczba2);
		dodajKsiazke(m);
		System.out.println(ksiazki);
		System.out.println("Dziękuję, dodałem ksiazkę do naszego zbioru.");
	}
*/



	
	
	public static void main(String[] args) {
		czytelnik cz1 = new czytelnik ("Andrzej", "Witos", 0);
		czytelnik cz2 = new czytelnik ("Joanna", "Kania", 1);
		czytelnik cz3 = new czytelnik ("Katarzyna", "Matejko", 2);
		Ksiazka k1 = new Ksiazka("Kenkō", "Zapiski dla zabicia czasu", "978-83-66147-30-0", 4, 4);
		Ksiazka k2 = new Ksiazka("Wells Tower", "Ruiny i zgliszcza", "978-83-65271-35-8", 5, 1);
		Ksiazka k3 = new Ksiazka("Deyan Sudjic", "Język miast", "978-83-65271-41-9", 8, 1);
		Wypozyczenie w1 = new Wypozyczenie(k2, cz1);
		Wypozyczenie w2 = new Wypozyczenie(k2, cz2);


		Biblioteka bib = new Biblioteka();
		bib.dodajCzytelnika(cz1);
		bib.dodajCzytelnika(cz2);
		bib.dodajCzytelnika(cz3);
		bib.dodajKsiazke(k1);
		bib.dodajKsiazke(k2);
		bib.dodajKsiazke(k3);
		bib.dodajWypozyczenie(w1);
		bib.dodajWypozyczenie(w2);

		
		String wyborUzytkownika;
    	do {
    		System.out.println();
    		System.out.println("Witaj w Bibliotece!");
    		System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
	    	System.out.println("[1] Dodaj nową książkę.");
	    	System.out.println("[2] Usuń książkę.");
	    	System.out.println("[3] Dodaj nowego czytelnika.");
	    	System.out.println("[4] Usuń czytelnika.");
	    	System.out.println("[5] Wypożycz książkę.");
	    	System.out.println("[6] Oddaj książkę.");
	    	System.out.println("[7] Sprawdź stan wypożyczeń danego czytelnika.");
	    	System.out.println("[8] Sprawdź dostępność danej ksiażki.");
	    	System.out.println("[x] Zakończ");
			wyborUzytkownika = getUserInput();
	    	if (wyborUzytkownika.equals("1")) {
				System.out.println("Podaj autora: ");
				String m1 = (getUserInput());
				System.out.println("Podaj tytuł: ");
				String m2 = (getUserInput());
				System.out.println("Podaj isbn: ");
				String m3 = (getUserInput());
				System.out.println("Podaj liczbę dostepnych egzemplarzy: ");
				int liczba1 = Integer.parseInt(getUserInput());
				System.out.println("Podaj liczbę wypożyczonych egzemplarzy: ");
				int liczba2 = Integer.parseInt(getUserInput());
				Ksiazka m = new Ksiazka (m1, m2, m3, liczba1, liczba2);
				bib.dodajKsiazke(m);
				System.out.println(bib.ksiazki);

	    	}
	    	else if (wyborUzytkownika.equals("2")) {
	    		System.out.println("Oto książki dodane do bazy biblioteki. Podaj indeks tej, którą chciałbyś usunać:");
				System.out.println(bib.ksiazki);
	    		int i = Integer.parseInt(getUserInput());
	    		bib.ksiazki.remove(i);
				System.out.println(bib.ksiazki);
	    	}
	    	else if (wyborUzytkownika.equals("3")){
				System.out.println("Podaj imie: ");
				String c1 = (getUserInput());
				System.out.println("Podaj nazwisko: ");
				String c2 = (getUserInput());
				System.out.println("Podaj numer karty: ");
				int c3 = Integer.parseInt(getUserInput());
				czytelnik cc = new czytelnik (c1, c2, c3);
				bib.dodajCzytelnika(cc);
				System.out.println(bib.czytelnicy);
			}
			else if (wyborUzytkownika.equals("4")){
				System.out.println("Oto czytelnicy znajdujący się w bazie biblioteki. Podaj indeks osoby, którą chciałbyś usunać:");
				System.out.println(bib.czytelnicy);
				int j = Integer.parseInt(getUserInput());
				bib.czytelnicy.remove(j);
				System.out.println(bib.ksiazki);
			}
			else if (wyborUzytkownika.equals("5")){
				System.out.println("Podaj swoje dane czytelnika.");
				System.out.println("Imię: ");
				String ccc = (getUserInput());
				System.out.println("Nazwisko: ");
				String ccc1 = (getUserInput());
				System.out.println("Numer: ");
				int ccc2 = Integer.parseInt(getUserInput());
				System.out.println("Podaj informacje o ksiażce, ktora chcesz wypozyczyć.");
				System.out.println("Autor: ");
				String kkk = (getUserInput());
				System.out.println("Tytuł: ");
				String kkk1 = (getUserInput());
				System.out.println("Isbn: ");
				String kkk2 = (getUserInput());
				System.out.println("Liczba egzemplarzy: ");
				int kkk3 = Integer.parseInt(getUserInput());
				System.out.println("Liczba wypożyczonych egzemplarzy: ");
				int kkk4 = Integer.parseInt(getUserInput());
				czytelnik cccc = new czytelnik(ccc,ccc1,ccc2);
				Ksiazka kkkk = new Ksiazka(kkk,kkk1,kkk2,kkk3,kkk4);
				bib.wypozyczKsiazkeCzytelnikowi(kkkk,cccc);
				System.out.println("Oto lista wypożyczonych książek: ");
				System.out.println(bib.wypozyczenia);
			}
			else if (wyborUzytkownika.equals("6")){
				System.out.println("Oto lista wypożyczonych książek.");
				System.out.println("Pozycję o którym indeksie chcesz zwrócić?");
				System.out.println(bib.wypozyczenia);
				int aaa = Integer.parseInt(getUserInput());
				bib.wypozyczenia.remove(aaa);
				System.out.println(bib.wypozyczenia);
				System.out.println(bib.ksiazki);

			}

			else if (wyborUzytkownika.equals("7")){
				System.out.println("Podaj swoje dane czytelnika.");
				System.out.println("Imię: ");
				String bb = (getUserInput());
				System.out.println("Nazwisko: ");
				String bb1 = (getUserInput());
				System.out.println("Numer: ");
				int bb2 = Integer.parseInt(getUserInput());
				czytelnik bbb = new czytelnik(bb,bb1,bb2);
				bib.statusWypozyczen(bbb);


			}
			else if (wyborUzytkownika.equals("8")){
				System.out.println("Podaj dane książki której dostępność chcesz sprawdzić");
				System.out.println("Autor: ");
				String f = (getUserInput());
				System.out.println("Tytuł: ");
				String f1 = (getUserInput());
				System.out.println("Isbn: ");
				String f2 = (getUserInput());
				System.out.println("Liczba egzemplarzy: ");
				int f3 = Integer.parseInt(getUserInput());
				System.out.println("Liczba wypożyczonych egzemplarzy: ");
				int f4 = Integer.parseInt(getUserInput());

				//Ksiazka ffff = new Ksiazka(f,f1,f2,null,null);
				//bib.dostepnoscKsiazki(ffff);

			}

    	} while (!wyborUzytkownika.equalsIgnoreCase("x"));
	
		
		
		
	}



}


/*
System.out.println("Podaj swoje dane czytelnika.");
				System.out.println("Imię: ");
				String t = (getUserInput());
				System.out.println("Nazwisko: ");
				String t1 = (getUserInput());
				System.out.println("Numer: ");
				int t2 = Integer.parseInt(getUserInput());
				System.out.println("Podaj informacje o ksiażce, ktora chcesz zwrócić.");
				System.out.println("Autor: ");
				String y = (getUserInput());
				System.out.println("Tytuł: ");
				String y1 = (getUserInput());
				System.out.println("Isbn: ");
				String y2 = (getUserInput());
				System.out.println("Liczba egzemplarzy: ");
				int y3 = Integer.parseInt(getUserInput());
				System.out.println("Liczba wypożyczonych egzemplarzy: ");
				int y4 = Integer.parseInt(getUserInput());
				czytelnik tt = new czytelnik(t,t1,t2);
				Ksiazka yy = new Ksiazka(y,y1,y2,y3,y4);
				Wypozyczenie qq = new Wypozyczenie(yy,tt);
				bib.zwrocKsiazke(yy,qq);
				System.out.println("Oto lista wypożyczonych książek: ");
				System.out.println(bib.wypozyczenia);
 */
