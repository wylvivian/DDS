package com.rti.simple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.lang.Math;

public class ReadCSV {
	
	public static ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
	public static ArrayList<Double> latitude = new ArrayList<Double>();
     public static ArrayList<Double> longitude = new ArrayList<Double>();
     public static Double t = 3.1456778666;

	    public static void read(String fileAddress) throws Exception {
	                String splitBy = ",";
	        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
	        String line = br.readLine();
	       
	       
	      
	        while((line = br.readLine()) !=null){// read the data
	             String[] b = line.split(splitBy);
	           String min =b[2].substring(0,(b[2].lastIndexOf(":")));
	            
	             if (Double.parseDouble(min)<5)//within 5 mins
	             {
	            	 Vehicle car = new Vehicle(Integer.parseInt(b[0]),b[2],Double.parseDouble(b[3]),Double.parseDouble(b[4]));
	            	 Vehicles.add(car);
	            	 
	             }else {
	            	 break;
	             }
	             
	        }
	        br.close();
	        
	        
	        for (int x = 0; x < Vehicles.size(); x++) {
	        	
	        	
	        	System.out.println("Record ("+x+") - id: "+Vehicles.get(x).id +" time:"+Vehicles.get(x).time+" latitude:" + Vehicles.get(x).lat+" longitude:"+Vehicles.get(x).lon);
	        }
	        
	      //Brisbane Convention & Exhibition Centre (-27.476483,153018374, )
	       //double k = getDistance(-27.476483,153018374,-27.479221, 153.012008);
        	//System.out.println(k);// should be less than 1 km ///PROBLEM: VERY LARGE NUMBER

	  }
	    
	    //calculate distance between 2 point with latitude and longitude 
	    //within 2 km
	    public static double getDistance(double lat1, double lon1, double lat2, double lon2){
	    	
	    	 final int R = 6378; // (km) radius of the earth
	    	 double latDistance = (lat1-lat2)*(2* Math.PI/360 *R);
	    	 System.out.println(latDistance);
	    	 double lonDistance = (lon1-lon2)*(2* Math.PI/360 *R)*Math.cos((lat1+lat2)/2);
	    	 System.out.println(lonDistance);
	    	 double distance = Math.sqrt(Math.pow(latDistance, 2)+Math.pow(lonDistance, 2));
	    	 return distance;
	    }
	    
	    
	   public static ArrayList<Vehicle> csvdata() {   
		// Double num = latitude.get(0);
	    //String text = Double.toString(num);
	    	return Vehicles;
	    }
	    
	}