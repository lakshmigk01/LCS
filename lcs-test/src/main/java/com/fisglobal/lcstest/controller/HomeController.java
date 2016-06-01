/**
 * 
 */
package com.fisglobal.lcstest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lakshmi.Anantharaman
 *
 */
@RestController 
public class HomeController {

	@RequestMapping("/")
	public String home(){
		return " This is an application for returning the LCS (Longest Common SubString)";
	}
	

}
