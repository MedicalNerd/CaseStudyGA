import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
	
	private RenovationServices sa1;
	private RenovationServices sa2;


	private ArrayList<RenovationServices> serviceList;

    @Before
   public void setUp() {
    	//Set up examples for the test cases.
        serviceList = new ArrayList<>();
        serviceList.add(new RenovationServices("Provider1","House Company","09:00 to 18:00","SA1","House Renovation","Specialises in House Renovation",true));
		serviceList.add(new RenovationServices("Provider2","Lawn Company","05:00 to 18:00","SA2","Lawn Renovation","Specialises in Lawn Renovation",true));
		
        
        serviceList.add(sa1);
        serviceList.add(sa2);
    }


    @Test
    public void testViewAllServices() {
        // Create the expected output that is supposed to be printed out
        String expectedOutput = String.format("%-20s %-40s %-20s %-10s %-20s %-40s %-10s\n", "ASSET TAG", "SERVICE NAME",
                "SERVICE PROVIDER", "CONTACT HOURS", "SERVICE NAME", "DESCRIPTION", "AVAILABLE");
        expectedOutput += String.format("%-20s %-40s %-20s %-10s %-20s %-40s %-10s\n", "SA1", "House Renovation", "House Company",
                "09:00 to 18:00", "House Renovation", "Specialises in House Renovation", "Yes");
        expectedOutput += String.format("%-20s %-40s %-20s %-10s %-20s %-40s %-10s\n", "SA2", "Lawn Renovation", "Lawn Company",
                "05:00 to 18:00", "Lawn Renovation", "Specialises in Lawn Renovation", "Yes");

        assertEquals(expectedOutput, C206_CaseStudy.retrieveAllServices(serviceList));
    }

    @Test
    public void testAddService() {
    	//Add a service as an example.
    	RenovationServices newService = new RenovationServices("Provider3","Bathroom Company","4:00 to 18:00","SA2","Bath Renovation","Specialises in Bathroom Renovation",false);

        C206_CaseStudy.addService(serviceList, newService);
        //Check if the number of services is now 3, as there was 2 already existing service before the new one was added.
        assertEquals(3, serviceList.size());
        //Check if the newly added service is equal to the information that was inputed.
        assertEquals(newService, serviceList.get(2));
    }

    @Test
    public void testDeleteService() {
    	//Delete a service as an example.
        boolean isDeleted = C206_CaseStudy.deleteService(serviceList, "SA2");
        assertTrue(isDeleted);
        //Check if there is only one service left in the list, as we have deleted 1 out of 2 of the services.
        assertEquals(1, serviceList.size());
        //Check if the service is no longer existing.
        isDeleted = C206_CaseStudy.deleteService(serviceList, "SA2");
        assertFalse(isDeleted);
    }
}


//Version 2

