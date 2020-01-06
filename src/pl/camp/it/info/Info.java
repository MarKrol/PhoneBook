package pl.camp.it.info;

public class Info {
    private static void info(){
        System.out.println("INFORMACJE O PROGRAMIE \n\n");
        System.out.println("Program jest bazą danych obsługującą książkę tefoniczną osób indywidualnych i firm.\n\n" +
                "W programie możliwe jest dodawanie nowych podmiotów, usuwanie, wyszukiwanie oraz wyświetlanie. \n\n"+
                "Dodawanie podmiotów do bazy odbywa się po ich wcześniejszym określeniu osobowości prawnej.\n" +
                "Dodając podmiot należy podać następujące dane: imię i nawisko (osoby indywidualne), nazwa i NIP\n" +
                "(firmy) oraz adres i nr telefonu dla każdego z podmiotów. Podając adres należy określić ulicę,\n" +
                "nr budynku, kod, miasto, region/województwo, państwo oraz numer telefonu.\n\n" +
                "Program umożliwa dodanie podmiotu z różnych państw, dlatego też kod nie jest wymagany, ponieważ\n" +
                "nie wszystkie Państwa go posiadają.\n" +
                "NIP firm jest również w każdym Państwie inaczej budowany dlatego też można go wprowadzać jako\n" +
                "string, ponieważ w UE określa się NIP kraju podjąc jego numer i prefiks np.: PL1234567890.\n" +
                "Numer telofonu w różnych krajach ma różną długość, dlatego też dopuszczone zostały  programie\n" +
                "następujące możliwości podawania numerów np:\n" +
                "0048 12 345 67 89 lub +48 12 345 67 90 lub 1 234-567-89-012\n" +
                "Numery tefonów moga więc być wprowadzane w taki sposób, że poszczególne liczby będą oddzielone\n" +
                "od siebie spacjami lub puzami/myślnikami(-), a numer może zaczynać się od zer lub +.\n\n");
    }

    public static void showInfo(){
        info();
    }
}
