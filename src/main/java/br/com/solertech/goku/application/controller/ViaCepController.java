package br.com.solertech.goku.application.controller;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.solertech.goku.application.domain.AddressTo;
import br.com.solertech.goku.application.exceptions.ObjectNotFoundException;

@RestController
public class ViaCepController implements Serializable {

	private static final long serialVersionUID = 5567440893188947620L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ViaCepController.class);
	
	private final String URI = "http://viacep.com.br/ws/{cep}/json/";

	@GetMapping(value = "/getCep/{cep}")
	public ResponseEntity<AddressTo> doGetCep(@PathVariable(name = "cep") String zipcode) {
		
		LOGGER.info("stage=init method=ViaCepController.doGetCep "
				+ "Message=Start Find Zipcode request: {} ", zipcode);
		
		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", zipcode);

		AddressTo addressTo = restTemplate.getForObject(URI, AddressTo.class, params);
		
		LOGGER.info("stage=info method=ViaCepController.doGetCep "
				+ "Message=Finish Find Zipcode response: {} ", addressTo);
		

		if (isNull(addressTo.getCep())) {
			LOGGER.info("stage=end method=ViaCepController.doGetCep "
					+ "Message=Address Not Found response: {} ", addressTo);
			throw new ObjectNotFoundException("Endereço não localizado!");
		}

		return new ResponseEntity<AddressTo>(addressTo, HttpStatus.OK);

	}

}