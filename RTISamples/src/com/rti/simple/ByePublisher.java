// ****************************************************************************
//         (c) Copyright, Real-Time Innovations, All rights reserved.       
//                                                                          
//         Permission to modify and use for internal purposes granted.      
// This software is provided "as is", without warranty, express or implied. 
//                                                                  
//           Modified by Wing Yin Vivian Lee , QUT
//
// ****************************************************************************


package com.rti.simple;

import java.io.IOException;
import java.util.ArrayList;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.InstanceHandle_t;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.publication.Publisher;
import com.rti.dds.topic.Topic;
import com.rti.dds.type.builtin.StringDataWriter;
import com.rti.dds.type.builtin.StringTypeSupport;

//****************************************************************************
public class ByePublisher {
    public static final void main(String[] args) throws IOException {
        // Create the DDS Domain participant on domain ID 0
        DomainParticipant participant = DomainParticipantFactory.get_instance().create_participant(
                0, // Domain ID = 0
                DomainParticipantFactory.PARTICIPANT_QOS_DEFAULT, 
                null, // listener
                StatusKind.STATUS_MASK_NONE);
        if (participant == null) {
            System.err.println("Unable to create domain participant");
            return;
        }

        // Create the topic "Hello World" for the String type
        Topic topic = participant.create_topic(
                 "Bye, World", 
                StringTypeSupport.get_type_name(), 
                DomainParticipant.TOPIC_QOS_DEFAULT, 
                null, // listener
                StatusKind.STATUS_MASK_NONE);
        if (topic == null) {
            System.err.println("Unable to create topic.");
            return;
        }

        // Create the data writer using the default publisher
        StringDataWriter dataWriter =
            (StringDataWriter) participant.create_datawriter(
                topic, 
                Publisher.DATAWRITER_QOS_DEFAULT,
                null, // listener
                StatusKind.STATUS_MASK_NONE);
        if (dataWriter == null) {
            System.err.println("Unable to create data writer\n");
            return;
        }

        
        System.out.println("Ready to write data.");
        System.out.println("When the subscriber is ready, you can start writing.");
        System.out.print("Press CTRL+C to terminate or enter an empty line to do a clean shutdown.\n\n");

       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
       // String toWrite = "123";
        
       // System.out.println("Exiting...");
        
        //array list 
        try {
			ReadCSV.read("C:\\Users\\Vivian\\Documents\\GitHub\\DDS\\RTISamples\\1.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<Vehicle> CarList = ReadCSV.csvdata();

        	while(CarList.get(0) != null) {
        		
        		 for (int x = 0; x < CarList.size(); x++) {
        			 String text = Integer.toString(CarList.get(x).id)+"/"+ CarList.get(x).status+"/"+CarList.get(x).time+"/"+ Double.toString(CarList.get(x).lat)+"/"+ Double .toString(CarList.get(x).lon);
      
        			 dataWriter.write(text, InstanceHandle_t.HANDLE_NIL);
        		
        		 }
        		break;
        		
        	}
        	
        
       /* 
        
        try {
            while (true) {
                System.out.print("Please type a message> ");
                
               String toWrite =  reader.readLine();
                if (toWrite == null) break;     // shouldn't happen
                dataWriter.write(toWrite, InstanceHandle_t.HANDLE_NIL);
                if (toWrite.equals("")) break;
            }
        } catch (IOException e) {
            // This exception can be thrown from the BufferedReader class
            e.printStackTrace();
        } catch (RETCODE_ERROR e) {
            // This exception can be thrown from DDS write operation
            e.printStackTrace();
        }

        System.out.println("Exiting...");
        participant.delete_contained_entities();
        DomainParticipantFactory.get_instance().delete_participant(participant);
    }*/
}
}