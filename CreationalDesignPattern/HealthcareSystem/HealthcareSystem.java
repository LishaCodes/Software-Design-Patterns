//Craetional design pattern
//Factory Pattern
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

abstract class MedicalRecord {
    private String recordID;   // Unique ID for the record
    private String type;       // Type of medical record
    private String patientName;
    private int patientAge;

    // Craeting a Constructor to initialize common fields
    public MedicalRecord(String type, String patientName, int patientAge) {
        this.recordID = UUID.randomUUID().toString(); // Generate a unique ID
        this.type = type;
        this.patientName = patientName;
        this.patientAge = patientAge;
    }

    // Getters to get properties such as ID, name etc
    public String getRecordID() {
        return recordID;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    // Display record details
    @Override
    public String toString() {
        return "MedicalRecord: [Type: " + type + ", RecordID: " + recordID +
                ", Patient: " + patientName + ", Age: " + patientAge + "]";
    }
}

// Inpatient Record
class InpatientRecord extends MedicalRecord {
    private String admissionDate;  

    public InpatientRecord(String patientName, int patientAge, String admissionDate) {
        super("Inpatient Record", patientName, patientAge);  
        this.admissionDate = admissionDate;
    }

    // Show full details for inpatient
    @Override
    public String toString() {
        return super.toString() + ", Admission Date: " + admissionDate;
    }
}

// Outpatient Record
class OutpatientRecord extends MedicalRecord {
    public OutpatientRecord(String patientName, int patientAge) {
        super("Outpatient Record", patientName, patientAge); 
    }
}

// Emergency Record
class EmergencyRecord extends MedicalRecord {
    private String emergencyArrivalTime;  

    public EmergencyRecord(String patientName, int patientAge, String emergencyArrivalTime) {
        super("Emergency Record", patientName, patientAge); 
        this.emergencyArrivalTime = emergencyArrivalTime;
    }

    // Show full details for emergency
    @Override
    public String toString() {
        return super.toString() + ", Emergency Arrival Time: " + emergencyArrivalTime;
    }
}

// create different types of records
class RecordFactory {
    public static MedicalRecord createRecord(String type, String patientName, int patientAge, String additionalInfo) {
        switch (type.toLowerCase()) {
            case "inpatient":
                return new InpatientRecord(patientName, patientAge, additionalInfo);
            case "outpatient":
                return new OutpatientRecord(patientName, patientAge);
            case "emergency":
                return new EmergencyRecord(patientName, patientAge, additionalInfo);
            default:
                throw new IllegalArgumentException("Unknown record type");
        }
    }
}

// Class to manage records (Add, View, Delete)
class RecordManagementSystem {
    private Map<String, MedicalRecord> records = new HashMap<>();  // Store records in a HashMap

    // Add a new record
    public void addRecord(MedicalRecord record) {
        records.put(record.getRecordID(), record);  // Use recordID as the key
        System.out.println("Record added: " + record);
    }

    // View all records
    public void viewAllRecords() {
        if (records.isEmpty()) {
            System.out.println("No records available.");  // If no records exist
            return;
        }
        System.out.println("Displaying all medical records:");
        for (MedicalRecord record : records.values()) {
            System.out.println(record);  // Display each record
        }
    }

    // View a specific record by ID
    public void viewRecordById(String recordID) {
        MedicalRecord record = records.get(recordID);
        if (record != null) {
            System.out.println("Record found: " + record);
        } else {
            System.out.println("Record with ID " + recordID + " not found.");  // If no record matches the ID
        }
    }

    // Delete a record by ID
    public void deleteRecord(String recordID) {
        if (records.remove(recordID) != null) {
            System.out.println("Record with ID " + recordID + " deleted.");  // If deletion is successful
        } else {
            System.out.println("Record with ID " + recordID + " not found.");  // If no record matches the ID
        }
    }
}


public class HealthcareSystem {
    public static void main(String[] args) {
        // Create an instance 
        RecordManagementSystem recordManagementSystem = new RecordManagementSystem();

        // Create records 
        MedicalRecord record1 = RecordFactory.createRecord("inpatient", "John Doe", 45, "2024-09-19");
        MedicalRecord record2 = RecordFactory.createRecord("outpatient", "Jane Smith", 30, null);
        MedicalRecord record3 = RecordFactory.createRecord("emergency", "Bob Johnson", 55, "14:35 PM");

        // Add records 
        recordManagementSystem.addRecord(record1);
        recordManagementSystem.addRecord(record2);

        // View all records
        recordManagementSystem.viewAllRecords();

        // View a specific record by its ID
        recordManagementSystem.viewRecordById(record1.getRecordID());

        // Delete a record and verify deletion
        recordManagementSystem.deleteRecord(record1.getRecordID());
        recordManagementSystem.viewAllRecords();

        // Try to view a deleted record
        recordManagementSystem.viewRecordById(record1.getRecordID());
    }
}
