package pl.camp.it.methods;

import pl.camp.it.db.UserRepository;
import pl.camp.it.user.Business;
import pl.camp.it.user.Individual;
import pl.camp.it.user.UserStructure;

import java.util.Scanner;

public class Methods {

    public static String scannerLine(){
        return new Scanner(System.in).nextLine();
    }

    //Metoda wypisująca nazwy kolumn dla prywatnej osoby
    private static void showNameColumnsPersonIndividual(){
        System.out.format("%-10s %-25s %-30s %-35s %-10s %-30s %-10s %-40s %-35s %-25s", "[Indeks]","[Imię]",
                "[Nazwisko]", "[Ulica]","[Numer]", "[Miasto]", "[Kod]", "[Województwo]", "[Kraj]","[Nr telefonu]");
    }

    //Metoda wypisująca nazwy kolumn dla korporacji
    private static void showNameColumnsCorporation(){
        System.out.format("%-10s %-35s %-20s %-35s %-10s %-30s %-10s %-40s %-35s %-25s", "[Indeks]","[Nazwa]",
                "[NIP]", "[Ulica]","[Numer]", "[Miasto]", "[Kod]", "[Województwo]", "[Kraj]","[Nr telefonu]");
    }

    //Metoda wyświetlająca indeks znalezionego podmiotu w bazie
    private static void writeIndex(int index){
        System.out.print(index+".");
    }

    //Wyszukuje tylko osób indywidualnych z bazy
    private static void repositoryPersonIndywidual (){
        int index = 0;
        for(UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if ((temp !=null) && (temp instanceof Individual)) {
                writeIndex(++index);
                System.out.println(temp);
            }
        }
    }

    //Wyszukuje tylko osób indywidualnych z bazy
    private static void repositoryPersonIndywidual (UserStructure[] tempolary){
        int index = 0;
        for(UserStructure temp: tempolary){
            if ((temp !=null) && (temp instanceof Individual)) {
                writeIndex(++index);
                System.out.println(temp);
            }
        }
    }

    //Metoda wyświetaljaca osoby indywidualne z bazy
    public static void showRepositoryPersonIndywidual(){
        if (countPersonIndividual()!=0) {
            System.out.println();
            showNameColumnsPersonIndividual();
            System.out.println();
            repositoryPersonIndywidual();
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Baza numerów telefonów dla osób indywidualnych jest pusta!!!"+"\n");
        }
    }

    //Wyszukuje tylko firm z bazy
    private static void repositoryCorporation(){
        int index = 0;
        for(UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if ((temp !=null) && (temp instanceof Business)) {
                writeIndex(++index);
                System.out.println(temp);
            }
        }
    }

    //Wyszukuje tylko firm z bazy
    private static void repositoryCorporation(UserStructure[] tempolary){
        int index = 0;
        for(UserStructure temp: tempolary){
            if ((temp !=null) && (temp instanceof Business)) {
                writeIndex(++index);
                System.out.println(temp);
            }
        }
    }


    //Metoda wyświetlająca firmy z bazy
    public static void showRepositoryCorporation(){
        if(countCorporation()!=0) {
            System.out.println();
            showNameColumnsCorporation();
            System.out.println();
            repositoryCorporation();
            System.out.println();
        } else{
            System.out.println();
            System.out.println("Baza numerów telefonów dla firm jest pusta!!!"+"\n");

        }
    }

    // Metosa sprawdza czy jest wolne miejsce w tablicy do wpisu
    private static boolean isFreeSpaceArray(){
        if (returnIndexArrayNull(null)< UserRepository.getUserRepository().getUserStructures().length){
            return true;
        } else {
            return false;
        }
    }

    // Metoda zwraca pierwszy mumer indeksu tabeli, w którym wartość komórki jest Null (pierwszą wolną komórkę)
    private static int returnIndexArrayNull(UserStructure arrayData){
        int index = 0;
        for (UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if (temp == arrayData){
                break;
            } else{
                index++;
            }
        }
        return index;
    }

    //Metoda dodająca do bazy osobę indywidualną
    private static void addToArrayDataPersonIndivdual(int index, String name, String surname, String street,
                                                      String buldingnumber, String city, String zip, String province,
                                                      String country, String numberphone){

        UserStructure[] tempolary = UserRepository.getUserRepository().getUserStructures();

        tempolary[index] = new Individual(street, buldingnumber, zip, city, province, country,
                numberphone, name, surname);

    }

    //Metoda dodająca do bazy dane firmy
    private static void addToArrayDataCompany(int index, String companyname, String nipcompany, String street,
                                                      String buldingnumber, String city, String zip, String province,
                                                      String country, String numberphone){

        UserStructure[] tempolary = UserRepository.getUserRepository().getUserStructures();

        tempolary[index] = new Business(street, buldingnumber, zip, city, province, country, numberphone,
                companyname,nipcompany);
    }

    //Metoda sprawdza czy wprowadzany ciąg znaków jest pusty i zwraca wprowadzony ciąg znaków
    private static String stringEmpty(){
        String data;
        while((data=scannerLine()).equals("")){
            System.out.print("Nie wprowadzono danych lub dane nie są poprawne!!! "+"\n");
            System.out.print("\n"+ "Wprowadź dane: ");
        }
        return data;
    }

    //Metoda sprawdza, czy wprowadzono poprawnie nr telefonu
    private static String givenOnlyNumber(){
        String numberphone;

        while (((numberphone=scannerLine()).equals("")) || (!isNumberPhone (numberphone))){
            System.out.print("Nie wprowadzono danych lub dane nie są poprawne!!! "+"\n");
            System.out.print("\n"+ "Wprowadź dane: ");
        }
        return numberphone;
    }

    //Sprawdza czy w prowadzonym numerze są tylko cyfry ewentualnie "+" na pierwszej pozycji
    private static boolean isNumberPhone(String numberphone){
        boolean correctnumber = false;
        for (int i=0; i < numberphone.length(); i++){
            if ((i==0) && numberphone.charAt(0)=='+'){
                    correctnumber = true;
                }
            else {
                if ((numberphone.charAt(i)>=48  && numberphone.charAt(i)<=57) ||
                        (numberphone.charAt(i)=='-' || numberphone.charAt(i)==' ')){
                    correctnumber = true;
                }
                else {
                    correctnumber = false;
                    break;
                }
            }
        }
        return correctnumber;
    }


    // Metoda zwracająca imię osoby indywidualnej do bazy
    private static String addPersonName(){
        System.out.print("Imię: ");
        return stringEmpty();
    }

    //Metoda zwracająca nazwisko osoby indywidualnej do bazy
    private static String addPersonSurname(){
        System.out.print("Nazwisko: ");
        return stringEmpty();
    }

    //Metoda zwracająca do bazy nazwę firmy
    private static String addNameCompany(){
        System.out.print("Nazwa firmy: ");
        return stringEmpty();
    }

    //Metoda zwracająca do bazy NIP
    private static String addNipCompany(){
        System.out.print("NIP: ");
        return stringEmpty();
    }


    //Metoda zwracająca ulicę do bazy
    private static String addStreet(){
        System.out.print("Ulica: ");
        return stringEmpty();
    }

    //Metoda zwracająca nr budynku/mieszkania/lokalu do bazy
    private static String addBuldingNumber(){
        System.out.print("Numer domu/mieszkania/lokalu: ");
        return stringEmpty();
    }

    //Metoda zwracajaca miasto do bazy
    private static String addCity(){
        System.out.print("Miasto: ");
        return stringEmpty();
    }

    //Metoda zwracajaca kod do bazy
    private static String addZip(){
        System.out.print("Kod: ");
        return scannerLine();
    }

    //Metoda zwracajaca region do bazy
    private static String addProvince(){
        System.out.print("Województwo/region/stan: ");
        return stringEmpty();
    }

    //Metoda zwracajaca Państwo do bazy
    private static String addCountry(){
        System.out.print("Państwo: ");
        return stringEmpty();
    }

    //Metoda zwracająca do bazy numer telefonu
    private static String addNumberPhone(){
        System.out.print("Numer telefonu: ");
        return givenOnlyNumber();
    }


    //Metoda wywołująca dodanie danych do bazy osób indywidualnych
    public static void addPersonIndivdual(){
        if (isFreeSpaceArray()) {
            System.out.println();
            addToArrayDataPersonIndivdual(returnIndexArrayNull(null),addPersonName(),addPersonSurname(),
                    addStreet(), addBuldingNumber(),addCity(), addZip(),addProvince(),addCountry(),
                    addNumberPhone());
            System.out.println("\n"+"Porces dodawania osoby indywidualnej do bazy zakończył się sukcesem!!!");
        } else{
            System.out.println("\n"+"Baza jest pełna i nie można dodać do niej nowej osoby!!!");
        }

    }

    //Metoda wywołująca dodanie danych do bazy firm
    public static void addCompany(){
        if (isFreeSpaceArray()) {
            System.out.println();
            addToArrayDataCompany(returnIndexArrayNull(null),addNameCompany(),addNipCompany(),
                    addStreet(), addBuldingNumber(),addCity(), addZip(),addProvince(),addCountry(),
                    addNumberPhone());
            System.out.println("\n"+"Porces dodawania firmy do bazy zakończył się sukcesem!!!");
        } else{
            System.out.println("\n"+"Baza jest pełna i nie można dodać do niej nowej firmy!!!");
        }

    }

    //Metoda zlicza liczbę osób indywidualnych w bazie
    private static int countPersonIndividual(){
        int counter = 0;
            for (UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
                if (temp instanceof Individual){
                    counter++;
                }
            }
            return counter;
    }

    //Metoda zlicza liczbę osób indywidualnych w bazie
    private static int countPersonIndividual(UserStructure[] tempolary){
        int counter = 0;
        for (UserStructure temp: tempolary){
            if (temp instanceof Individual){
                counter++;
            }
        }
        return counter;
    }


    //Metoda zlicza liczbę firm w bazie
    private static int countCorporation(UserStructure[] tempolary){
        int counter = 0;
        for (UserStructure temp: tempolary){
            if (temp instanceof Business){
                counter++;
            }
        }
        return counter;
    }

    //Metoda zlicza liczbę firm w bazie
    private static int countCorporation(){
        int counter = 0;
        for (UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if (temp instanceof Business){
                counter++;
            }
        }
        return counter;
    }

    //Metoda zlicza liczbę wpisów w bazie
    private static int count(UserStructure[] tempolary){
        int counter = 0;
        for (UserStructure temp: tempolary){
            if (temp !=null){
                counter++;
            }
        }
        return counter;
    }

    //Metoda usuwająca osobę indywidualną z bazy
    private static void deletePersonIndividual(int index){
        UserStructure[] tempolary = UserRepository.getUserRepository().getUserStructures();
        int i = 0;
        int counter = 0;
        for (UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if (temp instanceof Individual) {
                if (index == ++counter) {
                    tempolary[i] = null;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    //Metoda usuwająca firmę z bazy
    private static void deleteCorporation(int index){
        UserStructure[] tempolary = UserRepository.getUserRepository().getUserStructures();
        int i = 0;
        int counter = 0;
        for (UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if (temp instanceof Business) {
                if (index == ++counter) {
                    tempolary[i] = null;
                } else{
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    //Metoda sprawdzająca czy wprowadzono liczbę
    private static boolean isNumber(String indeks){
        boolean isnumber = false;
        for (int i=0; i < indeks.length(); i++){
            if ((indeks.charAt(i)>=48) && (indeks.charAt(i)<=57)){
                isnumber = true;
            }
            else{
                isnumber = false;
            }
        }
        return isnumber;
    }

    //Metoda obsługująca usuwanie danych osobu indywidualnej z bazy
    public static void supportingDeletePersonIndywidual(){
        String indeks;
        int counter;
        if ((counter=countPersonIndividual())!=0){
            System.out.print("Z wyświetlonej bazy wprowadź nr indeksu osby do usunięcia: ");
            if (isNumber(indeks=scannerLine()) && (Integer.parseInt(indeks)>0 && Integer.parseInt(indeks)<=counter)){
                deletePersonIndividual(Integer.parseInt(indeks));
                System.out.println("\n"+ "Usunięcie osoby z bazy zakończyło się sukcesem!!!"+"\n");
            } else{
                System.out.println("Wprowadzono niepoprawną wartość!!!");
                supportingDeletePersonIndywidual();
            }
        }
    }

    //Metoda obsługująca usuwanie danych firmy z bazy
    public static void supportingDeleteCorporation(){
        String indeks;
        int counter;
        if ((counter=countCorporation())!=0){
            System.out.print("Z wyświetlonej bazy wprowadź nr indeksu firmy do usunięcia: ");
            if (isNumber(indeks=scannerLine()) && (Integer.parseInt(indeks)>0 && Integer.parseInt(indeks)<=counter)){
                deleteCorporation(Integer.parseInt(indeks));
                System.out.println("\n"+ "Usunięcie firmy z bazy zakończyło się sukcesem!!!"+"\n");
            } else{
                System.out.println("Wprowadzono niepoprawną wartość!!!");
                supportingDeleteCorporation();
            }
        }
    }

    //Metoda wyszukująca i zwracająca wyszukany element/elemnty w bazie osób indywidualnych
    private static UserStructure[] databaseSearchPersonIndividual(String s) {
        UserStructure[] tempolary = new UserStructure[UserRepository.getUserRepository().getUserStructures().length];
        int i = 0;

        for(UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
             if ( temp instanceof  Individual && (temp != null && (((Individual) temp).getSurname().equals(s)))) {
                    tempolary[i++] = temp;
             }

        }
        return tempolary;
    }

    //Metoda wyświetlająca wyszukane elemnty
    private static void printFoundItems(UserStructure[] userStructure){
        int index= 0;
        for(UserStructure temp: userStructure){
            if (temp!=null) {
                writeIndex(++index);
                System.out.println(temp);
            }
        }
    }

    //Udostępnienie metod do wyświetlenia w interfejsie po znalezieniu osoby indyswidualnej
    public static void showFoundItemsPersonIndividual(){
        String s;
        if (countPersonIndividual(databaseSearchPersonIndividual(s=scannerLine()))!=0){
            System.out.println();
            showNameColumnsPersonIndividual();
            System.out.println();
            printFoundItems(databaseSearchPersonIndividual(s));
            System.out.println();
        } else{
            System.out.println();
            System.out.println("Baza jest pusta lub brak osób spełniających podane kryterium!!! Spróbuj jeszcze raz!!!");
            System.out.println();
        }

    }

    //Metoda wyszukująca i zwracająca wyszukany element/elemnty w bazie firm
    private static UserStructure[] databaseSearchCompany(String s) {
        UserStructure[] tempolary = new UserStructure[UserRepository.getUserRepository().getUserStructures().length];
        int i = 0;

        for(UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if ( temp instanceof  Business && (temp != null && (((Business) temp).getCompanyname().equals(s)))) {
                tempolary[i++] = temp;
            }

        }
        return tempolary;
    }

    //Udostępnienie metod do wyświetlenia w interfejsie po znalezieniu firmy
    public static void showFoundItemsCompany(){
        String s;
        if (countCorporation(databaseSearchCompany(s=scannerLine()))!=0){
            System.out.println();
            showNameColumnsCorporation();
            System.out.println();
            printFoundItems(databaseSearchCompany(s));
            System.out.println();
        } else{
            System.out.println();
            System.out.println("Baza jest pusta lub brak firm spełniających podane kryterium!!! Spróbuj jeszcze raz!!!");
            System.out.println();
        }

    }

    //Metoda wyszukująca i zwracająca wyszukany element/elemnty w bazie firm po nr telefonu
    private static UserStructure[] databaseSearchNumberPhone(String s) {
        UserStructure[] tempolary = new UserStructure[UserRepository.getUserRepository().getUserStructures().length];
        int i = 0;

        for(UserStructure temp: UserRepository.getUserRepository().getUserStructures()){
            if ( temp instanceof  Business && (temp != null && (((Business) temp).getNumberphone().equals(s)))) {
                tempolary[i++] = temp;
            }
            if ( temp instanceof  Individual && (temp != null && (((Individual) temp).getNumberphone().equals(s)))) {
                tempolary[i++] = temp;
            }
        }
        return tempolary;
    }

    public static void showFoundNumberPhone(){
        UserStructure[] temp = new UserStructure[UserRepository.getUserRepository().getUserStructures().length];

        if (count(temp = databaseSearchNumberPhone(scannerLine()))!=0){
            System.out.println("\n"+"----------------- Baza osób indywidualnych ----------------");
            showNameColumnsPersonIndividual();
            System.out.println();
            repositoryPersonIndywidual(temp);
            System.out.println("\n"+"------------------------ Baza firm ------------------------"+"\n");
            showNameColumnsCorporation();
            System.out.println();
            repositoryCorporation(temp);
            System.out.println();
        } else{
            System.out.println();
            System.out.println("Baza jest pusta lub brak numerów telefonów spełniających podane kryterium!!! " +
                    "Spróbuj jeszcze raz!!!");
            System.out.println();
        }

    }

}
