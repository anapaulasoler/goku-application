package br.com.solertech.goku.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solertech.goku.application.converter.CustomerRequestConverter;
import br.com.solertech.goku.application.converter.CustomerResponseConverter;
import br.com.solertech.goku.application.domain.Customer;
import br.com.solertech.goku.application.repository.CustomerRepository;
import br.com.solertech.goku.application.request.CustomerRequest;
import br.com.solertech.goku.application.response.CustomerResponse;
import br.com.solertech.goku.application.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerResponseConverter customerResponseConverter;
    private final CustomerRequestConverter customerRequestConverter;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository customerRepository,
                               final CustomerResponseConverter customerResponseConverter,
                               final CustomerRequestConverter customerRequestConverter) {
        this.customerRepository = customerRepository;
        this.customerResponseConverter = customerResponseConverter;
        this.customerRequestConverter = customerRequestConverter;
    }


    @Override
    public CustomerResponse create(CustomerRequest request) {

        Customer customer = customerRequestConverter.apply(request);
        customerRepository.save(customer);
        CustomerResponse response = customerResponseConverter.apply(customer);

        return response;
    }


}
