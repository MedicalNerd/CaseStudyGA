//Sharul Iman

public class Action extends RenovationServices {
    
    private String recipientName;
    private String status;
    


    public Action(String assetTag, String recipientName, String status) {

        super(assetTag, "","");
        this.recipientName = recipientName;
        this.status = status;
    }
    
    public String getRecipientName() {
        return recipientName;
    }
    
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        String superToString = super.toString();
        String output = String.format(
            "%s\nRecipient Name: %s\nStatus: %b",
            superToString, recipientName, status
        );
        return output;
    }
}
