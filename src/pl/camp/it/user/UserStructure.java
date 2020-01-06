package pl.camp.it.user;

public class UserStructure {

    private String street;
    private String buldingnumber;
    private String zip;
    private String city;
    private String province;
    private String country;
    private String numberphone;

    public UserStructure(String street, String buldingnumber, String zip, String city, String province, String country){
        this.street = street;
        this.buldingnumber = buldingnumber;
        this.zip = zip;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public UserStructure(String street, String buldingnumber, String zip, String city, String province, String country,
                         String numberphone) {
        this(street, buldingnumber, zip, city, province, country);
        this.numberphone = numberphone;
    }

    public String getStreet() {
        return street;
    }

    public String getBuldingnumber() {
        return buldingnumber;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuldingnumber(String buldingnumber) {
        this.buldingnumber = buldingnumber;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

}

