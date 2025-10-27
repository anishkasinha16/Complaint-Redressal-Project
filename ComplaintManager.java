import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ComplaintManager {

    ArrayList<Complaint> complaintList;
    String filename = "complaints.txt";

    /**
     * Constructor initializes the list and loads from file.
     */
    public ComplaintManager() {
        complaintList = new ArrayList<>(); //
        loadComplaints();
    }

    /**
     * Loads the complaints from complaints.txt.
     */
    private void loadComplaints() {
        File f = new File(filename); //
        if (!f.exists()) { //
            return;
        }

        try {
            FileReader fr = new FileReader(f); //
            BufferedReader br = new BufferedReader(fr); //
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    complaintList.add(new Complaint(parts[0], parts[1], parts[2]));
                }
            }
            br.close();
            fr.close(); //
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
    }

    /**
     * Saves the entire complaint list back to complaints.txt.
     */
    private void saveComplaints() {
        try {
            FileWriter fw = new FileWriter(filename); //

            for (Complaint c : complaintList) {
                fw.write(c.toString() + "\n"); //
            }
            fw.close(); //
        } catch (IOException e) {
            System.out.println("Could not save file");
        }
    }

    /**
     * Adds a new complaint to the list.
     */
    public void addComplaint(String desc, String prio) {
        if (desc.length() == 0 || prio.length() == 0) {
            return;
        }
        Complaint newComplaint = new Complaint(desc, prio, "Open");
        complaintList.add(newComplaint);
        saveComplaints();
    }

    /**
     * Resolves a complaint by its ID (position in the list).
     */
    public boolean resolveComplaint(int id) {
        int index = id - 1;

        if (index >= 0 && index < complaintList.size()) {
            Complaint c = complaintList.get(index);
            c.status = "Resolved";
            saveComplaints();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of all complaints, sorted by priority.
     */
    public String getComplaintsString() {
        StringBuffer sb = new StringBuffer(); //

        // Loop 1: High Priority
        sb.append("--- HIGH PRIORITY ---\n");
        for (int i = 0; i < complaintList.size(); i++) {
            Complaint c = complaintList.get(i);
            if (c.priority.equals("High")) { //
                sb.append("[" + (i + 1) + "] " + c.description);
                sb.append(" - " + c.status + "\n");
            }
        }

        // Loop 2: Medium Priority
        sb.append("\n--- MEDIUM PRIORITY ---\n");
        for (int i = 0; i < complaintList.size(); i++) {
            Complaint c = complaintList.get(i);
            if (c.priority.equals("Medium") || c.priority.equals("Med")) {
                sb.append("[" + (i + 1) + "] " + c.description);
                sb.append(" - " + c.status + "\n");
            }
        }

        // Loop 3: Low Priority
        sb.append("\n--- LOW PRIORITY ---\n");
        for (int i = 0; i < complaintList.size(); i++) {
            Complaint c = complaintList.get(i);
            if (c.priority.equals("Low")) {
                sb.append("[" + (i + 1) + "] " + c.description);
                sb.append(" - " + c.status + "\n");
            }
        }

        // Loop 4 (Other) was removed.

        return sb.toString(); //
    }
}