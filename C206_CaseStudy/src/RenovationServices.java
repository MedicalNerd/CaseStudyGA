
public class RenovationServices extends ServiceProvider {

	private String assetTag;
	private String serviceName;
	private String serviceDescription;
	private String contactHours;
	private boolean isAvailable;

	public RenovationServices(String assetTag,String serviceProvider, String serviceName, String serviceDescription, String contactHours,
			 boolean isAvailable) {
		super(serviceProvider,"");
		this.assetTag = assetTag;
		this.serviceName = serviceName;

		this.serviceDescription = serviceDescription;
		this.contactHours = contactHours;
		this.isAvailable = isAvailable;
	}
	public RenovationServices(String assetTag,String serviceProvider, String serviceName) {
		super(serviceProvider, "");
		this.assetTag = assetTag;
		this.serviceName = serviceName;
	}

	public String toString() {
	    String output = String.format(
	        "Asset Tag: %s\nName: %s\nDescription: %s\nContact Hours: %s\nIs Available: %b",
	        assetTag, serviceName, serviceDescription, contactHours, isAvailable
	    );
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

//Version 5a