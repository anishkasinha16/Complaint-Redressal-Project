Simple Complaint Redressal System

A simple Java Swing application for tracking and managing complaints. It allows users to submit a new complaint with a priority level (High, Medium, Low) and mark existing complaints as "Resolved" using their ID.

The application saves all data to a local complaints.txt file and automatically refreshes the display, which is sorted by priority.

This project is built using basic Java Swing components [cite: FirstSwingExample.java, SwingApp.java], java.io for file handling [cite: ReadWriteDemo1.java], and an ArrayList for in-memory storage [cite: Module 2 (2).pptx].

Features

Submit New Complaints: Add a new complaint with a description and a priority level (e.g., "High", "Medium", "Low").

Resolve Complaints: Mark a complaint as "Resolved" by entering its unique ID.

Prioritized View: The main display list is automatically sorted to show "High" priority items first, followed by "Medium" and "Low" [cite: ComplaintManager.java].

Persistent Storage: All complaints are saved to complaints.txt after every change and reloaded when the app starts [cite: ReadWriteDemo1.java, ComplaintManager.java].

Auto-Refresh: The complaint list in the GUI updates automatically after a new submission or resolution.

Error Handling: Includes basic error handling for non-numeric ID inputs [cite: Module 3 (2).pptx].

File Structure

ComplaintApp.java: The main class that builds the Java Swing GUI (JFrame, JButton, etc.) and handles all button clicks [cite: ComplaintApp.java, FirstSwingExample.java].

ComplaintManager.java: Handles all the application logic, such as adding/resolving complaints, saving to the file, loading from the file, and sorting the list for display [cite: ComplaintManager.java].

Complaint.java: A simple class to store the data for a single complaint (description, priority, status) [cite: Complaint.java].

complaints.txt: The plain text file used to save and load the complaints (this file is created automatically).

How to Run

You must have the Java Development Kit (JDK) installed on your computer to run this.

Save the Files
Save all three .java files (ComplaintApp.java, ComplaintManager.java, Complaint.java) into the same folder.

Open a Terminal
Open your Command Prompt (on Windows) or Terminal (on Mac/Linux).

Navigate to the Folder
Use the cd command to go to the directory where you saved the files.

# Example:
cd C:\Users\YourName\Desktop\ComplaintProject


Compile the Code
Run the Java compiler (javac) to compile all three files. You must run this command from inside the folder.

javac ComplaintApp.java ComplaintManager.java Complaint.java


Run the Program
After compiling, run the main application using the java command.

java ComplaintApp


The GUI window should now open. A complaints.txt file will be created in the same folder as soon as you submit your first complaint.
