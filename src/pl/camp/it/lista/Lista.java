package pl.camp.it.lista;

import pl.camp.it.methods.Methods;
import pl.camp.it.user.Business;
import pl.camp.it.user.Individual;
import pl.camp.it.user.UserStructure;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista {
    Methods methods = new Methods();

    ArrayList<UserStructure> phonebook = new ArrayList<>();

    public Lista(){
        phonebook.add(new Individual("Fredry", "34a", "36040", "Kraków",
                "małopolskie", "Polska","+4812123456789",
                "Michał", "Gac"));
        phonebook.add(new Business("Point","21c", "31416", "Nowy Jork",
                "Nowy Jork","USA","+12334565453333","Construction LI",
                "PL4566722222"));
        phonebook.add(new Individual("Mała", "34a", "36040", "Kraków",
                "małopolskie", "Polska","+4812123456789",
                "Zenek", "Gac"));
        phonebook.add(new Business("Point","21c", "31416", "Chicago",
                "Illinois","USA","+12334565453334","Construction LI",
                "PL4566722222"));
    }

    //Dodaje osobę indywidualną do bazy
    public void addDataIndywidualne(){
        phonebook.add(methods.dataToListIndividual());
    }

    //Dodaje firmę do bazy
    public void addDataBusiness(){
        phonebook.add(methods.dataToListBusiness());
    }

    //Metoda zlicza liczbę osób indywidualnych w liście
    private int counterPersonIndividual(){
        int counter = 0;
        for (UserStructure temp: phonebook){
            if (temp instanceof Individual){
                counter++;
            }
        }
        return counter;
    }

    //Metoda zlicza liczbę firm w liście
    private int counterBusiness(){
        int counter = 0;
        for (UserStructure temp: phonebook){
            if (temp instanceof Business){
                counter++;
            }
        }
        return counter;
    }

    //Metoda wypisująca zawartość listy dla osób indywidualnych
    private void printIndividualList(){
        int index=0;
        if ((phonebook.isEmpty()) || (counterPersonIndividual()==0)){
            System.out.println("\nKsiążka telefoniczna dla osób indywidualnych jest pusta\n");
        } else {
            System.out.println();
            for (UserStructure temp: phonebook) {
                if (temp instanceof Individual) {
                    System.out.println(++index+". "+temp);
                }
            }
        }
    }

    //Metoda wypisująca zawartość listy dla firm
    private void printBusinessList(){
        int index=0;
        if ((phonebook.isEmpty() || (counterBusiness()==0))){
            System.out.println("\nKsiążka telefoniczna dla firm jest pusta\n");
        } else {
            System.out.println();
            for (UserStructure temp: phonebook) {
                if (temp instanceof Business) {
                    System.out.println(++index+". "+temp);
                }
            }
        }
    }

    //Metoda wyświetlająca znalezione wpisy w liście odób indywidualnych
    public void showIndividual(){
        System.out.println("\n"+"----------------- Baza osób indywidualnych ----------------");
        Methods.showNameColumnsPersonIndividual();
        printIndividualList();
        System.out.println();
    }

    //Metoda wyświetlająca znalezione wpisy w bazie firm
    public void showBusiness(){
        System.out.println("\n"+"------------------------ Baza firm ------------------------"+"\n");
        Methods.showNameColumnsCorporation();
        printBusinessList();
        System.out.println();
    }

    //Metoda wyświetlająca wszystkich indywidualnych
    public void findAllIndividual(){
        int index=0;
        Methods.showNameColumnsPersonIndividual();
        System.out.println();
        for(UserStructure temp: phonebook){
            if ((!phonebook.isEmpty()) && (temp instanceof Individual)){
                System.out.println(++index+". "+temp);
            }
        }
        if (index == 0){
            System.out.println("Nie znaleziono obiektu w bazie lub baza jest pusta!!!");
        }
    }

    //Metoda wyświetlająca wszystkie firmy
    public void findAllBusiness(){
        int index=0;
        Methods.showNameColumnsCorporation();
        System.out.println();
        for(UserStructure temp: phonebook){
            if ((!phonebook.isEmpty()) && (temp instanceof Business)){
                System.out.println(++index+". "+temp);
            }
        }
        if (index == 0){
            System.out.println("Nie znaleziono obiektu w bazie lub baza jest pusta!!!");
        }
    }

    //Wyszukuje osobę po nazwisku
    public void findIndividual(String s, int i){
        int index=0;
        Methods.showNameColumnsPersonIndividual();
        System.out.println();
        for(UserStructure temp: phonebook){
            if ((!phonebook.isEmpty()) && (temp instanceof Individual) && (optionFind(temp, i).equals(s))){
                System.out.println(++index+". "+temp);
            }
        }
        if (index == 0){
            System.out.println("Nie znaleziono obiektu w bazie lub baza jest pusta!!!");
        }
    }

    //Metoda wyszukuje firmę po nazwie
    public void findBusiness(String s, int i){
        int index=0;
        Methods.showNameColumnsCorporation();
        System.out.println();
        for(UserStructure temp: phonebook){
            if ((!phonebook.isEmpty()) && (temp instanceof Business) && (optionFind(temp,i).equals(s))){
                System.out.println(++index+". "+temp);
            }
        }
        if (index == 0){
            System.out.println("Nie znaleziono obiektu w bazie lub baza jest pusta!!!");
        }
    }

    //Metoda zwracająca po czym wyszukujemy w liście
    private String optionFind(UserStructure temp, int i){
        String s="";
        switch(i){
            //szukanie indywidualnej osoby po nazwisku
            case 1:
                s=((Individual) temp).getSurname();
                break;
            case 2:
                //szukanie po nazwie firmy
                s=((Business) temp).getCompanyname();
                break;
            case 3:
                //szukanie po nr telefonu indywidualnej osoby
                s=((Individual) temp).getNumberphone();
                break;
            case 4:
                //szukanie po nr telefonu firmy
                s=((Business) temp).getNumberphone();
                break;
        }
        return s;
    }

    public void deleteIndividualIndex(String s){
        int countI=0;
        try {
            if (!phonebook.isEmpty() && counterIndividual() != 0) {
                for (Iterator<UserStructure> it = phonebook.iterator(); it.hasNext(); ) {
                    UserStructure temp=it.next();
                    //for (UserStructure temp : phonebook) {
                    if ((temp instanceof Individual)) {
                        if (Integer.parseInt(s) == ++countI) {
                            it.remove();
                            System.out.println("Element został usunięty z bazy!!!");
                        }
                    }
                }
                }
            else {
                System.out.println("W bazie nie ma elemtów do usunięcia!!!");
            }
        }
        catch (NumberFormatException e){
            System.out.println("\nPodana wartość nie jest liczbą lub jest spoza zakresu bazy.");
            System.out.print("\nPodaj nr indeksu do usunięcia: ");
            deleteIndividualIndex(Methods.scannerLine());
        }
    }

    private int counterIndividual(){
        int counter=0;
        for(UserStructure temp: phonebook){
            if (temp instanceof Individual) {
                counter++;
            }
        }
        return counter;
    }

    public void deleteBusinessIndex(String s){
        int countI=0;
        try {
            if (!phonebook.isEmpty() && counterBusines() != 0) {
                for (Iterator<UserStructure> it = phonebook.iterator(); it.hasNext(); ) {
                    UserStructure temp=it.next();
                    //for (UserStructure temp : phonebook) {
                    if ((temp instanceof Business)) {
                        if (Integer.parseInt(s) == ++countI) {
                            it.remove();
                            System.out.println("Element został usunięty z bazy!!!");
                        }
                    }
                }
            }
            else {
                System.out.println("W bazie nie ma elemtów do usunięcia!!!");
            }
        }
        catch (NumberFormatException e){
            System.out.println("\nPodana wartość nie jest liczbą lub jest spoza zakresu bazy.");
            System.out.print("\nPodaj nr indeksu do usunięcia: ");
            deleteBusinessIndex(Methods.scannerLine());
        }
    }

    private int counterBusines(){
        int counter=0;
        for(UserStructure temp: phonebook){
            if (temp instanceof Business) {
                counter++;
            }
        }
        return counter;
    }

}
