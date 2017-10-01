package com.rti.simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteCSV {

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
        
        for (int x=0; x<carList.size() ;x++) {
        	
  
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
        System.out.println("done!");
    }
}
