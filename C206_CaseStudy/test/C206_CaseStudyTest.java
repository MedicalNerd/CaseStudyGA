import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
	
	private RenovationServices sa1;
	private RenovationServices sa2;
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	private User user1;
	private User user2;
	private User user3;
	private Appointment app1;
	private Appointment app2;


	private ArrayList<RenovationServices> serviceList;
	private ArrayList<ServiceProvider> ServiceProviderList;
	private ArrayList<User> userList;
	private ArrayList<Appointment>  appointmentList;


    @Before
   public void setUp() {
    	//Set up examples for the test cases.
        serviceList = new ArrayList<>();
		sa1 = new RenovationServices("SA1","Johns House Renos", "House Renovation","Specialises in House Renovation","09:00 to 18:00",true);
		sa2 = new RenovationServices("SA2","Daisy Lawn Renos", "Lawn Renovation","Specialises in Lawn Renovation","08:00 to 18:00",true);
		sp1 = new ServiceProvider("Johns House Renos", "09:00 to 18:00");
		sp2 = new ServiceProvider("Daisy Lawn Renos", "09:00 to 18:00");
		user1 = new User("Tom","Password12@","Tom@gmail.com");
		user2 = new User("Mary","Password@12","Mary@gmail.com");
		user3 = new User("Kafka","YES123@oo","Mommy@gmail.com");
		app1 = new Appointment("SA1","Kafka",true, "2023-07-25", "10.00","N/A");
		app2 = new Appointment("SA1","Kafka",true, "2023-07-25", "10.00","N/A");
		serviceList.add(sa1);
		serviceList.add(sa2);
		ServiceProviderList.add(sp1);
		ServiceProviderList.add(sp2);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		appointmentList.add(app1);
		appointmentList.add(app2);
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
    	RenovationServices newService = new RenovationServices("SA3","Bill's Bathroom Renos","Bathroom Renovation","Specialises in Bathroom Renovation","09:00 to 20:00",false);

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
    @Test
	public void testViewAllServiceProvider() {
	    // Create the expected output that is supposed to be printed out
	    String expectedOutput = String.format("%-20s %-40s\n", "SERVICE PROVIDER", "CONTACT HOURS");
	    expectedOutput += String.format("%-20s %-40s\n", "Johns House Renos", "09:00 to 18:00");
	    expectedOutput += String.format("%-20s %-40s\n", "Daisy Lawn Renos", "09:00 to 18:00");	
	    assertEquals(expectedOutput, C206_CaseStudy.retrieveAllServiceProvider(ServiceProviderList));
	}

	@Test
    public void testAddServiceProvider() {
    	//Add a service as an example.
    	ServiceProvider newSP = new ServiceProvider("Service Provider3", "4:00 to 18:00");
        C206_CaseStudy.addServiceProvider(ServiceProviderList, newSP);
        //Check if the number of services is now 3, as there was 2 already existing service before the new one was added.
        assertEquals(3, ServiceProviderList.size());
        //Check if the newly added service is equal to the information that was inputed.
        assertEquals(newSP, ServiceProviderList.get(2));
	}

	@Test
    public void testDeleteServiceProvider() {
    	//Delete a service provider as an example.
        boolean isDeleted = C206_CaseStudy.deleteServiceProvider(ServiceProviderList);
        assertTrue(isDeleted);
        //Check if there is only one service provider left in the list, as we have deleted 1 out of 2 of the services.
        assertEquals(1, ServiceProviderList.size());
        //Check if the service provider is no longer existing.
        isDeleted = C206_CaseStudy.deleteServiceProvider(ServiceProviderList);
        assertFalse(isDeleted);
    }
}



//Version 2

