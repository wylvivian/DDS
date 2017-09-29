package com.rti.simple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.lang.Math;

public class ReadCSV {

   		//@SuppressWarnings("rawtypes")
	    public static void main(String[] args) throws Exception {
	                String splitBy = ",";
	        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vivian\\Documents\\GitHub\\DDS\\data.csv"));
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
	        
	      //Brisbane Convention & Exhibition Centre (-27.476483,153018374, )
	       // double k = getDistance(-27.476483,153018374,-27.479221, 153.012008);
        	//System.out.println(k);// should be less than 1 km ///PROBLEM: VERY LARGE NUMBER

	  }
	    
	    //calculate distance between 2 point with latitude and longitude 
	    public static double getDistance(double lat1, double lon1, double lat2, double lon2){
	    	
	    	 final int R = 6378; // (km) radius of the earth
	    	 double latDistance = (lat1-lat2)*(2* Math.PI/360 *R);
	    	 System.out.println(latDistance);
	    	 double lonDistance = (lon1-lon2)*(2* Math.PI/360 *R)*Math.cos((lat1+lat2)/2);
	    	 System.out.println(lonDistance);
	    	 double distance = Math.sqrt(Math.pow(latDistance, 2)+Math.pow(lonDistance, 2));
	    	 return distance;
	    }
	    
	    
	    
	    
	}