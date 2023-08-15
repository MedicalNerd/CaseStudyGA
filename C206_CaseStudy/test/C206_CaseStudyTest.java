import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private ServiceProvider sp1;
    private ServiceProvider sp2;
    private ServiceProvider sp3;
    private ArrayList<ServiceProvider> ServiceProviderList;
    
    private RenovationServices sa1;
    private RenovationServices sa2;
    private ArrayList<RenovationServices> serviceList;
    
    private Appointment ap1;
    private Appointment ap2;
    private ArrayList<Appointment> appointmentList;
    
    private User ryan;
    private User Adriel;
    private User Nicholas;
    private ArrayList<User> UserList;
    
    private Quote q1;
    private Quote q2;
    private ArrayList<Quote> quoteList;
    
    private Request r1;
    private Request r2;
    private Request r3;
    private ArrayList<Request> requestList;

    @Before
    public void setUp() throws Exception {
        ServiceProviderList = new ArrayList<ServiceProvider>();
        serviceList = new ArrayList<RenovationServices>();
        appointmentList = new ArrayList<Appointment>();
        UserList = new ArrayList<User>();
        quoteList = new ArrayList<Quote>();
        requestList = new ArrayList<Request>();
        
        sp1 = new ServiceProvider("Johns House Renos", "09:00 to 18:00");
        sp2 = new ServiceProvider("Daisy Lawn Renos", "09:00 to 18:00");
        sp3 = new ServiceProvider("Ara Car Renos", "09:00 to 18:00");
        
        sa1 = new RenovationServices("SA1", "Johns House Renos", "House Renovation",
                "Specialises in House Renovation", "09:00 to 18:00", true);
        sa2 = new RenovationServices("SA2", "Daisy Lawn Renos", "Lawn Renovation",
                "Specialises in Lawn Renovation", "08:00 to 18:00", true);
        serviceList.add(sa1);
        serviceList.add(sa2);

        ap1 = new Appointment("AP1", "Kafka", "Pending", "2023-07-25", "10.00", "Johns House Renos");
        ap2 = new Appointment("AP2", "Mary", "Pending", "2023-07-25", "11.00", "Daisy Lawn Renos");
        

        ryan = new User("Ryan","Password123@","ryan@gmail.com");
        Adriel = new User("Adriel","Password124@","Adriel@gmail.com");
        Nicholas = new User("Nicholas","Password111%","Nicholas@gmail.com");

        q1 = new Quote("Q1", "John", "Approved", 12345678, "House renovation quote");
        q2 = new Quote("Q2", "Jane", "Approved", 98765432, "Lawn renovation quote");
        quoteList.add(q1);
        quoteList.add(q2);

        r1 = new Request("RT1", "Alice", "Pending", 123456789, "Description 1");
        r2 = new Request("RT2", "Bob", "Pending", 987654321, "Description 2");
        r3 = new Request("RT3", "Carol", "Pending", 567890123, "Description 3");
        requestList.add(r1);
        requestList.add(r2);
        requestList.add(r3);
        
        
    
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
	    // Add a service as an example.
	    RenovationServices newService = new RenovationServices("SA3", "New Service Provider", "New Service Name",
	            "New Service Description", "10:00 to 20:00", true);
	    C206_CaseStudy.addService(serviceList, newService);
	    // Check if the number of services is now 3, as there were 2 already existing services before the new one was added.
	    assertEquals(3, serviceList.size());
	    // Check if the newly added service is equal to the information that was inputted.
	    assertEquals(newService, serviceList.get(2));
	}

	@Test
	public void testDeleteService() {
	    // Delete a service as an example.
	    boolean isDeleted = C206_CaseStudy.deleteService(serviceList, "SA1");
	    assertTrue(isDeleted);
	    // Check if there is only one service left in the list, as we have deleted 1 out of 2 of the services.
	    assertEquals(1, serviceList.size());
	    // Check if the service is no longer existing.
	    isDeleted = C206_CaseStudy.deleteService(serviceList, "SA1");
	    assertFalse(isDeleted);
	}


	

	
	
	@Test
	public void testViewAllAppointments() {
	    // Create the expected output that is supposed to be printed out
	    String expectedOutput = String.format("%-20s %-20s %-15s %-12s %-12s %-25s\n", "ASSET TAG", "CUSTOMER NAME",
	            "STATUS", "DATE", "TIME", "SERVICE NAME");
	    expectedOutput += String.format("%-20s %-20s %-15s %-12s %-12s %-25s\n", "AP1", "Kafka", "Pending",
	            "2023-07-25", "10.00", "Johns House Renos");
	    expectedOutput += String.format("%-20s %-20s %-15s %-12s %-12s %-25s\n", "AP2", "Mary", "Pending",
	            "2023-07-25", "11.00", "Daisy Lawn Renos");

	    // Call the method to retrieve the actual output
	    String actualOutput = C206_CaseStudy.retrieveAppointments(appointmentList);

	    // Compare the expected and actual outputs
	    assertEquals(expectedOutput, actualOutput);
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
	@Test
	public void testDeleteAppointment() {
	    // Delete an appointment as an example yes
		
	    boolean isDeleted = C206_CaseStudy.deleteAppointment(appointmentList, "AP1");
	    assertTrue(isDeleted);
	    // Check if there is only one appointment left in the list, as we have deleted 1 out of 2 appointments.
	    assertEquals(1, appointmentList.size());

	    // Check if the appointment is no longer existing
	    isDeleted = C206_CaseStudy.deleteAppointment(appointmentList, "AP1");
	    assertFalse(isDeleted);
	}
	@Test
	public void testViewAllQuotes() {
	    // Create the expected output that is supposed to be printed out
	    String expectedOutput = String.format("%-10s %-15s %-15s %-15s %-30s\n", "QUOTE ID", "CUSTOMER NAME",
	            "STATUS", "CONTACT NUMBER", "DESCRIPTION");
	    expectedOutput += String.format("%-10s %-15s %-15s %-15s %-30s\n", "Q1", "John", "Approved", "12345678",
	            "House renovation quote");
	    expectedOutput += String.format("%-10s %-15s %-15s %-15s %-30s\n", "Q2", "Jane", "Approved", "98765432",
	            "Lawn renovation quote");

	    // Call the method to retrieve the actual output
	    String actualOutput = C206_CaseStudy.retrieveQuotes(quoteList);

	    // Compare the expected and actual outputs
	    assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testAddQuote() {
	    // Add a quote as an example.
	    Quote newQuote = new Quote("Q3", "Alice", "Pending", 87654321, "Kitchen renovation quote");
	    C206_CaseStudy.createQuote(quoteList, newQuote);

	    // Check if the number of quotes is now 3, as there were 2 already existing quotes before the new one was added.
	    assertEquals(3, quoteList.size());

	    // Check if the newly added quote is equal to the information that was inputted.
	    assertEquals(newQuote, quoteList.get(2));
	}

	@Test
	public void testDeleteQuote() {
	    // Delete a quote as an example.
	    boolean isDeleted = C206_CaseStudy.deleteQuote(quoteList, "Q1");
	    assertTrue(isDeleted);

	    // Check if there is only one quote left in the list, as we have deleted 1 out of 2 of the quotes.
	    assertEquals(1, quoteList.size());

	    // Check if the quote is no longer existing.
	    isDeleted = C206_CaseStudy.deleteQuote(quoteList, "Q1");
	    assertFalse(isDeleted);
	}
	@Test
	public void testViewAllRequests() {
	    // Create the expected output that is supposed to be printed out
	    String expectedOutput = String.format("%-10s %-15s %-15s %-15s %-30s\n", "REQUEST ID", "CUSTOMER NAME",
	            "STATUS", "CONTACT NUMBER", "DESCRIPTION");
	    expectedOutput += String.format("%-10s %-15s %-15s %-15s %-30s\n", "R1", "Alice", "Pending", "123456789",
	            "Description 1");
	    expectedOutput += String.format("%-10s %-15s %-15s %-15s %-30s\n", "R2", "Bob", "Pending", "987654321",
	            "Description 2");

	    // Call the method to retrieve the actual output
	    String actualOutput = C206_CaseStudy.retrieveRequests(requestList);

	    // Compare the expected and actual outputs
	    assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testAddRequest() {
	    // Add a request as an example.
	    Request newRequest = new Request("RT3", "Carol", "Pending", 567890123, "Description 3");
	    C206_CaseStudy.addRequest(requestList, newRequest);

	    // Check if the number of requests is now 4, as there were 3 already existing requests before the new one was added.
	    assertEquals(4, requestList.size());

	    // Check if the newly added request is equal to the information that was inputted.
	    assertEquals(newRequest, requestList.get(3));
	}

	@Test
	public void testDeleteRequest() {
	    // Delete a request as an example.
	    boolean isDeleted = C206_CaseStudy.removeRequest(requestList, "RT1");
	    assertTrue(isDeleted);

	    // Check if there are only two requests left in the list, as we have deleted 1 out of 3 of the requests.
	    assertEquals(2, requestList.size());

	    // Check if the request is no longer existing.
	    isDeleted = C206_CaseStudy.removeRequest(requestList, "RT1");
	    assertFalse(isDeleted);
	}
	@Test
	public void testRetrieveAllServiceProvider() {
		// Test Case 1: View an empty Service Provider list
		assertNotNull("Test if there is valid Service Provider arraylist to add to", ServiceProviderList);
		assertEquals("Test that the Service Provider arraylist is empty.", 0, ServiceProviderList.size());
		String allServiceProvider = C206_CaseStudy.retrieveAllServiceProvider(ServiceProviderList);
		String testOutput = "";
		assertEquals("Test that nothing is displayed", testOutput, allServiceProvider);

 

		// Test Case 2: Add two Service Providers to the list and view the list
		C206_CaseStudy.addServiceProvider(ServiceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(ServiceProviderList, sp2);
		assertEquals("Test that Service Provider arraylist size is 2.", 2, ServiceProviderList.size());
		allServiceProvider = C206_CaseStudy.retrieveAllServiceProvider(ServiceProviderList);
		testOutput = String.format("%10s %20s\n", "Johns House Renos", "09:00 to 18:00");
		testOutput += String.format("%10s %20s\n", "Daisy Lawn Renos", "09:00 to 18:00");
		assertEquals("Test that the display is correct.", testOutput, allServiceProvider);

	}

    @Test
    public void testAddServiceProvider() {
		// Test Case 1: When the Service Provider list is empty, add one item
		assertNotNull("Test if there is valid Service Provider arraylist to add to", ServiceProviderList);
		assertEquals("Test that the Service Provider arraylist is empty.", 0, ServiceProviderList.size());
		C206_CaseStudy.addServiceProvider(ServiceProviderList, sp1);
		assertEquals("Test that the Service Provider arraylist size is 1.", 1, ServiceProviderList.size());

 

		// Test Case 2: Add another Service Provider 
		C206_CaseStudy.addServiceProvider(ServiceProviderList, sp2);
		assertEquals("Test that the Service Provider arraylist size is now 2.", 2, ServiceProviderList.size());
		assertSame("Test that Service Provider is added to the end of the list.", sp2, ServiceProviderList.get(1));

 

		// Test Case 3: Add a Service Provider that already exists in the list
		C206_CaseStudy.addServiceProvider(ServiceProviderList, sp2);
		assertEquals("Test that the Service Provider arraylist size is unchange.", 2, ServiceProviderList.size());

 

	}


    @Test
    public void testDeleteServiceProvider() {
    	// Test Case 1: Delete a Service Provider
		C206_CaseStudy.addServiceProvider(ServiceProviderList, sp1);
		C206_CaseStudy.deleteServiceProvider(ServiceProviderList, sp2.getServiceProvider());
		assertEquals("Test that the Service Provider arraylist size is now 1.", 1, ServiceProviderList.size());	

        // Test Case 2: Delete a Service Provider that does not exist in the list

		C206_CaseStudy.deleteServiceProvider(ServiceProviderList, "sp4");
		assertEquals("Test that the Service Provider arraylist size is unchange.", 1, ServiceProviderList.size());        

    }
    @Test
	public void testRetrieveAllUsers() {
		// Test Case 1: View an empty Service Provider list
		assertNotNull("Test if there is valid Service Provider arraylist to add to", UserList);
		assertEquals("Test that the Service Provider arraylist is empty.", 0, UserList.size());
		String allUsers = C206_CaseStudy.retrieveAllUsers(UserList);
		String testOutput = "";
		assertEquals("Test that nothing is displayed", testOutput, allUsers);

 

		// Test Case 2: Add two Service Providers to the list and view the list
		C206_CaseStudy.addUsers(UserList, ryan);
		C206_CaseStudy.addUsers(UserList, Adriel);
		assertEquals("Test that Service Provider arraylist size is 2.", 2, UserList.size());
		allUsers = C206_CaseStudy.retrieveAllUsers(UserList);
		
		testOutput = String.format("%-10s %-30s\n","Ryan","ryan@gmail.com" );
		testOutput += String.format("%-10s %-30s\n","Adriel","Adriel@gmail.com");
		assertEquals("Test that the display is correct.", testOutput, allUsers);

	}
    @Test
    public void testaddUser() {
		// Test Case 1: When UserList is empty, add one item
		assertNotNull("Test if there is valid User arraylist to add to", UserList);
		assertEquals("Test that the User arraylist is empty.", 0, UserList.size());
		C206_CaseStudy.addUsers(UserList, Adriel);
		assertEquals("Test that the Userlist size is 1.", 1, UserList.size());

 

		// Test Case 2: Add another User  
		C206_CaseStudy.addUsers(UserList, Nicholas);
		
		assertEquals("Test that the Userlist size is now 2.", 2, UserList.size());
		assertSame("Test that User Nicholas is added to the end of the list.", Nicholas, UserList.get(1));

 

		// Test Case 3: Add Same User that already exists in the list
		C206_CaseStudy.addUsers(UserList,Adriel);
		assertEquals("Test that the Userlist size is unchange.", 2, UserList.size());

 

	}

    
    @Test
    public void testDeleteUsers() {
    	// Test Case 1: Delete User
		C206_CaseStudy.addUsers(UserList, ryan);
		C206_CaseStudy.deleteUsers(UserList, ryan.getUsername(),ryan.getPassword());
		assertEquals("Test that the User arraylist size is now 0.",0, UserList.size());	

        // Test Case 2: Delete a Service Provider that does not exist in the list

		C206_CaseStudy.deleteUsers(UserList, "Jerry","Password10");
		assertEquals("Test that the Service Provider arraylist size is unchange.",0, UserList.size());        

    }

	
	
	

}
//version 2


//Version 2

