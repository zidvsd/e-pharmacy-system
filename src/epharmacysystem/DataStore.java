/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package epharmacysystem;

/**
 *
 * @author Zid
 */
public class DataStore {
    String[][] users = {
        {"u001", "drjuan",    "pass123", "doctor",  "Dr. Juan Santos"},
        {"u002", "drmarla",   "pass123", "doctor",  "Dr. Marla Reyes"},
        {"u003", "nurseana",  "pass123", "nurse",   "Nurse Ana Cruz"},
        {"u004", "nursebob",  "pass123", "nurse",   "Nurse Bob Lim"},
        {"u005", "patient1",  "pass123", "patient", "Juan Dela Cruz"},
        {"u006", "patient2",  "pass123", "patient", "Maria Santos"},
        {"u007", "pharmacist1",  "pass123", "pharmacist", "Pharmacist John"},
    };
    
    String[][] patients = new String[50][9];
    int patientCount = 0;
    
    String[][] prescriptions = new String[100][9];
    int prescriptionCount = 0;
 
    String[][] orders = new String[100][7];
    int orderCount = 0;
 
    String[][] medicines = new String[100][7];
    int medicineCount = 0;
    
    // ID Counters
    int patientIdCounter      = 1;
    int prescriptionIdCounter = 1;
    int orderIdCounter        = 1;
    int medicineIdCounter     = 1;
    
    // Constructor - Initialize sample data
    public DataStore() {
        initializeSampleMedicines();
    }
    
    // Initialize sample medicines for testing
    private void initializeSampleMedicines() {
        medicines[0] = new String[]{"MED001", "Aspirin", "100", "5.50", "2026-12-31", "Bayer Inc", "Pain reliever & fever reducer"};
        medicines[1] = new String[]{"MED002", "Paracetamol", "150", "3.25", "2027-06-30", "GSK", "Acetaminophen - fever & pain"};
        medicines[2] = new String[]{"MED003", "Amoxicillin", "80", "12.00", "2026-08-15", "Pfizer", "Antibiotic - bacterial infections"};
        medicines[3] = new String[]{"MED004", "Ibuprofen", "120", "4.75", "2027-03-20", "Johnson & Johnson", "Anti-inflammatory pain reliever"};
        medicineCount = 4;
        medicineIdCounter = 5;
    }
}

