package br.com.solertech.goku.application.response;

import java.util.List;

public class CustomerResponse  {

    private String document;
    private String firstName;
    private String lastName;
    private List<AddressResponse> addressResponseList;

    public CustomerResponse withDocument(String document) {
        this.document = document;
        return this;
    }

    public CustomerResponse withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerResponse withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerResponse withAddressResponseList(List<AddressResponse> addressResponseList) {
        this.addressResponseList = addressResponseList;
        return this;
    }


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AddressResponse> getAddressResponseList() {
        return addressResponseList;
    }

    public void setAddressResponseList(List<AddressResponse> addressResponseList) {
        this.addressResponseList = addressResponseList;
    }
}
