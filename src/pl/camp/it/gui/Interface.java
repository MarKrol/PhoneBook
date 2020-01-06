package pl.camp.it.gui;

import pl.camp.it.methods.Methods;

import java.util.Scanner;

public class Interface {

    private static void printMainMenu(){
        System.out.println("-------------------- PHONEBOOK --------------------");
        System.out.println("-------------------- Main Menu --------------------");
        System.out.println("1. Wyświetl nr telefonów znajdujące się w bazie .");
        System.out.println("2. Wszukaj wpis w bazie.");
        System.out.println("3. Dodaje numer telefonu do bazy.");
        System.out.println("4. Usuń numeru telefonu z bazy.");
        System.out.println("5. Informacje o programie.");
        System.out.println("6. Wyjście z programu.");
        System.out.println("---------------------------------------------------");
        System.out.print("\n"+"Wprowadź numer wybranej opcji Main Menu: ");
    }

    private static void printSubmenuMainMenuOption1(){
        System.out.println("-------------------- PHONEBOOK --------------------");
        System.out.println("--------------------  Submenu  --------------------");
        System.out.println("1. Wyświetl numery telefów osób indywidualnych.");
        System.out.println("2. Wyświetl numery telefonów firm.");
        System.out.println("3. Wyświetl wszystkie numery telefonów.");
        System.out.println("4. Powrót do Main Menu.");
        System.out.println("---------------------------------------------------");
        System.out.print("\n"+"Wprowadź numer wybranej opcji SubMenu: ");
    }

    private static void printSubmenuMainMenuOption2(){
        System.out.println("-------------------- PHONEBOOK --------------------");
        System.out.println("--------------------  Submenu  --------------------");
        System.out.println("1. Wyszukaj wpis po nazwisku.");
        System.out.println("2. Wyszukaj wpis po nazwie firmy.");
        System.out.println("3. Wyszukaj wpis po numerze telefonu.");
        System.out.println("4. Powrót do Main Menu.");
        System.out.println("---------------------------------------------------");
        System.out.print("\n"+"Wprowadź numer wybranej opcji SubMenu: ");
    }

    private static void printSubmenuMainMenuOption3(){
        System.out.println("-------------------- PHONEBOOK --------------------");
        System.out.println("--------------------  Submenu  --------------------");
        System.out.println("1. Dodaj numer telefonu osoby indywidualnej.");
        System.out.println("2. Dodaj numer telefonu danej firmy.");
        System.out.println("3. Powrót do Main Menu.");
        System.out.println("---------------------------------------------------");
        System.out.print("\n"+"Wprowadź numer wybranej opcji SubMenu: ");
    }

    private static void printSubmenuMainMenuOption4(){
        System.out.println("-------------------- PHONEBOOK --------------------");
        System.out.println("--------------------  Submenu  --------------------");
        System.out.println("1. Usuń numer telefonu osoby indywidualnej.");
        System.out.println("2. Usuń numer telefonu danej firmy.");
        System.out.println("3. Powrót do Main Menu.");
        System.out.println("---------------------------------------------------");
        System.out.print("\n"+"Wprowadź numer wybranej opcji SubMenu: ");
    }


    // Metoda obsługująca interfejs Main Menu
    private static void showMainMenu(){
        printMainMenu();
        switch(Methods.scannerLine()){
            case "1":
                System.out.println();
                showSubmenuMainMenuOption1();
                break;
            case "2":
                System.out.println();
                showSubmenuMainMenuOption2();
                break;
            case "3":
                System.out.println();
                showSubmenuMainMenuOption3();
            case "4":
                System.out.println();
                showSubmenuMainMenuOption4();
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("\n"+"Wprowadzono niepoprawną opcję!!! Dokonaj wyboru jeszcze raz!!!"+"\n");
                break;
        }
        showMainMenu();
    }

    // Metoda obsługująca interfejs wyświetlania
    private static void showSubmenuMainMenuOption1(){
        printSubmenuMainMenuOption1();
        switch(Methods.scannerLine()){
            case "1":
                Methods.showRepositoryPersonIndywidual();
                break;
            case "2":
                Methods.showRepositoryCorporation();
                break;
            case "3":
                Methods.showRepositoryPersonIndywidual();
                System.out.println();
                Methods.showRepositoryCorporation();
                System.out.println();
               break;
            case "4":
                showMainMenu();
                break;
            default:
                System.out.println("\n"+"Wprowadzono niepoprawną opcję!!! Dokonaj wyboru jeszcze raz!!!"+"\n");
                break;
        }
        showSubmenuMainMenuOption1();
    }

    // Metoda obsługująca interfejs wyświetlania
    private static void showSubmenuMainMenuOption2(){
        printSubmenuMainMenuOption2();
        switch(Methods.scannerLine()){
            case "1":
                System.out.println("");
                System.out.print("Podaj nazwisko: ");
                Methods.showFoundItemsPersonIndividual();
                break;
            case "2":
                System.out.println("");
                System.out.print("Podaj nazwę: ");
                Methods.showFoundItemsCompany();
                break;
            case "3":
                System.out.println("");
                System.out.print("Podaj numer telefonu: ");
                Methods.showFoundNumberPhone();
                break;
            case "4":
                showMainMenu();
                break;
            default:
                System.out.println("\n"+"Wprowadzono niepoprawną opcję!!! Dokonaj wyboru jeszcze raz!!!"+"\n");
                break;
        }
        showSubmenuMainMenuOption2();
    }

    // Metoda obsługująca interfejs dodawania do bazy
    private static void showSubmenuMainMenuOption3(){
        printSubmenuMainMenuOption3();
        switch(Methods.scannerLine()){
            case "1":
                Methods.addPersonIndivdual();
                System.out.println();
                break;
            case "2":
                Methods.addCompany();
                System.out.println();
                break;
            case "3":
                System.out.println();
                showMainMenu();
                break;
            default:
                System.out.println("\n"+"Wprowadzono niepoprawną opcję!!! Dokonaj wyboru jeszcze raz!!!"+"\n");
                break;
        }
        showSubmenuMainMenuOption3();
    }

    // Metoda obsługująca interfejs usuwania z bazy
    private static void showSubmenuMainMenuOption4(){
        printSubmenuMainMenuOption4();
        switch(Methods.scannerLine()){
            case "1":
                System.out.println();
                Methods.showRepositoryPersonIndywidual();
                Methods.supportingDeletePersonIndywidual();
                break;
            case "2":
                System.out.println();
                Methods.showRepositoryCorporation();
                Methods.supportingDeleteCorporation();
                break;
            case "3":
                showMainMenu();
                break;
            default:
                System.out.println("\n"+"Wprowadzono niepoprawną opcję!!! Dokonaj wyboru jeszcze raz!!!"+"\n");
                break;
        }
        showSubmenuMainMenuOption4();
    }

    // Metoda uruchamiająca cały interfejs
    public static void showPhoneBook(){
        showMainMenu();
    }

}
