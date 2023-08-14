import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
	
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	private ServiceProvider sp3;
	private User ryan;
	private User Adriel;
	private User Nicholas;

	private ArrayList<ServiceProvider> ServiceProviderList;
	private ArrayList<User> UserList;
	
    @Before
   public void setUp() throws Exception {
    	//Set up examples for the test cases.
    	sp1 = new ServiceProvider("Johns House Renos", "09:00 to 18:00");
        sp2 = new ServiceProvider("Daisy Lawn Renos", "09:00 to 18:00");
        sp3 = new ServiceProvider("Ara Car Renos", "09:00 to 18:00");
        ServiceProviderList = new ArrayList<ServiceProvider>();
        //Set up for User
        ryan = new User("Ryan","Password123@","ryan@gmail.com");
        Adriel = new User("Adriel","Password124@","Adriel@gmail.com");
        Nicholas = new User("Nicholas","Password3454!","Nicholas@gmail.com");
        UserList = new ArrayList<User>();
      
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


//Version 2

