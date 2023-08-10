
public class RenovationServices extends ServiceProvider{ // ara

	private String assetTag;
	private String serviceName;
	private String serviceDescription;
	private boolean isAvailable;

	public RenovationServices(String serviceProvider, String serviceProviderDescription, String serviceProviderContactHours, String assetTag, String serviceName, String serviceDescription, boolean isAvailable) {
		super(serviceProvider, serviceProviderDescription, serviceProviderContactHours);
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