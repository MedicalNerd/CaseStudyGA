import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private ArrayList<RenovationServices> serviceList;

    @Before
    void setUp() {
    	//Set up examples for the test cases.
        serviceList = new ArrayList<>();
        serviceList.add(new RenovationServices("SA1", "House Renovation", "Specialises in House Renovation",
                "09:00 to 18:00", true));
    }

    @Test
    void testViewAllServices() {
    	//Create the output that  is expected to be printed out.
        String expectedOutput = String.format("%-10s %-30s %-30s %-20s %s\n", "ASSET TAG", "SERVICE NAME",
                "SERVICE DESCRIPTION", "CONTACT HOURS", "AVAILABLE");
        expectedOutput += String.format("%-10s %-30s %-30s %-20s %s\n", "SA1", "House Renovation",
                "Specialises in House Renovation", "09:00 to 18:00", "Yes");
        //See if if the output actually generated matches with the expected.
        assertEquals(expectedOutput, C206_CaseStudy.retrieveAllServices(serviceList));
    }

    @Test
    void testAddService() {
    	//Add a service as an example.
        RenovationServices newService = new RenovationServices("SA2", "Bathroom Renovation",
                "Specialises in Bathroom Renovation", "10:00 to 19:00", true);

        C206_CaseStudy.addService(serviceList, newService);
        //Check if the number of services is now 2, as there was 1 already existing service before the new one was added.
        assertEquals(2, serviceList.size());
        //Check if the newly added service is equal to the information that was inputed.
        assertEquals(newService, serviceList.get(1));
    }

    @Test
    void testDeleteService() {
    	//Delete a service as an example.
        boolean isDeleted = C206_CaseStudy.deleteService(serviceList, "SA1");
        assertTrue(isDeleted);
        //Check if there is no longer any services within the list, as we have removed the only service in the list.
        assertEquals(0, serviceList.size());
        //Check if the service is no longer existing.
        isDeleted = C206_CaseStudy.deleteService(serviceList, "SA1");
        assertFalse(isDeleted);
    }
}

//Version 1
