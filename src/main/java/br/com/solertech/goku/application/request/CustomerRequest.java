package br.com.solertech.goku.application.request;

import br.com.solertech.goku.application.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class CustomerRequest {

    @NotEmpty(message= "Documento precisa ser informado")
	@Length(min=8,max=9, message="O Campo deve conter entre 8 e 9 caracteres")
    private String document;

    @NotEmpty(message= "Documento precisa ser informado")
	@Length(min=2,max=20, message="O Campo deve conter entre 8 e 9 caracteres")
    private String firstName;

    @NotEmpty(message= "Documento precisa ser informado")
	@Length(max=30, message="O Campo deve conter entre 8 e 9 caracteres")
    private String lastName;

    @NotBlank
    private String fullName;

    @NotBlank
    private String email;

    @NotNull
    private Gender gender;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String birthDate;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Valid
    @JsonProperty
    @NotNull
    private List<AddressRequest> address;

    
    public List<AddressRequest> getAddress() {
        return address;
    }

    public void setAddressRequestList(List<AddressRequest> address) {
        this.address = address;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
