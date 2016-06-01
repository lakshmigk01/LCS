/**
 * 
 */
package com.fisglobal.lcstest.controller;

import com.fisglobal.lcstest.model.LCSInput;
import com.fisglobal.lcstest.model.LCSOutput;
import com.fisglobal.lcstest.service.LCSService;

/**
 * @author Lakshmi.Anantharaman
 * This is a mock up Service class. 
 */
public class LCSStub {

	private static LCSInput input = new LCSInput();

	private static LCSOutput output = new LCSOutput("gard");

	static {
		input.addValue("sungard");
		input.addValue("sungardener");
		input.addValue("gardener");
		input.addValue("garden");
	}

	public static LCSInput list() {

		return input;
	}

	public static LCSOutput output() {

		return output;
	}

	public static LCSOutput lcs() {

		return new LCSService().lcs(input.getSetOfStrings());
	}
	
	
}
