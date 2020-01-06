package pl.camp.it.user;

import java.util.Formatter;

public class Individual extends UserStructure {

    private String name;
    private String surname;

    public Individual(String street, String buldingnumber, String zip, String city, String province,
                      String country, String numberphone, String name, String surname){

        super(street, buldingnumber, zip, city, province, country, numberphone);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString(){
        Formatter formatter = new Formatter(new StringBuilder());

        formatter.format("%-8s %-25s %-30s %-35s %-10s %-30s %-10s %-40s %-35s %-25s","", getName(), getSurname(),
                getStreet(), getBuldingnumber(), getCity(), getZip(), getProvince(), getCountry(),
                getNumberphone());

        return  formatter.toString();
    }
}
