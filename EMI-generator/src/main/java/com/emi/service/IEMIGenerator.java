package com.emi.service;

import com.emi.response.EMIGenerateResponse;

public interface IEMIGenerator {

	public EMIGenerateResponse generateEMI(float principleAmount, float rate, int year);

}
