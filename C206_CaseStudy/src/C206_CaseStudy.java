import java.util.ArrayList;

public class C206_CaseStudy {


	
	private static final int ACTION_TYPE_QUOTE = 2;
	private static final int ACTION_TYPE_APPOINTMENT = 1;
	private static final int OPTION_VIEW_SERVICE = 1;
	private static final int OPTION_CREATE_SERVICE = 2;
	private static final int OPTION_DELETE_SERVICE = 3;
	private static final int OPTION_VIEW_ACTION = 4;
	private static final int OPTION_ADD_ACTION = 5;
	private static final int OPTION_DELETE_ACTION = 6;
	private static final int OPTION_ADDUSER = 7;
	private static final int OPTION_VIEWUSERS = 8;
	private static final int OPTION_DELETEUSERS = 9;
	private static final int OPTION_VIEW_SERVICEPROVIDER = 10; //ara
	private static final int OPTION_CREATE_SERVICEPROVIDER = 11;
	private static final int OPTION_DELETE_SERVICEPROVIDER = 12;
	private static final int OPTION_QUIT = 13;
	
	public static void main(String[] args)  {

		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();

		ArrayList<User> UserList = new ArrayList<User>();
		ArrayList<ServiceProvider> ServiceProviderList = new ArrayList<ServiceProvider>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();


		serviceList.add(new RenovationServices("SA1","Johns House Renos", "House Renovation","Specialises in House Renovation","09:00 to 18:00",true));
		serviceList.add(new RenovationServices("SA2","Daisy Lawn Renos", "Lawn Renovation","Specialises in Lawn Renovation","08:00 to 18:00",true));
		ServiceProviderList.add(new ServiceProvider("Johns House Renos", "09:00 to 18:00"));
		ServiceProviderList.add(new ServiceProvider("Daisy Lawn Renos", "09:00 to 18:00"));
		UserList.add(new User("Tom","Password12@","Tom@gmail.com"));
		UserList.add(new User("Mary","Password@12","Mary@gmail.com"));
		UserList.add(new User("Kafka","YES123@oo","Mommy@gmail.com"));
		appointmentList.add(new Appointment("SA1","Kafka",true, "2023-07-25", "10.00","N/A"));
		appointmentList.add(new Appointment("SA1","Kafka",true, "2023-07-25", "10.00","N/A"));

		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW_SERVICE) {
				// View all services currently available.
				C206_CaseStudy.viewAllServices(serviceList);


			}else if (option == OPTION_CREATE_SERVICE) {
			   // Create a service.
				RenovationServices newService = C206_CaseStudy.inputService();
	            C206_CaseStudy.addService(serviceList, newService);
			}
			else if (option == OPTION_DELETE_SERVICE) {
			  // Delete a service.
				C206_CaseStudy.deleteServiceMenu(serviceList);
			}
			else if (option == OPTION_VIEW_ACTION) {
			 // Display Appointments and Quotes
			}
			else if (option == OPTION_ADD_ACTION) {
				// 

				
				int itemType = Helper.readInt("Appointment[1] or Quote[2]? > ");

				if (itemType == ACTION_TYPE_APPOINTMENT) {
					// Add an appointment.
					Appointment ap = inputAppointment();
					C206_CaseStudy.createAppointment(appointmentList, ap);
					System.out.println("Appointment scheduled");


				} else if (itemType == ACTION_TYPE_QUOTE) {
					// Add a quote.


				} else {
					System.out.println("Invalid type");
				}

			}else if (option == OPTION_DELETE_ACTION) {
				// 

				
				int itemType = Helper.readInt("Appointment[1] or Quote[2]? > ");

				if (itemType == ACTION_TYPE_APPOINTMENT) {
					// Delete an appointment.
					Appointment ap= inputAppointment();
					C206_CaseStudy.deleteAppointment(appointmentList, ap);
					System.out.println("Appointment deleted");


				} else if (itemType == ACTION_TYPE_QUOTE) {
					// Delete a quote.


				} else {
					System.out.println("Invalid type");
				}

			}else if(option == OPTION_ADDUSER){
				addUser(UserList);
			}
			else if(option == OPTION_VIEWUSERS){
				viewUser(UserList);
			}
			else if(option == OPTION_DELETEUSERS){
				deleteUser(UserList);
			}else if(option == OPTION_VIEW_SERVICEPROVIDER) {
				// View all services providers currently available.
				C206_CaseStudy.viewServiceProvider(ServiceProviderList);

			}else if (option == OPTION_CREATE_SERVICEPROVIDER) {
			   // Create a service provider.
				ServiceProvider newServiceProvider = C206_CaseStudy.inputServiceProvider();
	            C206_CaseStudy.addServiceProvider(ServiceProviderList);
			}
			else if (option == OPTION_DELETE_SERVICEPROVIDER) {
			  // Delete a service providers.
				C206_CaseStudy.deleteServiceProvider(ServiceProviderList);
			}
			else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

}


	public static void menu() {
		C206_CaseStudy.setHeader("RENOVATION PORTAL APP");
		System.out.println("1. Display All Services");
		System.out.println("2. Create a Service");
		System.out.println("3. Delete a Service");
		System.out.println("4. View all Appointments/Quotes");
		System.out.println("5. Make an Appointment/Quote");
		System.out.println("6. Delete an Appointment/Quote");
		System.out.println("7. Display All Service Providers");
		System.out.println("8. Create a Service Provider");
		System.out.println("9. Delete a Service Provider");
		System.out.println("10. Quit");
		System.out.println("7. Add User");
		System.out.println("8. View User");
		System.out.println("9. Delete User");
		System.out.println("10. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
//================================= Option 7  (Add User Validation) =================================
public static void addUser(ArrayList<User>UserList) {
	String username = Helper.readString("Enter username here >");
	String password = Helper.readString("Enter password here >");
	String email = Helper.readString("Enter email here >");
	String regex = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$";//
	String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";// To Check Email format is correct
	boolean validPassword = password.matches(regex);
	boolean validEmail = email.matches(regex1);
	if (validPassword == true && validEmail == true &&!username.isEmpty()) {
		User newUser = new User(username,password,email);
		
		UserList.add(newUser);
		String added = String.format("\n%s %-5s %2s %s %2s %s", "***", "User", "has", " been", "added", "***");
		System.out.println(added);
		
	}
	else {
		if(username.isEmpty()) {
			System.out.println("Empty Username!");
		}
		else if(validPassword == false) {
			System.out.println("Enter a valid Password Format!");
		}
		else if(validEmail == false) {
			System.out.println("Enter a valid Email!");
		}
		else if(validPassword == false && validEmail == false) {
			System.out.println("Enter valid Email and valid Password Format!");
		}
		else if(validPassword == false && username.isEmpty()) {
			System.out.println("Enter valid Password Format and a Username!");
		}
	}
	

}
//================================= Option 8 (View User) =================================
public static void viewUser(ArrayList<User>UserList) {
	String title = String.format("%-10s %-15s ","Username","Email");
	System.out.println(title);
	for (int i = 0; i < UserList.size();i++) {
		String Userheader = String.format("%-10s %-15s ",UserList.get(i).getUsername(),UserList.get(i).getEmail());
		System.out.println(Userheader);

		
	}
}
//================================= Option 9 (Delete User0 =================================
public static boolean deleteUser(ArrayList<User>UserList) {
	boolean patientfound = false;
	

	//-------------------
	// Complete code here
	//-------------------
	String pname = Helper.readString("Enter Patient Name > ");
	String password = Helper.readString("Enter Patient Name > ");
	for (int i = 0; i < UserList.size();i++) {
		if(UserList.get(i).getUsername().equals(pname)&&UserList.get(i).getPassword().equals(password)) {
			
			String check = Helper.readString("Are you sure you want to delete/deactivate your account? (Y/N) > ");
			 if(check.equals("Y")) {
				 UserList.remove(i);
				 System.out.println("User Account is successfully deleted!");
				 patientfound = true;
				 break;
			 }
			 else {
				 System.out.println("Delete User not successful!");
			 }
			
			
			
		}
		else {
			System.out.println("Enter the correct Username or Password!");
		}
		

	}
	
		
	
	return patientfound;
}
	//================================= Option 1 (View Service) =================================


public static String retrieveAllServices(ArrayList<RenovationServices> serviceList) {
    String output = "";
    for (int i = 0; i < serviceList.size(); i++) {
        RenovationServices service = serviceList.get(i);
        output += String.format("%-20s %-40s %-20s %-20s %-40s %-10s\n",service.getAssetTag(),service.getServiceProvider(),service.getServiceName(), service.getServiceDescription(),
               service.getServiceProviderContactHours(),
                C206_CaseStudy.showAvailability(service.isAvailable()));
    }
    return output;
}
public static void viewAllServices(ArrayList<RenovationServices> serviceList) {
    C206_CaseStudy.setHeader("ALL SERVICES");
    String output = String.format("%-20s %-40s %-20s %-20s %-40s %-10s\\n","ASSET TAG","SERVICE PROVIDER", "SERVICE NAME", "DESCRIPTION", "CONTACT HOURS", "AVAILABLE");
    output += retrieveAllServices(serviceList);
    System.out.println(output);
}


	//================================= Option 2 (Add Service) =================================


public static RenovationServices inputService() {
	String assetTag = Helper.readString("Enter AssetTag > ");
	  String serviceProvider = Helper.readString("Enter Service provider > ");
    String serviceName = Helper.readString("Enter service name > ");
	  String serviceHours = Helper.readString("Enter Service hours > ");
    String description = Helper.readString("Enter service description > ");
    boolean isAvailable = Helper.readBoolean("Is the service available? (Yes/No) > ");
    
    return new RenovationServices(assetTag, serviceProvider, serviceName,serviceHours,description, isAvailable);
}

public static void addService(ArrayList<RenovationServices> serviceList, RenovationServices newService) {
    serviceList.add(newService);
    System.out.println("Service added successfully.");
}
	
	//================================= Option 3 (Delete Service)  =================================


public static void deleteServiceMenu(ArrayList<RenovationServices> serviceList) {
    C206_CaseStudy.setHeader("DELETE SERVICE");
    String assetTag = Helper.readString("Enter asset tag of the service to delete > ");
    boolean isDeleted = C206_CaseStudy.deleteService(serviceList, assetTag);
    if (isDeleted) {
        System.out.println("Service deleted successfully.");
    } else {
        System.out.println("Service not found or unable to delete.");
    }
}
public static boolean deleteService(ArrayList<RenovationServices> serviceList, String assetTag) {
    for (int i = 0; i < serviceList.size(); i++) {
        RenovationServices service = serviceList.get(i);
        if (service.getAssetTag().equalsIgnoreCase(assetTag)) {
            serviceList.remove(i);
            return true;
        }
    }
    return false;
}
	
	//================================= Option 4 (View Action) =================================
	
	//================================= Option 5 (Add Action) =================================
	
	//================================= Option 6  (Delete Action) =================================

//================================= Option 10 (View Service Providers) =================================
	public static String retrieveAllServiceProvider(ArrayList<ServiceProvider> ServiceProviderList) {
		String output = "";

		for (int i = 0; i < ServiceProviderList.size(); i++) {
				output += String.format("%-10s %-30s", ServiceProviderList.get(i).getServiceProvider(),
				ServiceProviderList.get(i).getServiceProviderContactHours());
		}
		return output;
	}

	public static void viewAllServiceProvider(ArrayList<ServiceProvider> ServiceProviderList) {
		C206_CaseStudy.setHeader("SERVICE PROVIDER LIST");
		String output = String.format("%-10s %-30s\n","Service Provider","Contact Hours");
		 output += retrieveAllServiceProvider(ServiceProviderList);	
		System.out.println(output);
	}



	//================================= Option 11 (Add Service Provider) =================================
	public static ServiceProvider inputServiceProvider() {
		String name = Helper.readString("Enter asset tag > ");
		String hours = Helper.readString("Enter description > ");



		ServiceProvider sp= new ServiceProvider(name, hours);
		return sp;

	}
	public static void addServiceProvider(ArrayList<ServiceProvider> ServiceProviderList, ServiceProvider sp) {
		ServiceProvider spro;
		for(int i = 0; i < ServiceProviderList.size(); i++) {
			spro = ServiceProviderList.get(i);
			if (spro.getServiceProvider().equalsIgnoreCase(sp.getServiceProvider()) )
				return;
		}
		if ((sp.getServiceProvider().isEmpty()) || (sp.getServiceProvider().isEmpty()) ) {
			return;
		}

		ServiceProviderList.add(sp);
	}



	
	//================================= Option 12  (Delete Service Provider) =================================

	public static boolean deleteServiceProvider(ArrayList<ServiceProvider>ServiceProviderList) {
		boolean spFound = false;

		String spname = Helper.readString("Enter Service Provider Name > ");
		for (int i = 0; i < ServiceProviderList.size();i++) {
			if(ServiceProviderList.get(i).getServiceProvider().equals(spname)) {

				String check = Helper.readString("Are you sure you want to delete service provider? (Y/N) > ");
				 if(check.equals("Y")) {
					 ServiceProviderList.remove(i);
					 System.out.println("Service Provider is successfully deleted!");
					 spFound = true;
					 break;
				 }
				 else {
					 System.out.println("Delete Service Provider not successful!");
				 }



			}
			else {
				System.out.println("Service Provider not found");
			}




		}

		return spFound;
	}
}
//version 2