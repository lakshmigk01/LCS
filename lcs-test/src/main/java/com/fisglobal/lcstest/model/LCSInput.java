package com.fisglobal.lcstest.model;

import java.util.ArrayList;
import java.util.List;

public class LCSInput {

	private List<Value> setOfStrings;

	public LCSInput() {

	}

	public List<Value> getSetOfStrings() {
		return setOfStrings;
	}

	public void addValue(String input) {
		if (setOfStrings == null) {
			setOfStrings = new ArrayList<Value>();
		}
		setOfStrings.add(new Value(input));
	}

}
