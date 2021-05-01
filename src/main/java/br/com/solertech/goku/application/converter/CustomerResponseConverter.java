package br.com.solertech.goku.application.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.solertech.goku.application.domain.Address;
import br.com.solertech.goku.application.domain.Customer;
import br.com.solertech.goku.application.response.AddressResponse;
import br.com.solertech.goku.application.response.CustomerResponse;

@Component
public class CustomerResponseConverter implements Function<Customer, CustomerResponse> {

    @Override
    public CustomerResponse apply(Customer customer) {

        CustomerResponse result = new CustomerResponse();

        result.withDocument(customer.getDocument());
        result.withFirstName(customer.getFirstName());
        result.withLastName(customer.getLastName());
        result.withAddressResponseList(generateAddressList(customer.getAddresses()));

        return result;
    }

   private List<AddressResponse> generateAddressList(List<Address> addressList){

	   
	   
       List<AddressResponse> addressResponseList = new ArrayList<>();
       
       for (Address address : addressList) {

           AddressResponse response = new AddressResponse();

           response.setNumber(address.getNumber());
           response.setStreet(address.getStreet());
           response.setZipcode(address.getZipcode());
           addressResponseList.add(response);
       }
       return addressResponseList;
    }
}
