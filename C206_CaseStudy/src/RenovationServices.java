
public class RenovationServices {

	private String assetTag;
	private String serviceName;
	private String serviceDescription;
	private String contactHours;
	private boolean isAvailable;

	public RenovationServices(String assetTag, String serviceName, String serviceDescription, String contactHours,
			boolean isAvailable) {
		this.assetTag = assetTag;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.contactHours = contactHours;
		this.isAvailable = isAvailable;
	}

	public RenovationServices(String assetTag, String serviceName) {
		this.assetTag = assetTag;
		this.serviceName = serviceName;
	}

	public String toString() {
		String output = String.format("Asset Tag: " + assetTag + " \n Name: " + serviceName + " \n Description: "
				+ serviceDescription + " \n Contact Hours " + contactHours + " \n Is Available: " + isAvailable);
		return output;
	}

	public String getAssetTag() {
		return assetTag;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getDescription() {
		return serviceDescription;
	}

	public String getContactHours() {
		return contactHours;
	}

	public boolean getAvailability() {
		return isAvailable;
	}

	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public void setContactHours(String contactHours) {
		this.contactHours = contactHours;
	}

	public void setAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
