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
	private static final int OPTION_QUIT = 7;

	public static void main(String[] args) {

		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

		serviceList.add(new RenovationServices("Provider1","House Company","09:00 to 18:00","SA1","House Renovation","Specialises in House Renovation",true));
		serviceList.add(new RenovationServices("Provider2","Lawn Company","05:00 to 18:00","SA2","Lawn Renovation","Specialises in Lawn Renovation",true));
		

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
					System.out.println("Appointment deleted")


				} else if (itemType == ACTION_TYPE_QUOTE) {
					// Delete a quote.


				} else {
					System.out.println("Invalid type");
				}

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
		System.out.println("7. Quit");
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


	//================================= Option 1 (View Service) =================================


public static String retrieveAllServices(ArrayList<RenovationServices> serviceList) {
    String output = "";
    for (int i = 0; i < serviceList.size(); i++) {
        RenovationServices service = serviceList.get(i);
        output += String.format("%-20s %-40s %-20s %-10s %-20s %-40s %-10s\n",service.getServiceProvider(),service.getServiceProviderDescription(),service.getServiceProviderContactHours(), service.getAssetTag(),
                service.getServiceName(), service.getServiceDescription(),
                C206_CaseStudy.showAvailability(service.isAvailable()));
    }
    return output;
}
public static void viewAllServices(ArrayList<RenovationServices> serviceList) {
    C206_CaseStudy.setHeader("ALL SERVICES");
    String output = String.format("%-20s %-40s %-20s %-10s %-20s %-40s %-10s\\n","PROVIDER","PROVIDER DESCRIPTION", "CONTACT HOURS", "ASSET TAG", "SERVICE NAME",
            "DESCRIPTION", "AVAILABLE");
    output += retrieveAllServices(serviceList);
    System.out.println(output);
}


	//================================= Option 2 (Add Service) =================================


public static RenovationServices inputService() {
	  String serviceProvider = Helper.readString("Enter asset tag > ");
	  String serviceDesc = Helper.readString("Enter asset tag > ");
	  String serviceHours = Helper.readString("Enter asset tag > ");
	String assetTag = Helper.readString("Enter asset tag > ");
    String serviceName = Helper.readString("Enter service name > ");
    String description = Helper.readString("Enter service description > ");
    boolean isAvailable = Helper.readBoolean("Is the service available? (Yes/No) > ");
    
    return new RenovationServices(serviceProvider, serviceDesc, serviceHours, assetTag, serviceName, description, isAvailable);
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
}
//version 2