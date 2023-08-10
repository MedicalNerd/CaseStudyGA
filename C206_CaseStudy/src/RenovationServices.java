
public class RenovationServices extends ServiceProvider{ // araa

	private String assetTag;
	private String serviceName;
	private String serviceDescription;
	private boolean isAvailable;

	public RenovationServices(String assetTag, String serviceProvider, String serviceName, String serviceDescription, String serviceProviderContactHours, boolean isAvailable) {
		super(serviceProvider, serviceProviderContactHours);
		this.assetTag = assetTag;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.isAvailable = isAvailable;
	}

	public String getAssetTag() {
		return assetTag;
	}

	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}

//Version 5a