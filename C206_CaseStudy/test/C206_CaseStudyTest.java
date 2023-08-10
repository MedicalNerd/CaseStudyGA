import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	private ArrayList<ServiceProvider> ServiceProviderList;
	
	private RenovationServices sa1;
	private RenovationServices sa2;
	private ArrayList<RenovationServices> serviceList;
	
	private Appointment ap1;
	private Appointment ap2;
	private ArrayList<Appointment> appointmentList;
	


	@Before
	public void setUp() throws Exception {
		ServiceProviderList = new ArrayList<ServiceProvider>();
		serviceList = new ArrayList<RenovationServices>();
		appointmentList = new  ArrayList<Appointment>();
		
		sp1 = new ServiceProvider("Johns House Renos", "09:00 to 18:00");
		sp2 = new ServiceProvider("Daisy Lawn Renos", "09:00 to 18:00");
		ServiceProviderList.add(sp1);
		ServiceProviderList.add(sp2);
		
		sa1 = new RenovationServices("SA1", "Johns House Renos", "House Renovation",
				"Specialises in House Renovation", "09:00 to 18:00", true);
		sa2 = new RenovationServices("SA2", "Daisy Lawn Renos", "Lawn Renovation",
				"Specialises in Lawn Renovation", "08:00 to 18:00", true);
		serviceList.add(sa1);
		serviceList.add(sa2);

		ap1 = new Appointment("AP1", "Kafka", "Pending", "2023-07-25", "10.00", "Johns House Renos");
		ap2 = new Appointment("AP2", "Mary", "Pending", "2023-07-25", "11.00", "Daisy Lawn Renos");
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testViewAllServices() {
	    // Create the expected output that is supposed to be printed out
	    String expectedOutput = String.format("%-20s %-40s %-20s %-20s %-40s %-10s\n", "ASSET TAG", "SERVICE PROVIDER",
				"SERVICE NAME", "DESCRIPTION", "CONTACT HOURS", "AVAILABLE");
	    expectedOutput += String.format("%-20s %-40s %-20s %-20s %-40s %-10s\n", "SA1", "Johns House Renos", "House Renovation",
				"Specialises in House Renovation", "09:00 to 18:00", "Yes");
	    expectedOutput += String.format("%-20s %-40s %-20s %-20s %-40s %-10s\n", "SA2", "Daisy Lawn Renos", "Lawn Renovation",
				"Specialises in Lawn Renovation", "08:00 to 18:00", "Yes");
	    assertEquals(expectedOutput, C206_CaseStudy.retrieveAllServices(serviceList));
	}

	
	@Test
    public void testAddService() {
    	//Add a service as an example.
    	RenovationServices newService = new RenovationServices("SA3", "New Service Provider", "New Service Name",
    			"New Service Description", "10:00 to 20:00", true);
        C206_CaseStudy.addService(serviceList, newService);
        //Check if the number of services is now 3, as there were 2 already existing services before the new one was added.
        assertEquals(3, serviceList.size());
        //Check if the newly added service is equal to the information that was inputted.
        assertEquals(newService, serviceList.get(2));
	}

	@Test
    public void testDeleteService() {
    	//Delete a service as an example.
        boolean isDeleted = C206_CaseStudy.deleteService(serviceList, "SA1");
        assertTrue(isDeleted);
        //Check if there is only one service left in the list, as we have deleted 1 out of 2 of the services.
        assertEquals(1, serviceList.size());
        //Check if the service is no longer existing.
        isDeleted = C206_CaseStudy.deleteService(serviceList, "SA1");
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
	
	@Test
	public void testAddAppointment() { //Derrick
		assertNotNull("Test if there is valid Appointment arraylist to add to", appointmentList);
		
		appointmentList.add(ap1);
		C206_CaseStudy.createAppointment(appointmentList, ap1);	
		assertEquals("Test that the Appointment arraylist size is 1.", 1, appointmentList.size());
		assertSame("Test that Appointment is added to the end of the list.", ap1, appointmentList.get(0));
		
		appointmentList.add(ap2);
		C206_CaseStudy.createAppointment(appointmentList, ap2);
		assertEquals("Test that the Chromebook arraylist size is now 2.", 2, appointmentList.size());
		assertSame("Test that Chromebook is added to the end of the list.", ap2, appointmentList.get(1));
		
		C206_CaseStudy.createAppointment(appointmentList, ap2);
		assertEquals("Test that the Appointment arraylist size is unchange.", 2, appointmentList.size());
		
		Appointment ap_missing = new Appointment("AP3", "", "Pending", "2023-07-26", "11.00", "Johns House Renos");
		C206_CaseStudy.createAppointment(appointmentList, ap_missing);
		assertEquals("Test that the Chromebook arraylist size is unchange.", 2, appointmentList.size());
		
		
	}

}
//version 2
