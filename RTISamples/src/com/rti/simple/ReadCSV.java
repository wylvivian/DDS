package com.rti.simple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ReadCSV {

   		//@SuppressWarnings("rawtypes")
	    public static void main(String[] args) throws Exception {
	                String splitBy = ",";
	        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vivian\\Documents\\GitHub\\DDS\\test_data.csv"));
	        String line = br.readLine();
	        ArrayList<Double> latitude = new ArrayList<Double>();
	        ArrayList<Double> longitude = new ArrayList<Double>();
	       
	      
	        while((line = br.readLine()) !=null){// read the data
	             String[] b = line.split(splitBy);
	           String min =b[2].substring(0,(b[2].lastIndexOf(":")));
	            
	             if (Double.parseDouble(min)<5)//within 5 mins
	             {
	            	 latitude.add(Double.parseDouble(b[3]));
		             longitude.add(Double.parseDouble(b[4]));
	            	 
	             }else {
	            	 break;
	             }
	             
	        }
	        br.close();
	        
	        for (int x = 0; x < latitude.size(); x++) {
	        	
	        	System.out.println("Record ("+x+") : Latitude-"+latitude.get(x)+" Longitude-"+longitude.get(x));
	        }
	        

	  }
	}