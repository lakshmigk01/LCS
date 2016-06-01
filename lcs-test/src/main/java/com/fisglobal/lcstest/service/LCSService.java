/**
 * 
 */
package com.fisglobal.lcstest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fisglobal.lcstest.model.LCSOutput;
import com.fisglobal.lcstest.model.Value;

/**
 * @author Lakshmi.Anantharaman
 * This logic for LCS uses Dynamic Programming Source is from Princeton University
 */
@Service
public class LCSService {

	public String computeLCS(String string1,String string2) {
		int M = string1.length();
        int N = string2.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (string1.charAt(i) == string2.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS 
        int i = 0, j = 0;
        StringBuilder output = new StringBuilder(); 
        while(i < M && j < N) {
            if (string1.charAt(i) == string2.charAt(j)) {
            	output.append(string1.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        
		return output.toString();
	}
	
	/**
	 * calculate LCS for all Values. 
	 * @param values
	 * @return LCSOutput 
	 */
	public  LCSOutput lcs(List<Value> values){
		
		if(values == null || values.isEmpty()) 
			throw new IllegalArgumentException("Input cannot be empty");
			
		Value[] arrayInput = values.toArray(new Value[0]);
		int i = 0; 
		String out = arrayInput[0].getValue();
		while(i < arrayInput.length-1){
			out = computeLCS(out, arrayInput[i++].getValue());
		}
		return new LCSOutput(out); 
	}
	
}
