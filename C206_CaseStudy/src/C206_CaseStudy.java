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
	
	//Ara--------------------------------------------------------
		private static final int OPTION_VIEW_SERVICEPROVIDER = 10;
		private static final int OPTION_CREATE_SERVICEPROVIDER = 11;
		private static final int OPTION_DELETE_SERVICEPROVIDER = 12;
		//-----------------------------------------------------------
		
	private static final int OPTION_VIEW_REQUESTS = 13;
	private static final int OPTION_ADD_REQUESTS = 14;
	private static final int OPTION_DELETE_REQUESTS = 15;
	private static final int OPTION_QUIT = 16;

	public static void main(String[] args) {

		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();

		ArrayList<User> UserList = new ArrayList<User>();
		ArrayList<ServiceProvider> ServiceProviderList = new ArrayList<ServiceProvider>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Quote> quoteList = new ArrayList<Quote>();
		ArrayList<Request> requestList = new ArrayList<Request>();


		serviceList.add(new RenovationServices("SA1", "Johns House Renos", "House Renovation",
				"Specialises in House Renovation", "09:00 to 18:00", true));
		serviceList.add(new RenovationServices("SA2", "Daisy Lawn Renos", "Lawn Renovation",
				"Specialises in Lawn Renovation", "08:00 to 18:00", true));
		ServiceProviderList.add(new ServiceProvider("Johns House Renos", "09:00 to 18:00"));
		ServiceProviderList.add(new ServiceProvider("Daisy Lawn Renos", "08:00 to 18:00"));
		UserList.add(new User("Tom", "Password12@", "Tom@gmail.com"));
		UserList.add(new User("Mary", "Password@12", "Mary@gmail.com"));
		UserList.add(new User("Kafka", "YES123@oo", "Mommy@gmail.com"));
		appointmentList.add(new Appointment("AP1", "Kafka", "Pending", "2023-07-25", "10.00", "Johns House Renos"));
		appointmentList.add(new Appointment("AP2", "Mary", "Pending", "2023-07-25", "11.00", "Daisy Lawn Renos"));
		quoteList.add(new Quote("Q1", "John", "Approved", 12345678, "House renovation quote"));
		quoteList.add(new Quote("Q2", "Jane", "Approved", 98765432, "Lawn renovation quote"));
		requestList.add(new Request("RT1", "Alice", "Pending", 123456789, "Description 1"));
		requestList.add(new Request("RT2", "Bob", "Pending", 987654321, "Description 2"));
		requestList.add(new Request("RT3", "Carol", "Pending", 567890123, "Description 3"));
//YL
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
					Quote qp = inputQuote();
					C206_CaseStudy.createQuote(quoteList, qp);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_DELETE_ACTION) {
				//

				int itemType = Helper.readInt("Appointment[1] or Quote[2]? > ");

				if (itemType == ACTION_TYPE_APPOINTMENT) {
					// Delete an appointment.
					C206_CaseStudy.deleteAppointmentMenu(appointmentList);
					System.out.println("Appointment deleted");

				} else if (itemType == ACTION_TYPE_QUOTE) {
					// Delete a quote.
					C206_CaseStudy.deleteQuoteMenu(quoteList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_ADDUSER) {
				doAddUser(UserList);//YL
			} else if (option == OPTION_VIEWUSERS) {
				viewAllUsers(UserList);//YL
			} else if (option == OPTION_DELETEUSERS) {
				doDeleteUser(UserList);//YL
			} else if (option == OPTION_VIEW_SERVICEPROVIDER) {
				//Ara
				// View all services providers currently available.
				C206_CaseStudy.viewAllServiceProvider(ServiceProviderList);

			}else if (option == OPTION_CREATE_SERVICEPROVIDER) {
				//Ara
				// Create a service provider.
				ServiceProvider newServiceProvider = C206_CaseStudy.inputServiceProvider();
	            C206_CaseStudy.addServiceProvider(ServiceProviderList, newServiceProvider);
			}
			else if (option == OPTION_DELETE_SERVICEPROVIDER) {
				//Ara
				// Delete a service providers.
				C206_CaseStudy.deleteServiceProviderMain(ServiceProviderList);
			} else if (option == OPTION_VIEW_REQUESTS) {
	            viewRequests(requestList);
	        } else if (option == OPTION_ADD_REQUESTS) {
	            Request newRequest = inputRequest();
	            addRequest(requestList, newRequest);
	            System.out.println("Request added successfully.");
	        } else if (option == OPTION_DELETE_REQUESTS) {
	            removeRequestMenu(requestList);
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}


	/**
	 * @param UserList
	 */
	private static void doDeleteUser(ArrayList<User> UserList) {
		C206_CaseStudy.deleteUsersMain(UserList);
	}

	/**
	 * @param UserList
	 */
	private static void doAddUser(ArrayList<User> UserList) {
		User user =inputUserAccount();
		addUsers(UserList,user);
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
		System.out.println("13. View Requests");
		System.out.println("14. Add Requests");
		System.out.println("15. Remove Requests");
		System.out.println("16. Quit");
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

	//================================= Option 7  (Add User Validation) =================================//YL
	

	
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
			boolean validPassword = doPasswordValidation(password, regex);
			boolean validEmail = doEmailValidation(email, regex1);
			User user = new User(username, password, email);
			return user;

		}

		/**
		 * @param password
		 * @param regex
		 * @return
		 */
		private static boolean doPasswordValidation(String password, String regex) {
			return password.matches(regex);
		}

		/**
		 * @param email
		 * @param regex1
		 * @return
		 */
		private static boolean doEmailValidation(String email, String regex1) {
			return email.matches(regex1);
		}
		public static void addUsers(ArrayList<User> UserList, User user) {
			User users;
			String regex = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$";// Check
			String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";// To Check Email format is correct
			boolean validPassword = doPasswordValidation(user, regex);
			boolean validEmail = doEmailValidation(user, regex1);
		
			int size = UserList.size();
			for (int i = 0; i < size; i++) {
				users = UserList.get(i);
				if (doCheckUsername(user, users)) {
					System.out.println("User already exists!");
					return;
				}
				else if(validPassword==false) {
					System.out.println("Password format is Wrong!");
					return;
				}
				else if(validEmail==false) {
					System.out.println("Email is Wrong!");
					return;
				}

			}
			if (doCheckIfEmpty(user) || doCheckIfEmpty(user)) {
				return;
			}
			System.out.println("User is successfully added!");
			UserList.add(user);
		}

		/**
		 * @param user
		 * @return
		 */
		private static boolean doCheckIfEmpty(User user) {
			return doGetUsername(user).isEmpty();
		}

		/**
		 * @param user
		 * @param users
		 * @return
		 */
		private static boolean doCheckUsername(User user, User users) {
			return doGetUsername(users).equalsIgnoreCase(doGetUsername(user));
		}

		/**
		 * @param user
		 * @param regex1
		 * @return
		 */
		private static boolean doEmailValidation(User user, String regex1) {
			return doGetEmail(user).matches(regex1);
		}

		/**
		 * @param user
		 * @param regex
		 * @return
		 */
		private static boolean doPasswordValidation(User user, String regex) {
			return doGetPassword(user).matches(regex);
		}

		/**
		 * @param user
		 * @return
		 */
		private static String doGetPassword(User user) {
			return user.getPassword();
		}

	//================================= Option 8 (View User) =================================//YL
		public static String retrieveAllUsers(ArrayList<User> UserList) {
			String output = "";

			int size = UserList.size();
			for (int i = 0; i < size; i++) {
				output += String.format("%-10s %-30s\n", doGetUsername(UserList, i), doGetEmail(UserList, i));
			}
			return output;
		}

		/**
		 * @param UserList
		 * @param i
		 * @return
		 */
		private static String doGetEmail(ArrayList<User> UserList, int i) {
			return UserList.get(i).getEmail();
		}

		/**
		 * @param UserList
		 * @param i
		 * @return
		 */
		private static String doGetUsername(ArrayList<User> UserList, int i) {
			return UserList.get(i).getUsername();
		}

		public static void viewAllUsers(ArrayList<User> UserList) {
			C206_CaseStudy.setHeader("USERS LIST");
			String output = String.format("%5s %15s\n", "Username", "Email Address");
			output += retrieveAllUsers(UserList);
			System.out.println(output);
		}

	//================================= Option 9 (Delete User) =================================//YL
		public static void deleteUsersMain(ArrayList<User>UserList) {
		    C206_CaseStudy.setHeader("DELETE USERS");
		    String username = Helper.readString("Enter Username > ");
		    String password = Helper.readString("Enter password > ");
		    boolean delete = doDeleteUser(UserList, username, password);
		    if (delete) {
		        System.out.println("User deleted successfully!");
		    } 
		}

		/**
		 * @param UserList
		 * @param username
		 * @param password
		 * @return
		 */
		private static boolean doDeleteUser(ArrayList<User> UserList, String username, String password) {
			return C206_CaseStudy.deleteUsers(UserList, username , password);
		}
		public static boolean deleteUsers(ArrayList<User> UserList, String username, String password) {
		    int size = UserList.size();
			for (int i = 0; i < size; i++) {
		    	User user2 = UserList.get(i);
				User user = user2;
		        String username2 = doGetUsername(user);
				if (doIgnoreCase(username, username2)) {
		        	if(doGetPassword(user).equals(password)) {
		        	System.out.println(String.format("%-10s %-20s","Username","Email"));
					System.out.println(String.format("%-10s %10s\n", doGetUsername(user2),
							doGetEmail(user2)));
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

		/**
		 * @param user2
		 * @return
		 */
		private static String doGetEmail(User user2) {
			return user2.getEmail();
		}

		/**
		 * @param user2
		 * @return
		 */
		private static String doGetUsername(User user2) {
			return user2.getUsername();
		}

		/**
		 * @param username
		 * @param username2
		 * @return
		 */
		private static boolean doIgnoreCase(String username, String username2) {
			return username2.equalsIgnoreCase(username);
		}

	// ================================= Option 1 (View Service)
	// =================================
		public static String retrieveAllServices(ArrayList<RenovationServices> serviceList) {
			String output = String.format("%-20s %-40s %-20s %-20s %-40s %-10s\n", "ASSET TAG", "SERVICE PROVIDER",
					"SERVICE NAME", "DESCRIPTION", "CONTACT HOURS", "AVAILABLE");
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
			String output = retrieveAllServices(serviceList);
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
		String output = String.format("%-20s %-20s %-15s %-12s %-12s %-25s\n", "ASSET TAG", "CUSTOMER NAME",
	            "STATUS", "DATE", "TIME", "SERVICE NAME");
		for (int i = 0; i < appointmentList.size(); i++) {
			Appointment appointment = appointmentList.get(i);
			output += String.format("%-20s %-20s %-15s %-12s %-12s %-25s\n", appointment.getAssetTag(),
					appointment.getRecipientName(), appointment.getStatus(), appointment.getDate(),
					appointment.getTime(), appointment.getAdditional_details());
		}
		return output;
	}

 

	public static void viewAppointments(ArrayList<Appointment> appointmentList) {
		C206_CaseStudy.setHeader("VIEW APPOINTMENTS");

 

		String output = retrieveAppointments(appointmentList);
		System.out.println(output);
	}

 

//================================= Option 4b (View Quotes) =================================

	public static String retrieveQuotes(ArrayList<Quote> quoteList) {
		String output = String.format("%-10s %-15s %-15s %-15s %-30s\n", "QUOTE ID", "CUSTOMER NAME",
	            "STATUS", "CONTACT NUMBER", "DESCRIPTION");
		for (int i = 0; i < quoteList.size(); i++) {
			Quote quote = quoteList.get(i);
			output += String.format("%-10s %-15s %-15s %-15s %-30s\n", quote.getAssetTag(), quote.getRecipientName(),
					quote.getStatus(), quote.getContactNumber(), quote.getDescription());
		}
		return output;
	}

 

	public static void viewQuotes(ArrayList<Quote> quoteList) {
		C206_CaseStudy.setHeader("VIEW QUOTES");
		String output = retrieveQuotes(quoteList);
		System.out.println(output);
	}

	// ================================= Option 5a (Add Appointment) ======================================
	public static Appointment inputAppointment() {
		String assertTag = Helper.readString("Enter assert tag > ");
		String recipientName = Helper.readString("Enter recipient name > ");
		String date = Helper.readString("Enter appointment date > ");
		String time = Helper.readString("Enter appointment time > ");
		String serviceName = Helper.readString("Enter service name > ");
		String status = "Pending";

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
		System.out.println("Appointment added");
	}
	// ================================= Option 5b (Add Quote)===========================================

	public static Quote inputQuote() {
	    String assetTag = Helper.readString("Enter asset tag > ");
	    String recipientName = Helper.readString("Enter recipient name > ");
	    String description = Helper.readString("Enter description > ");
	    int contactNumber = Helper.readInt("Enter contact number > ");
	    String status = "Pending";
	    
	    return new Quote(assetTag, recipientName, status, contactNumber, description);
	    
	}
	public static void createQuote(ArrayList<Quote> quoteList, Quote quote) {
		// Check for missing details
		if (quote.getAssetTag().isEmpty() || quote.getRecipientName().isEmpty()
				|| quote.getDescription().isEmpty() || quote.getContactNumber() == 0) {
			System.out.println("Quote details are missing. Quote not added.");
			return;
		}

		for (Quote existingQuote : quoteList) {
			if (existingQuote.getAssetTag().equalsIgnoreCase(quote.getAssetTag())) {
				System.out.println("Quote with the same asset tag already exists.");
				return; // Exit the method if appointment already exists
			}
		}

		quoteList.add(quote);
		System.out.println("Quote added.");
	}

	// ================================= Option 6a (Delete Appointment) =================================

	public static boolean deleteAppointment(ArrayList<Appointment> appointmentList, String assetTag) {
		for (int i = 0; i < appointmentList.size(); i++) {
			Appointment appointment = appointmentList.get(i);
			if (appointment.getAssetTag().equalsIgnoreCase(assetTag)) {
				appointmentList.remove(i);
				return true;
			}
		}
		return false;
	}

	public static void deleteAppointmentMenu(ArrayList<Appointment> appointmentList) {
		String assetTag = Helper.readString("Enter ID of the appointment to delete > ");
		boolean isDeleted = deleteAppointment(appointmentList, assetTag);

		if (isDeleted) {
			System.out.println("Appointment deleted successfully.");
		} else {
			System.out.println("Appointment not found or unable to delete.");
		}
	}

	// ================================= Option 6b (Delete Quote) ==========================================
	
	public static void deleteQuoteMenu(ArrayList<Quote> quoteList) {
	    String assetTag = Helper.readString("Enter asset tag of the quote to delete > ");
	    boolean isDeleted = deleteQuote(quoteList, assetTag);
	    
	    if (isDeleted) {
	        System.out.println("Quote deleted successfully.");
	    } else {
	        System.out.println("Quote not found or unable to delete.");
	    }
	}


	public static boolean deleteQuote(ArrayList<Quote> quoteList, String assetTag) {
	    for (int i = 0; i < quoteList.size(); i++) {
	        Quote quote = quoteList.get(i);
	        if (quote.getAssetTag().equalsIgnoreCase(assetTag)) {
	            quoteList.remove(i);
	            return true;
	        }
	    }
	    return false;
	}

////Ara---------------------------------------------------------------------------------------------------------------------
	//================================= Option 10 (View Service Providers) =================================
		public static String retrieveAllServiceProvider(ArrayList<ServiceProvider> ServiceProviderList) {
			String output = "";

	 

			for (int i = 0; i < ServiceProviderList.size(); i++)
			{
				output += String.format("%-20s %-40s\n", ServiceProviderList.get(i).getServiceProvider(),
				ServiceProviderList.get(i).getServiceProviderContactHours());
			}
			return output;
		}

	 

		public static void viewAllServiceProvider(ArrayList<ServiceProvider> ServiceProviderList) {
			C206_CaseStudy.setHeader("SERVICE PROVIDER LIST");
			String expectedOutput = String.format("%-20s %-40s\n", "SERVICE PROVIDER", "CONTACT HOURS");
			expectedOutput += retrieveAllServiceProvider(ServiceProviderList);	
			System.out.println(expectedOutput);
		}

		//================================= Option 11 (Add Service Provider) =================================
		
				public static ServiceProvider inputServiceProvider() {
					String name = Helper.readString("Enter Service Provider name > ");
					String hours = Helper.readString("Enter contact hours > ");
					ServiceProvider sp= new ServiceProvider(name, hours);
					return sp;	 

				}
				
				public static void addServiceProvider(ArrayList<ServiceProvider> ServiceProviderList, ServiceProvider sp) {
					ServiceProvider spro;
					for(int i = 0; i < ServiceProviderList.size(); i++) {
						spro = ServiceProviderList.get(i);
						if (spro.getServiceProvider().equalsIgnoreCase(sp.getServiceProvider()) )
						{
							System.out.println("Service Provider already exists!");
							return;
						}

					}
					if ((sp.getServiceProvider().isEmpty()) || (sp.getServiceProvider().isEmpty()) ) {
						return;
					}
					System.out.println("Service Provider is successfully added!");
		            ServiceProviderList.add(sp);
				}	 
		
				//================================= Option 12  (Delete Service Provider) =================================

				public static void deleteServiceProviderMain(ArrayList<ServiceProvider>ServiceProviderList) {
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
				        	System.out.println(String.format("\n%-20s %-40s","Service Provider","Contact Hours"));
							System.out.println(String.format("%-20s %-40s\n", ServiceProviderList.get(i).getServiceProvider(),
									ServiceProviderList.get(i).getServiceProviderContactHours()));
							String check = Helper.readString("Are you sure you want to delete service provider? (Y/N) > ");
							if(check.equalsIgnoreCase("Y")) {
								 ServiceProviderList.remove(i);
					            return true;
							 }
							else {
						        System.out.println("Service Provider not deleted successfully!");
						        return false;
						    }
				        }
				    }
				    System.out.println("Invalid Service Provider");
				    return false;
				}
			
		//---------------------------------------------------------------------------------------------------------------------
	
		// ================================= Option 13  (View Requests) ================================
	    public static void viewRequests(ArrayList<Request> requestList) {
	        setHeader("VIEW REQUESTS");

	        String output = String.format("%-10s %-15s %-7s %-12s %s%n", "ASSET TAG", "RECIPIENT", "STATUS",
	                "CONTACT NUMBER", "DESCRIPTION");

	        output += retrieveRequests(requestList);
	        System.out.println(output);
	    }

	    public static String retrieveRequests(ArrayList<Request> requestList) {
	        String output = "";
	        for (Request request : requestList) {
	            output += String.format("%-10s %-15s %-7s %-12d %s%n", request.getAssetTag(),
	                    request.getRecipientName(), request.getStatus(), request.getContactNumber(),
	                    request.getDescription());
	        }
	        return output;
	    }

	    // ================================= Option 14 (Add Requests) ==================================
	    public static Request inputRequest() {
	        String assetTag = Helper.readString("Enter asset tag > ");
	        String recipientName = Helper.readString("Enter recipient name > ");
	        int contactNumber = Helper.readInt("Enter contact number > ");
	        String description = Helper.readString("Enter description > ");
	        String status = "Pending";

	        return new Request(assetTag, recipientName, status, contactNumber, description);
	    }

	    public static void addRequest(ArrayList<Request> requestList, Request request) {
	        requestList.add(request);
	        System.out.println("Request added successfully.");
	    }

	    // ================================= Option 15 (Remove Requests)================================
	    public static boolean removeRequest(ArrayList<Request> requestList, String assetTag) {
	        for (int i = 0; i < requestList.size(); i++) {
	            Request request = requestList.get(i);
	            if (request.getAssetTag().equalsIgnoreCase(assetTag)) {
	                requestList.remove(i);
	                return true;
	            }
	        }
	        return false;
	    }

	    public static void removeRequestMenu(ArrayList<Request> requestList) {
	        String assetTag = Helper.readString("Enter asset tag of the request to remove > ");
	        boolean isRemoved = removeRequest(requestList, assetTag);

	        if (isRemoved) {
	            System.out.println("Request removed successfully.");
	        } else {
	            System.out.println("Request not found or unable to remove.");
	        }
	    }
	}
