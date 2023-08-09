
public class Appointment {
	String date;
	String time;
	String additional_details;
	
	public Appointment(String date, String time, String additional_details) {
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

		public String toString() {
		  String output = super.toString();
		  output = String.format("Date: " + getDate() + "\n Time: " + getTime() + "\n Additional Details: " + getAdditional_details());
		  
		  return output;

        }
}
