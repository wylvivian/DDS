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

/* Introduction: this class is to publish the "topic A" data by read data from a csv file*/

//DDS package
package com.rti.simple;

//java library for reading csv
import java.io.IOException;
import java.util.ArrayList;

//DDS library
import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.InstanceHandle_t;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.publication.Publisher;
import com.rti.dds.topic.Topic;
import com.rti.dds.type.builtin.StringDataWriter;
import com.rti.dds.type.builtin.StringTypeSupport;

//****************************************************************************
public class APublisher {
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

        // Create the topic "Topic A" for the String type
        Topic topic = participant.create_topic(
                "Topic A", 
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
        //subscriber of "Topic A" needs to subscribe first
        System.out.println("When the subscriber is ready, you can start writing.");
 
        //read the data in csv file to the format of vehicle object array list 
        try {
			ReadCSV.read("C:\\Users\\Vivian\\Documents\\GitHub\\DDS\\data.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //get the data in the format of vehicle object array list
        ArrayList<Vehicle> CarList = ReadCSV.csvdata();

        	while(CarList.get(0) != null) {// receive the data 
        		
        		 for (int x = 0; x < CarList.size(); x++) {// go through every vehicle in the arraylist
        			 String text = Integer.toString(CarList.get(x).id)+"/"+ CarList.get(x).status+"/"+CarList.get(x).time+"/"+ Double.toString(CarList.get(x).lat)+"/"+ Double .toString(CarList.get(x).lon);
      
        			 dataWriter.write(text, InstanceHandle_t.HANDLE_NIL);// use the datawriter to write data to push
        		
        		 }
        		break;
        		
        	}
        	
}
}
