package com.imaginea.amazontask;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public  class Retry implements IRetryAnalyzer {
        
	
		 
	    private int count = 0;
	    private static int maxTry = 2;
	    @Test
	    public boolean retry(ITestResult iTestResult) {
	        if (!iTestResult.isSuccess()) {                      
	            if (count < maxTry) {                            
	                count++;                                     
	                iTestResult.setStatus(ITestResult.FAILURE);  
	                return true;
	            } else {
	                iTestResult.setStatus(ITestResult.FAILURE);  
	            }
	        } else {
	            iTestResult.setStatus(ITestResult.SUCCESS);      
	        }
	        return false;
	    }
	 
	}


