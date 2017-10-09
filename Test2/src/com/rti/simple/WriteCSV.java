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

/* Introduction: this class is to write the vehicle array list into a csv file*/

//DDS package
package com.rti.simple;

//java library
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteCSV {
	
	// write the attribute
	public static void write(ArrayList<Vehicle> carList, String fileName) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(fileName));
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(',');
        sb.append("Status");
        sb.append(',');
        sb.append("Time");
        sb.append(',');
        sb.append("Latitude");
        sb.append(',');
        sb.append("Longitude");
        sb.append('\n');
        
        //write in data
        for (int x=0; x<carList.size() ;x++) {//go through each vehicle in the array list
        	
        sb.append(carList.get(x).id);
        sb.append(',');
        sb.append(carList.get(x).status);
        sb.append(',');
        sb.append(carList.get(x).time);
        sb.append(',');
        sb.append(carList.get(x).lat);
        sb.append(',');
        sb.append(carList.get(x).lon);
        sb.append('\n');
        	
        	
        }
        

        pw.write(sb.toString());
        pw.close();
        
    }
}
