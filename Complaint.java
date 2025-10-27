public class Complaint {
    String description;
    String priority;
    String status;

    /**
     * Constructor to initialize the complaint.
     */
    Complaint(String description, String priority, String status) {
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns a string for saving to the file.
     */
    public String toString() {
        return this.description + "," + this.priority + "," + this.status;
    }
}