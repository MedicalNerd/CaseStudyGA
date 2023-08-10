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

		serviceList.add(new RenovationServices("SA1","House Renovation","Specialises in House Renovation","09:00 to 18:00",true));

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW_SERVICE) {
				// View all services currently available.


			}else if (option == OPTION_CREATE_SERVICE) {
			   // Create a service.
			}
			else if (option == OPTION_DELETE_SERVICE) {
			  // Delete a service.
			}
			else if (option == OPTION_VIEW_ACTION) {
			 // Display Appointments and Quotes
			}
			else if (option == OPTION_ADD_ACTION) {
				// 

				
				int itemType = Helper.readInt("Appointment[1] or Quote[2]? > ");

				if (itemType == ACTION_TYPE_APPOINTMENT) {
					// Add an appointment.


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
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
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

	//================================= Option 2 (Add Service) =================================
	
	//================================= Option 3 (Delete Service)  =================================

	//================================= Option 4 (View Action) =================================
public static String retrieveAction(ArrayList<Action> actionList) {
	String output = "";	
	for (int i = 0; i < actionList.size(); i++) {
		output += String.format("%-10s %-30s", actionList.get(i).getRecipientName(),
				actionList.get(i).getStatus());
}
return output;
}

public static void viewAllServiceProvider(ArrayList<Action> actionList) {
C206_CaseStudy.setHeader("ACTION LIST");
String output = String.format("%-10s %-30s\n","Recipent Name","Status");
 output += retrieveAction(actionList);	
System.out.println(output);
}}
	//================================= Option 5 (Add Action) =================================
	
	//================================= Option 6  (Delete Action) =================================

//version 1
