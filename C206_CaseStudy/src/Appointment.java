public class Appointment extends Action {
	String date;
	String time;
	String service_name;
	
	public Appointment(String assetTag, String recipientName,boolean status, String date, String time, String service_name) {
		super(assetTag, recipientName, status);
		  this.date = date;
		  this.time = time;
		  this.service_name = service_name;  
		}

		public String getDate() {
		  return date;
		}

		public String getTime() {
		  return time;
		}

		public String getService_name() {
		  return service_name;
		}

	    @Override
	    public String toString() {
	        String output = super.toString(); // If you want to include the superclass's toString() result
	        output += String.format("\nDate: %s\nTime: %s\nService_name: %s", getDate(), getTime(), getService_name());
	        return output;
	    }
	}

//Version 3



