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

	public void usunWypozyczenie(Wypozyczenie w) {
		wypozyczenia.remove(w);
		
	}
	
	public boolean wypozyczKsiazkeCzytelnikowi(Ksiazka k, czytelnik c) {
		if (k.wypozycz()) {
			dodajWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
	}
	
	public boolean zwrocKsiazkeCzytelnikowi(Ksiazka k, czytelnik c ) {
		if (k.zwroc()) {
			zwrocWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
		
	}
	
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static String getUserInput() {
		return sc.nextLine().trim();
	    }
	
	
	private static void dodajKsiazkeU() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 DODAJ  KSIAŻKĘ              ######");
		System.out.println("#########################################################");
		Ksiazka k = new Ksiazka();
		System.out.print("Podaj autora: ");
        k.setAutor(getUserInput());
        k.setTytul(getUserInput());
        k.setIsbn(getUserInput());
        k.setLiczba_egzemplarzy(getUserInput());
        k.setLiczba_wypozyczonych_egzemplarzy(getUserInput());
        

        Ksiazka.dodajKsiazke(k);
        
        System.out.println("Dziękuję, dodałem ksiazkę do naszego zbioru.");
	}
	

	
	
	public static void main(String[] args) {
		Biblioteka bib = new Biblioteka();
		bib.dodajCzytelnika(new czytelnik("Adam", "Koźlak", 21));
		bib.dodajCzytelnika(new czytelnik("Sławomir", "Budka", 34));
		bib.dodajKsiazke(new Ksiazka("Rebecca", "Solnit", "677859", 2, 0));
		bib.dodajKsiazke(new Ksiazka("Adam", "Smith", "8327832", 5, 0));
		bib.dodajWypozyczenie(new Wypozyczenie(null, null));
		bib.dodajWypozyczenie(new Wypozyczenie(null, null));
		
		
		String wyborUzytkownika;
    	do {
    		System.out.println();
    		System.out.println("Witaj w Bibliotece!");
    		System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
	    	System.out.println("[1] Dodaj nowego kota");
	    	System.out.println("[2] Pokaż wszystkie koty");
	    	System.out.println("[x] Zakończ");
			wyborUzytkownika = getUserInput();
	    	if (wyborUzytkownika.equals("1")) {
	    		dodajKsiazkeU();
	    	} else if (wyborUzytkownika.equals("2")) {
	    		pokazKoty();
	    	}
    	} while (!wyborUzytkownika.equalsIgnoreCase("x"));
	
		
		
		
	}
	
	

}


/* public class Interfejs {

    static Scanner sc = new Scanner(System.in);
    
    static KotDAO kotDao = new KotDAO();

    public static void main(String[] args) {
    	String wyborUzytkownika;
    	do {
    		System.out.println();
    		System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
	    	System.out.println("[1] Dodaj nowego kota");
	    	System.out.println("[2] Pokaż wszystkie koty");
	    	System.out.println("[x] Zakończ");
			wyborUzytkownika = getUserInput();
	    	if (wyborUzytkownika.equals("1")) {
	    		dodajKota();
	    	} else if (wyborUzytkownika.equals("2")) {
	    		pokazKoty();
	    	}
    	} while (!wyborUzytkownika.equalsIgnoreCase("x"));
        
    }

	private static void pokazKoty() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 LISTA KOTÓW                 ######");
		System.out.println("#########################################################");
		
		Kot kot;
		for (int i=0; i<kotDao.getKoty().size(); i++) {
			kot = kotDao.getKoty().get(i);
			System.out.println(i + ": " + kot.getImie());
		}
		System.out.println();
		Pattern wzorzecNumeru = Pattern.compile("[0-9]+");
		String numerWczytany;
		do {
			System.out.print("Którego kota chcesz poznać bliżej? ");
			numerWczytany = getUserInput();
		} while (!wzorzecNumeru.matcher(numerWczytany).matches());
		
		Integer numerKota = Integer.parseInt(numerWczytany);
		if (kotDao.getKoty().size()>numerKota) {
			Kot wybranyKot = kotDao.getKoty().get(numerKota);
			System.out.println("Wybrany kot ma na imie "+wybranyKot.getImie()+", waży "+wybranyKot.getWaga()+", urodził się "+wybranyKot.getDataUrodzenia().toString()+", a opiekuje się nim "+wybranyKot.getImieOpiekuna());
		} else {
			System.out.println("Niestety, nie znalazłem kota o wybranym numerze :( Sprobój ponownie lub go dodaj!");
		}
	}

	private static void dodajKota() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 DODAJ  KOTA                 ######");
		System.out.println("#########################################################");
		Kot kot = new Kot();
		System.out.print("Podaj imię kota: ");
        kot.setImie(getUserInput());

        Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String dataUrodzeniaWczytana;
        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            dataUrodzeniaWczytana = getUserInput();
            if (wzorzecDaty.matcher(dataUrodzeniaWczytana).matches()) {
            	try {
            		kot.setDataUrodzenia(sdf.parse(dataUrodzeniaWczytana));
            	} catch (ParseException pe) {
            		System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
            	}
            }
        } while (kot.getDataUrodzenia()==null);
        
        Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String wagaWczytana;
        do {
            System.out.print("Podaj wagę kota: ");
            wagaWczytana = getUserInput();
            
            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
                kot.setWaga(Float.valueOf(wagaWczytana));
            }
        } while (kot.getWaga() == null);

        System.out.print("Podaj kto jest opiekunem kota: ");
        kot.setImieOpiekuna(getUserInput());

        kotDao.dodajKota(kot);
        
        System.out.println("Dziękuję, teraz wiem o kocie naprawdę wszystko! Dodałem go do naszego zbioru.");
	}

    public static String getUserInput() {
        return sc.nextLine().trim();
    }

}

 */
