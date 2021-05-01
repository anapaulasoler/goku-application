package br.com.solertech.goku.application.response;

public class AddressResponse{

    private String zipcode;

    private String street;

    private String number;

    public AddressResponse withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public AddressResponse withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressResponse withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
