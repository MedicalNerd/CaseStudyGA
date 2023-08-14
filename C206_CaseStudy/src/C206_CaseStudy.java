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
	private static final int OPTION_VIEW_SERVICEPROVIDER = 10; // ara
	private static final int OPTION_CREATE_SERVICEPROVIDER = 11;
	private static final int OPTION_DELETE_SERVICEPROVIDER = 12;
	private static final int OPTION_QUIT = 13;

	public static void main(String[] args) {

		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();

		ArrayList<User> UserList = new ArrayList<User>();
		ArrayList<ServiceProvider> ServiceProviderList = new ArrayList<ServiceProvider>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Quote> quoteList = new ArrayList<Quote>();

		serviceList.add(new RenovationServices("SA1", "Johns House Renos", "House Renovation",
				"Specialises in House Renovation", "09:00 to 18:00", true));
		serviceList.add(new RenovationServices("SA2", "Daisy Lawn Renos", "Lawn Renovation",
				"Specialises in Lawn Renovation", "08:00 to 18:00", true));
		ServiceProviderList.add(new ServiceProvider("Johns House Renos", "09:00 to 18:00"));
		ServiceProviderList.add(new ServiceProvider("Daisy Lawn Renos", "08:00 to 18:00"));
		UserList.add(new User("Tom", "Password12@", "Tom@gmail.com"));
		UserList.add(new User("Mary", "Password@12", "Mary@gmail.com"));
		UserList.add(new User("Kafka", "YES123@oo", "Mommy@gmail.com"));

		appointmentList.add(new Appointment("AP1", "Kafka", true, "2023-07-25", "10.00", "Johns House Renos"));
		appointmentList.add(new Appointment("AP2", "Mary", true, "2023-07-25", "11.00", "Daisy Lawn Renos"));
		quoteList.add(new Quote("Q1", "John", true, 12345678, "House renovation quote"));
		quoteList.add(new Quote("Q2", "Jane", true, 98765432, "Lawn renovation quote"));

		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW_SERVICE) {
				// View all services currently available.
				C206_CaseStudy.viewAllServices(serviceList);

			} else if (option == OPTION_CREATE_SERVICE) {
				// Create a service.
				RenovationServices newService = C206_CaseStudy.inputService();
				C206_CaseStudy.addService(serviceList, newService);
			} else if (option == OPTION_DELETE_SERVICE) {
				// Delete a service.
				C206_CaseStudy.deleteServiceMenu(serviceList);
			} else if (option == OPTION_VIEW_ACTION) {
				// Display Appointments and Quotes
				int itemType = Helper.readInt("Appointment[1] or Quote[2]? > ");

				if (itemType == ACTION_TYPE_APPOINTMENT) {
					// View all appointment.
					C206_CaseStudy.viewAppointments(appointmentList);

				} else if (itemType == ACTION_TYPE_QUOTE) {
					// View all quote.
					C206_CaseStudy.viewQuotes(quoteList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_ADD_ACTION) {
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

			} else if (option == OPTION_DELETE_ACTION) {
				//

				int itemType = Helper.readInt("Appointment[1] or Quote[2]? > ");

				if (itemType == ACTION_TYPE_APPOINTMENT) {
					// Delete an appointment.
					// Appointment ap = inputAppointment();
//					C206_CaseStudy.deleteAppointment(appointmentList, ap);
					System.out.println("Appointment deleted");

				} else if (itemType == ACTION_TYPE_QUOTE) {
					// Delete a quote.

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_ADDUSER) {
				User user = inputUserAccount();
				addUsers
				(UserList, user);
			} else if (option == OPTION_VIEWUSERS) {
				viewAllUsers(UserList);
			} else if (option == OPTION_DELETEUSERS) {
				C206_CaseStudy.deleteUsersMain(UserList);
			} else if (option == OPTION_VIEW_SERVICEPROVIDER) {
				// View all services providers currently available.
				C206_CaseStudy.viewAllServiceProvider(ServiceProviderList);

			} else if (option == OPTION_CREATE_SERVICEPROVIDER) {
				// Create a service provider.
				ServiceProvider newServiceProvider = C206_CaseStudy.inputServiceProvider();
				C206_CaseStudy.addServiceProvider(ServiceProviderList, newServiceProvider);
			} else if (option == OPTION_DELETE_SERVICEPROVIDER) {
				// Delete a service providers.
				C206_CaseStudy.deleteServiceProviderMain(ServiceProviderList);
			} else if (option == OPTION_QUIT) {
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
		System.out.println("7. Add User");
		System.out.println("8. View User");
		System.out.println("9. Delete User");
		System.out.println("10. Display All Service Providers");
		System.out.println("11. Create a Service Provider");
		System.out.println("12. Delete a Service Provider");
		System.out.println("13. Quit");
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
	

	
	public static User inputUserAccount() {
		String username = Helper.readString("Enter username here >");
		String password = Helper.readString("Enter password here >");
		String email = Helper.readString("Enter email here >");
		String regex = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$";// Check
																																			// if
																																			// password
																																			// format
																																			// is
																																			// right
		String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";// To Check Email format is correct
		boolean validPassword = password.matches(regex);
		boolean validEmail = email.matches(regex1);
		User user = new User(username, password, email);
		return user;

	}
	public static void addUsers(ArrayList<User> UserList, User user) {
		User users;
		String regex = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$";// Check
		String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";// To Check Email format is correct
		boolean validPassword = user.getPassword().matches(regex);
		boolean validEmail = user.getEmail().matches(regex1);
	
		for (int i = 0; i < UserList.size(); i++) {
			users = UserList.get(i);
			if (users.getUsername().equalsIgnoreCase(user.getUsername())) {
				System.out.println("User already exists!");
				return;
			}
			else if(validPassword==false) {
				System.out.println("Passowrd format is Wrong!");
				return;
			}
			else if(validEmail==false) {
				System.out.println("Email is Wrong!");
				return;
			}

		}
		if ((user.getUsername().isEmpty()) || (user.getUsername().isEmpty())) {
			return;
		}
		System.out.println("User is successfully added!");
		UserList.add(user);
	}
	

//================================= Option 8 (View User) =================================
	public static String retrieveAllUsers(ArrayList<User> UserList) {
		String output = "";

		for (int i = 0; i < UserList.size(); i++) {
			output += String.format("%-10s %-30s\n", UserList.get(i).getUsername(), UserList.get(i).getEmail());
		}
		return output;
	}

	public static void viewAllUsers(ArrayList<User> UserList) {
		C206_CaseStudy.setHeader("USERS LIST");
		String output = String.format("%5s %15s\n", "Username", "Email Address");
		output += retrieveAllUsers(UserList);
		System.out.println(output);
	}

//================================= Option 9 (Delete User) =================================
	public static void deleteUsersMain(ArrayList<User>UserList) {
	    C206_CaseStudy.setHeader("DELETE USERS");
	    String username = Helper.readString("Enter Username > ");
	    String password = Helper.readString("Enter password > ");
	    boolean delete = C206_CaseStudy.deleteUsers(UserList, username , password);
	    if (delete) {
	        System.out.println("User deleted successfully!");
	    } 
	}
	public static boolean deleteUsers(ArrayList<User> UserList, String username, String password) {
	    for (int i = 0; i < UserList.size(); i++) {
	    	User user = UserList.get(i);
	        if (user.getUsername().equalsIgnoreCase(username)) {
	        	if(user.getPassword().equals(password)) {
	        	System.out.println(String.format("%-10s %-20s","Username","Email"));
				System.out.println(String.format("%-10s %10s\n", UserList.get(i).getUsername(),
						UserList.get(i).getEmail()));
				String check = Helper.readString("Are you sure you want to delete this User? (Y/N) > ");
				if(check.equalsIgnoreCase("Y")) {
					 UserList.remove(i);
		            return true;
				 }
				else {
			        System.out.println("User not deleted successfully!");
			    }
	        }
	        	else {
	        		System.out.println("Invalid Password!");
	        	}
	        }
	        else
	        {
	        	System.out.println("Invalid Username!");
				break;
	        }
	    }//checks username in the list

	    return false;
	}//for statement
	// ================================= Option 1 (View Service)
	// =================================
	public static String retrieveAllServices(ArrayList<RenovationServices> serviceList) {
		String output = "";
		for (int i = 0; i < serviceList.size(); i++) {
			RenovationServices service = serviceList.get(i);
			output += String.format("%-20s %-40s %-20s %-20s %-40s %-10s\n", service.getAssetTag(),
					service.getServiceProvider(), service.getServiceName(), service.getDescription(),
					service.getContactHours(), C206_CaseStudy.showAvailability(service.getAvailability()));
		}
		return output;
	}

	public static void viewAllServices(ArrayList<RenovationServices> serviceList) {
		C206_CaseStudy.setHeader("ALL SERVICES");
		String output = String.format("%-20s %-40s %-20s %-20s %-40s %-10s\\n", "ASSET TAG", "SERVICE PROVIDER",
				"SERVICE NAME", "DESCRIPTION", "CONTACT HOURS", "AVAILABLE");
		output += retrieveAllServices(serviceList);
		System.out.println(output);
	}

// ==================================== Option 2 (Add Service) ======================================
	public static RenovationServices inputService() {
		String assetTag = Helper.readString("Enter ServiceID > ");
		String serviceProvider = Helper.readString("Enter service provider > ");
		String serviceName = Helper.readString("Enter service name > ");
		String serviceHours = Helper.readString("Enter Service hours > ");
		String description = Helper.readString("Enter service description > ");
		boolean isAvailable = Helper.readBoolean("Is the service available? (Yes/No) > ");

		return new RenovationServices(assetTag, serviceProvider, serviceName, description, serviceHours, isAvailable);
	}

	public static void addService(ArrayList<RenovationServices> serviceList, RenovationServices inputService) {
		serviceList.add(inputService);
		System.out.println("Service added successfully.");
	}

	// ================================= Option 3 (Delete Service)
	// =================================
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

//================================= Option 4a (View Appointments) =================================
	public static String retrieveAppointments(ArrayList<Appointment> appointmentList) {
		String output = "";
		for (int i = 0; i < appointmentList.size(); i++) {
			Appointment appointment = appointmentList.get(i);
			output += String.format("%-10s %-15s %-7s %-12s %-8s %s%n", appointment.getAssetTag(),
					appointment.getRecipientName(), appointment.getStatus(), appointment.getDate(),
					appointment.getTime(), appointment.getServiceName());
		}
		return output;
	}

	public static void viewAppointments(ArrayList<Appointment> appointmentList) {
		C206_CaseStudy.setHeader("VIEW APPOINTMENTS");

		String output = String.format("%-10s %-15s %-7s %-12s %-8s %s%n", "APPOINTMENT ID", "RECIPIENT", "STATUS",
				"DATE", "TIME", "SERVICE NAME");

		output += retrieveAppointments(appointmentList);
		System.out.println(output);
	}

//================================= Option 4b (View Quotes) =================================

	public static String retrieveQuotes(ArrayList<Quote> quoteList) {
		String output = "";
		for (int i = 0; i < quoteList.size(); i++) {
			Quote quote = quoteList.get(i);
			output += String.format("%-10s %-15s %-30s %-15d %s%n", quote.getAssetTag(), quote.getRecipientName(),
					quote.getStatus(), quote.getContactNumber(), quote.getDescription());
		}
		return output;
	}

	public static void viewQuotes(ArrayList<Quote> quoteList) {
		C206_CaseStudy.setHeader("VIEW QUOTES");

		String output = String.format("%-10s %-15s %-30s %-15s %s%n", "QUOTE ID", "RECIPIENT", "AVAILABILITY",
				"CONTACT NUMBER", "DESCRIPTION");

		output += retrieveQuotes(quoteList);
		System.out.println(output);
	}

	// ================================= Option 5a (Add Appointment)
	// =================================
	public static Appointment inputAppointment() {
		String assertTag = Helper.readString("Enter assert tag > ");
		String recipientName = Helper.readString("Enter recipient name > ");
		String date = Helper.readString("Enter appointment date > ");
		String time = Helper.readString("Enter appointment time > ");
		String serviceName = Helper.readString("Enter service name > ");
		boolean status = Helper.readBoolean("Enter status of Appointment [Yes/No] > ");

		return new Appointment(assertTag, recipientName, status, date, time, serviceName);

	}

	public static void createAppointment(ArrayList<Appointment> appointmentList, Appointment appointment) {
		// Check for missing details
		if (appointment.getServiceName().isEmpty() || appointment.getRecipientName().isEmpty()
				|| appointment.getDate().isEmpty() || appointment.getTime().isEmpty()) {
			System.out.println("Appointment details are missing. Appointment not added.");
			return;
		}

		for (Appointment existingAppointment : appointmentList) {
			if (existingAppointment.getAssetTag().equalsIgnoreCase(appointment.getAssetTag())) {
				System.out.println("Appointment with the same asset tag already exists.");
				return; // Exit the method if appointment already exists
			}
		}

		appointmentList.add(appointment);
	}
	// ================================= Option 5b (Add Quote)
	// =================================

	// ================================= Option 6a (Delete Appointment)
	// =================================

	// ================================= Option 6b (Delete Quote)
	// =================================

	// ================================= Option 10 (View Service Providers)
	// =================================
	public static String retrieveAllServiceProvider(ArrayList<ServiceProvider> ServiceProviderList) {
		String output = "";

		for (int i = 0; i < ServiceProviderList.size(); i++) {
			output += String.format("%10s %20s\n", ServiceProviderList.get(i).getServiceProvider(),
					ServiceProviderList.get(i).getServiceProviderContactHours());
		}
		return output;
	}

	public static void viewAllServiceProvider(ArrayList<ServiceProvider> ServiceProviderList) {
		C206_CaseStudy.setHeader("SERVICE PROVIDER LIST");
		String output = String.format("%10s %20s\n", "Service Provider", "Contact Hours");
		output += retrieveAllServiceProvider(ServiceProviderList);
		System.out.println(output);
	}

	// ================================= Option 11 (Add Service Provider)
	// =================================
	public static ServiceProvider inputServiceProvider() {
		String name = Helper.readString("Enter Service Provider name > ");
		String hours = Helper.readString("Enter contact hours > ");
		ServiceProvider sp = new ServiceProvider(name, hours);
		return sp;

	}

	public static void addServiceProvider(ArrayList<ServiceProvider> ServiceProviderList, ServiceProvider sp) {
		ServiceProvider spro;
		for (int i = 0; i < ServiceProviderList.size(); i++) {
			spro = ServiceProviderList.get(i);
			if (spro.getServiceProvider().equalsIgnoreCase(sp.getServiceProvider())) {
				System.out.println("Service Provider already exists!");
				return;
			}

		}
		if ((sp.getServiceProvider().isEmpty()) || (sp.getServiceProvider().isEmpty())) {
			return;
		}
		System.out.println("Service Provider is successfully added!");
		ServiceProviderList.add(sp);
	}

	// ================================= Option 12 (Delete Service Provider)
	// =================================

	public static void deleteServiceProviderMain(ArrayList<ServiceProvider> ServiceProviderList) {
		C206_CaseStudy.setHeader("DELETE SERVICE PROVIDER");
		String spname = Helper.readString("Enter Service Provider Name > ");
		boolean isDeleted = C206_CaseStudy.deleteServiceProvider(ServiceProviderList, spname);
		if (isDeleted) {
			System.out.println("Service Provider deleted successfully!");
		}
	}

	public static boolean deleteServiceProvider(ArrayList<ServiceProvider> ServiceProviderList, String spname) {
		for (int i = 0; i < ServiceProviderList.size(); i++) {
			ServiceProvider sp = ServiceProviderList.get(i);
			if (sp.getServiceProvider().equalsIgnoreCase(spname)) {
				System.out.println(String.format("\n%10s %20s", "Service Provider", "Contact Hours"));
				System.out.println(String.format("%10s %20s\n", ServiceProviderList.get(i).getServiceProvider(),
						ServiceProviderList.get(i).getServiceProviderContactHours()));
				String check = Helper.readString("Are you sure you want to delete service provider? (Y/N) > ");
				if (check.equalsIgnoreCase("Y")) {
					ServiceProviderList.remove(i);
					return true;
				} else {
					System.out.println("Service Provider not deleted successfully!");
				}
			} else {
				System.out.println("Invalid Service Provider");
				break;
			}
		}

		return false;
	}
}