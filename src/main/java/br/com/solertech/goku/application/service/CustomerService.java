package br.com.solertech.goku.application.service;


import br.com.solertech.goku.application.request.CustomerRequest;
import br.com.solertech.goku.application.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse create(CustomerRequest request );


}
