
public class ServiceProvider { // ara
	
	private String serviceProvider;
	private String serviceProviderDescription;
	private String serviceProviderContactHours;

	public ServiceProvider(String serviceProvider, String serviceProviderDescription, String serviceProviderContactHours) {
		this.serviceProvider = serviceProvider;
		this.serviceProviderDescription = serviceProviderDescription;
		this.serviceProviderContactHours = serviceProviderContactHours;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getServiceProviderDescription() {
		return serviceProviderDescription;
	}

	public void setServiceProviderDescription(String serviceProviderDescription) {
		this.serviceProviderDescription = serviceProviderDescription;
	}

	public String getServiceProviderContactHours() {
		return serviceProviderContactHours;
	}

	public void setServiceProviderContactHours(String serviceProviderContactHours) {
		this.serviceProviderContactHours = serviceProviderContactHours;
	}

	

}
