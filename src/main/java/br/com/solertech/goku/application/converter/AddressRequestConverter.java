package br.com.solertech.goku.application.converter;

import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import br.com.solertech.goku.application.domain.Address;
import br.com.solertech.goku.application.domain.Customer;
import br.com.solertech.goku.application.enums.Country;
import br.com.solertech.goku.application.enums.State;
import br.com.solertech.goku.application.request.AddressRequest;

@Component
public class AddressRequestConverter implements BiFunction<AddressRequest, Customer, Address> {
	@Override
	public Address apply(AddressRequest address, Customer customer) {

		Address result = new Address();

		result.setZipcode(address.getZipcode());
		result.setStreet(address.getStreet());
		result.setNumber(address.getNumber());
		result.setComplement(address.getComplement());
		result.setNeighborhood(address.getNeighborhood());
		result.setCity(address.getCity());
		result.setState(State.valueOf(address.getState()));
		result.setCountry(Country.valueOf(address.getCountry()));
		result.setCustomer(customer);

		return result;

	}

}
