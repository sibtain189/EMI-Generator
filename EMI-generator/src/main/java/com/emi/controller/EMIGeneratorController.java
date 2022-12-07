package com.emi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.emi.dto.EMIDTO;
import com.emi.response.EMIGenerateResponse;
import com.emi.service.impl.EMIGenerator;

@RestController
public class EMIGeneratorController {

	@Autowired
	private EMIGenerator emiGenerator;

	// generate EMI and show the result
	@PostMapping("/generate-emi")
	public EMIGenerateResponse generateEMIHandler(@RequestBody EMIDTO emidto) {

		EMIGenerateResponse getEmi = emiGenerator.generateEMI(emidto.getPrincipleAmount(), emidto.getRate(),
				emidto.getYear());

		EMIGenerateResponse emiGenerateResponse = new EMIGenerateResponse();

		emiGenerateResponse.setCalculatedEMI(getEmi.getCalculatedEMI());
		emiGenerateResponse.setInterestPayble(getEmi.getInterestPayble());
		emiGenerateResponse.setAmountPayble(getEmi.getAmountPayble());

		return emiGenerateResponse;

	}

}
