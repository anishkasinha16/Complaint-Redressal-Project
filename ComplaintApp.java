import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ComplaintApp {

    JFrame frame;
    JLabel descL, prioL, resolveL, statusL;
    JTextField descF, prioF, resolveF;
    JButton b_submit, b_resolve;

    JTextArea displayArea;
    JScrollPane scrollPane;

    ComplaintManager manager;

    /**
     * Constructor sets up the GUI.
     */
    public ComplaintApp() {
        manager = new ComplaintManager();

        frame = new JFrame("Complaint Redressal System"); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        frame.setSize(450, 520);
        frame.setLayout(null); //

        descL = new JLabel("Complaint:");
        descF = new JTextField();
        prioL = new JLabel("Priority (High/Med/Low):");
        prioF = new JTextField();
        b_submit = new JButton("Submit Complaint");

        resolveL = new JLabel("Enter ID to Resolve:");
        resolveF = new JTextField();
        b_resolve = new JButton("Resolve");

        statusL = new JLabel("Welcome. System ready.");

        displayArea = new JTextArea();
        scrollPane = new JScrollPane(displayArea);

        // Positioning (slightly misaligned)
        descL.setBounds(20, 20, 100, 20);
        descF.setBounds(160, 22, 250, 20);
        prioL.setBounds(22, 50, 150, 20);
        prioF.setBounds(160, 53, 250, 20);
        b_submit.setBounds(20, 90, 390, 30);

        resolveL.setBounds(20, 140, 140, 20);
        resolveF.setBounds(160, 142, 100, 20);
        b_resolve.setBounds(270, 141, 140, 25);

        statusL.setBounds(20, 175, 350, 20);
        scrollPane.setBounds(20, 210, 390, 250);

        // Add components to frame
        frame.add(descL);
        frame.add(descF);
        frame.add(prioL);
        frame.add(prioF);
        frame.add(b_submit);
        frame.add(resolveL);
        frame.add(resolveF);
        frame.add(b_resolve);
        frame.add(statusL);
        frame.add(scrollPane);

        // --- Event Listeners ---

        b_submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //
                String desc = descF.getText();
                String prio = prioF.getText();

                // Redundant "amateur" check
                if(desc.isEmpty() || prio.isEmpty()) {
                    statusL.setText("Error: Both fields are required.");
                    return;
                }

                manager.addComplaint(desc, prio);
                statusL.setText("Complaint logged. ID: " + manager.complaintList.size());
                descF.setText("");
                prioF.setText("");

                refreshDisplay();
            }
        });

        b_resolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //
                String idStr = resolveF.getText();

                try {
                    int id = Integer.parseInt(idStr); //

                    boolean success = manager.resolveComplaint(id);

                    if (success) {
                        statusL.setText("Complaint #" + id + " marked as resolved.");
                        refreshDisplay();
                    } else {
                        statusL.setText("Error: Complaint ID " + id + " not found.");
                    }
                    resolveF.setText("");

                } catch (NumberFormatException ex) {
                    // Handle exception
                    statusL.setText("Error: ID must be a number.");
                }
            }
        });

        frame.setVisible(true); //

        refreshDisplay(); // Load data on start
    }

    /**
     * A method to update the text area.
     */
    private void refreshDisplay() {
        String complaintText = manager.getComplaintsString();
        displayArea.setText(complaintText);
    }

    /**
     * Main method to run the application.
     */
    public static void main(String[] args) {
        new ComplaintApp(); //
    }
}