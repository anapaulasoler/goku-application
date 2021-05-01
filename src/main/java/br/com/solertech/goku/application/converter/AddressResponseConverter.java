package br.com.solertech.goku.application.converter;

import br.com.solertech.goku.application.domain.Address;
import br.com.solertech.goku.application.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class AddressResponseConverter implements Function<Address, AddressResponse> {

    @Override
    public AddressResponse apply(Address address) {

        AddressResponse addressResponseResult = new AddressResponse();

        addressResponseResult.withNumber(address.getNumber());
        addressResponseResult.withZipcode(address.getZipcode());
        addressResponseResult.withStreet(address.getStreet());

        return addressResponseResult;
    }
}
