package com.fisglobal.lcstest.model;

public class LCSOutput {

	private Value lcs;

	
	public LCSOutput(String lcs) {
		this.lcs = new Value(lcs);
	}

	public Value getLcs() {
		return lcs;
	}

	public void setLcs(Value lcs) {
		this.lcs = lcs;
	}

}
