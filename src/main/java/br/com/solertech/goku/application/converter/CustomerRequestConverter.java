package br.com.solertech.goku.application.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.solertech.goku.application.domain.Address;
import br.com.solertech.goku.application.domain.Customer;
import br.com.solertech.goku.application.enums.Country;
import br.com.solertech.goku.application.enums.CustomerStatus;
import br.com.solertech.goku.application.enums.Gender;
import br.com.solertech.goku.application.enums.State;
import br.com.solertech.goku.application.request.AddressRequest;
import br.com.solertech.goku.application.request.CustomerRequest;
import br.com.solertech.goku.application.util.UtilDateFormat;

@Component
public class CustomerRequestConverter  implements Function<CustomerRequest, Customer> {

	@Autowired
	private UtilDateFormat utilDateFormat;
	
    @Override
    public Customer apply(CustomerRequest customerRequest) {
    	
    
    	
        Customer customerNew = new Customer();
        customerNew.setDocument(customerRequest.getDocument());
        customerNew.setGender(Gender.valueOf(customerRequest.getGender().name()));
        customerNew.setEmail(customerRequest.getEmail());
        customerNew.setFirstName(customerRequest.getFirstName());
        customerNew.setLastName(customerRequest.getLastName());
        customerNew.setFullName(customerRequest.getFullName());
        customerNew.setBirthDate(utilDateFormat.dateConverter(customerRequest.getBirthDate()));
        
        customerNew.setStatus(CustomerStatus.ACTIVE);
        
        List<Address> addressList = new ArrayList<>();

        List<AddressRequest> addressRequest = customerRequest.getAddress().stream().distinct().collect(Collectors.toList());

        for (AddressRequest addresses: addressRequest) {

            Address addressItem = new Address();

            addressItem.setCustomer(customerNew);
            addressItem.setZipcode(addresses.getZipcode());
            addressItem.setStreet(addresses.getStreet());
            addressItem.setNumber(addresses.getNumber());
            addressItem.setComplement(addresses.getComplement());
            addressItem.setNeighborhood(addresses.getNeighborhood());
            addressItem.setCity(addresses.getCity());
            addressItem.setState(State.valueOf(addresses.getState()));
            addressItem.setCountry(Country.valueOf(addresses.getCountry()));

            addressList.add(addressItem);

        }
        customerNew.setAddresses(addressList);

        return customerNew;
    }
}