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

/* Introduction: this class is to construct the vehicle object*/

//DDS package
package com.rti.simple;

public class Vehicle {

		public int id;
		public String status;
	    public String time;
	    public double lat;
	    public double lon;
	    

	    // constructors
	    public Vehicle() {
	    	
	    }
	    
	    public Vehicle(int v_id, String v_status, String v_time, double v_lat, double v_lon) {
	        id = v_id;
	        status = v_status;
	        time = v_time;
	        lat = v_lat;
	        lon = v_lon;
	    }


	   
}
