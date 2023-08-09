
public class Action extends RenovationServices {
    
    private String recipientName;
    private boolean status;
    
    public Action(String assetTag, String recipientName, boolean status) {
        super(assetTag, "");  // Call the constructor of the superclass with assetTag and an empty serviceName
        this.recipientName = recipientName;
        this.status = status;
    }
    
    public String getRecipientName() {
        return recipientName;
    }
    
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("\nRecipient Name: " + recipientName + "\nStatus: " + status);
    }
}
