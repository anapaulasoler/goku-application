package br.com.solertech.goku.application.service;


import br.com.solertech.goku.application.domain.Address;
import br.com.solertech.goku.application.request.AddressRequest;
import br.com.solertech.goku.application.response.AddressResponse;

public interface AddressService {

    Address findByZipcode(String zipcode);

    AddressResponse createAddress(AddressRequest request, String document);

}
