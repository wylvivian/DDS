package com.rti.simple;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {

   		@SuppressWarnings("rawtypes")
	    public static void main(String[] args) throws Exception {
	                String splitBy = ",";
	        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vivian\\Documents\\GitHub\\DDS\\test_data.csv"));
	        String line = br.readLine();
	        double[] latitude = new double[101];
	        double[] longitude = new double[101];
	        int i= 0;
	        while((line = br.readLine()) !=null){
	             String[] b = line.split(splitBy);
	             latitude[i] = Double.parseDouble(b[3]);
	             longitude[i] = Double.parseDouble(b[4]);
	             i++;
	        }
	        br.close();
	        for (int x = 0; x < i; x++) {
	        	
	        	System.out.println("Record ("+x+") : Latitude-"+latitude[x]+" Longitude-"+longitude[x]);
	        }
	        

	  }
	}