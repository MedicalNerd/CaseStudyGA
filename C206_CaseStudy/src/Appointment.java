
public class Appointment extends Action {
	String date;
	String time;
	String additional_details;

	public Appointment(String assetTag, String recipientName,boolean status, String date, String time, String additional_details) {
		super(assetTag, recipientName, status);
		  this.date = date;
		  this.time = time;
		  this.additional_details = additional_details;  
		}

 

		public String getDate() {
		  return date;
		}

 

		public String getTime() {
		  return time;
		}

 

		public String getAdditional_details() {
		  return additional_details;
		}

 

	    @Override
	    public String toString() {
	        String output = super.toString();
	        output += String.format("\nDate: %s\nTime: %s\nAdditional Details: %s", getDate(), getTime(), getAdditional_details());
	        return output;
	    }
	}