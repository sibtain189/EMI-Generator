package com.emi.service.impl;

import org.springframework.stereotype.Service;

import com.emi.response.EMIGenerateResponse;
import com.emi.service.IEMIGenerator;

@Service
public class EMIGenerator implements IEMIGenerator {

	@Override
	public EMIGenerateResponse generateEMI(float principleAmount, float rate, int year) {

		rate = rate / (12 * 100);
		int tenure = year * 12;

		int calculatedEMI = (int) ((principleAmount * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1));

		float amountPay=  (calculatedEMI*tenure);
        float interestPay =  (amountPay-principleAmount);
		
        EMIGenerateResponse emiGenerateResponse = new EMIGenerateResponse();
        
        emiGenerateResponse.setCalculatedEMI(calculatedEMI);
        emiGenerateResponse.setInterestPayble(interestPay);
        emiGenerateResponse.setAmountPayble(amountPay);
        
		return emiGenerateResponse;
	}

}
