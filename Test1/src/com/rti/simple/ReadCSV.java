// ****************************************************************************
//                           QUT Master of IT         
//                           IFN701 Project 1
//         Internet of Things DDS Protocol for Connected Vehicles
//                     by Wing Yin Vivian Lee n9004548
//
//                       Supervisor: Yanming Feng 
//                   Project Coordinator: Charles Wang
//                  
// ****************************************************************************

/* Introduction: this class is to read the vehicle information from a csv file*/

//DDS package
package com.rti.simple;

//java library
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.lang.Math;

public class ReadCSV {
	
	public static ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();// create a vehicle object array list

	    public static void read(String fileAddress) throws Exception {
	                String splitBy = ",";
	        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
	        String line = br.readLine();
	       
	      
	        while((line = br.readLine()) !=null){//read the data
	             String[] b = line.split(splitBy);
	           String min =b[2].substring(0,(b[2].lastIndexOf(":")));
	           //Brisbane Convention & Exhibition Centre (-27.476483,153.018374)
	           double distance = getDistance( -27.476483,153.018374,Double.parseDouble(b[3]),Double.parseDouble(b[4]));
	            //distance=0;
	             if (Double.parseDouble(min)<5 && distance<=5.0 )//within 5 mins & 2.0km 
	             {
	            	 Vehicle car = new Vehicle(Integer.parseInt(b[0]),b[1],b[2],Double.parseDouble(b[3]),Double.parseDouble(b[4]));
	            	 Vehicles.add(car);
	            	 
	             }else {
	            	 break;
	             }
	             
	        }
	        br.close();


	  }
	    
	    //calculate distance between 2 point with latitude and longitude 	
	    public static double getDistance(double lat1, double lon1, double lat2, double lon2){
	    	
	    	 final int R = 6378; // (km) radius of the earth
	    	 double latDistance = (lat1-lat2)*(2* Math.PI/360 *R);
	    	 //System.out.println(latDistance);
	    	 double lonDistance = (lon1-lon2)*(2* Math.PI/360 *R)*Math.cos((lat1+lat2)/2);
	    	 //System.out.println(lonDistance);
	    	 double distance = Math.sqrt(Math.pow(latDistance, 2)+Math.pow(lonDistance, 2));
	    	 return distance;
	    	
	    }
	    
	   
	    
	   public static ArrayList<Vehicle> csvdata() {   
	    	return Vehicles;
	    }
	    
	}