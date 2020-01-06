package pl.camp.it.user;

import java.util.Formatter;

public class Business extends UserStructure {

    private String companyname;
    private String nipcompany;

    public Business (String street, String buldingnumber, String zip, String city, String province,
                     String country, String numberphone, String companyname, String nipcompany) {

        super(street, buldingnumber, zip, city, province, country, numberphone);
        this.companyname = companyname;
        this.nipcompany = nipcompany;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getNipcompany() {
        return nipcompany;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setNipcompany(String nipcompany) {
        this.nipcompany = nipcompany;
    }

    @Override
    public String toString(){
        Formatter formatter = new Formatter(new StringBuilder());

        formatter.format("%-8s %-35s %-20s %-35s %-10s %-30s %-10s %-40s %-35s %-25s","", getCompanyname(),
                getNipcompany(), getStreet(), getBuldingnumber(), getCity(), getZip(), getProvince(),
                getCountry(), getNumberphone());

        return  formatter.toString();
    }
}
