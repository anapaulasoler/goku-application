package br.com.solertech.goku.application.service.impl;

import static java.util.Objects.isNull;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solertech.goku.application.converter.AddressRequestConverter;
import br.com.solertech.goku.application.converter.AddressResponseConverter;
import br.com.solertech.goku.application.domain.Address;
import br.com.solertech.goku.application.domain.Customer;
import br.com.solertech.goku.application.exceptions.ObjectNotFoundException;
import br.com.solertech.goku.application.repository.AddressRepository;
import br.com.solertech.goku.application.repository.CustomerRepository;
import br.com.solertech.goku.application.request.AddressRequest;
import br.com.solertech.goku.application.response.AddressResponse;
import br.com.solertech.goku.application.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private AddressResponseConverter addressResponseConverter;
	private AddressRequestConverter addressRequestConverter;
	private CustomerRepository customerRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, AddressResponseConverter addressResponseConverter,
			AddressRequestConverter addressRequestConverter, CustomerRepository customerRepository) {
		this.addressRepository = addressRepository;
		this.addressResponseConverter = addressResponseConverter;
		this.addressRequestConverter = addressRequestConverter;
		this.customerRepository = customerRepository;
	}

	@Override
	public Address findByZipcode(String zipcode) {
		Optional<Address> address = addressRepository.findByZipcode(zipcode);
		return address.orElseThrow(() -> new ObjectNotFoundException("Endereço não localizado!"));
	}

	@Override
	public AddressResponse createAddress(AddressRequest request, String document) {

		Customer customer = customerRepository.findByDocument(document);

		if (isNull(customer)) {
			throw new ObjectNotFoundException("Cliente não localizado!");
		}

		Address address = addressRequestConverter.apply(request, customer);
		addressRepository.save(address);
		return addressResponseConverter.apply(address);
	}
}
