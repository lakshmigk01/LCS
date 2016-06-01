package com.fisglobal.lcstest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.lcstest.model.LCSInput;
import com.fisglobal.lcstest.model.LCSOutput;
import com.fisglobal.lcstest.service.LCSService;

@RestController
@RequestMapping("api/v1")
public class LCSController {

	@Autowired
	LCSService service;
	
	@RequestMapping(value = "lcsin", method = RequestMethod.GET)
	public LCSInput list() {
		return LCSStub.list();
	}

	@RequestMapping(value = "lcsout", method = RequestMethod.GET)
	public LCSOutput output() {
		return LCSStub.output();
	}

	@RequestMapping(value = "lcs", method = RequestMethod.GET)
	public LCSOutput lcs() {
		return LCSStub.lcs();
	}

	@RequestMapping(value = "lcs", method = RequestMethod.POST)
	public LCSOutput lcs(@Valid @RequestBody LCSInput input) {
		return service.lcs(input.getSetOfStrings());
	}
}
