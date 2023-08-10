
public class Request extends Action {

    private int contactNumber;
    private String description;

    public Request(String assetTag, String recipientName, String status, int contactNumber, String description) {
        super(assetTag, recipientName, status);
        this.contactNumber = contactNumber;
        this.description = description;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format("\nContact Number: %d\nDescription: %s", contactNumber, description);
    }
}

