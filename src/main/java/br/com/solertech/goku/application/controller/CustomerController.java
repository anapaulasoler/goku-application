package br.com.solertech.goku.application.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.solertech.goku.application.request.CustomerRequest;
import br.com.solertech.goku.application.response.CustomerResponse;
import br.com.solertech.goku.application.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
@Validated
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody CustomerRequest request) {

    	LOGGER.info("stage=init method=CustomerController.create "
				+ "Message=Start Create Customer request: {} ", request);
    	
        CustomerResponse customerResponse = customerService.create(request);

    	LOGGER.info("stage=end method=CustomerController.create "
				+ "Message=Finish Create Customer response: {} ", customerResponse);
    	
        return new ResponseEntity<>(customerResponse, (HttpStatus.CREATED));
    }

}
