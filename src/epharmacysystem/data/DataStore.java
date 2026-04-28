package epharmacysystem.data;

public class DataStore {

    public static String[][] users = {
        {"u001", "drjuan", "pass123", "doctor", "Dr. Juan Santos"},
        {"u002", "drmarla", "pass123", "doctor", "Dr. Marla Reyes"},
        {"u003", "nurseana", "pass123", "nurse", "Nurse Ana Cruz"},
        {"u004", "nursebob", "pass123", "nurse", "Nurse Bob Lim"},
        {"u005", "patient1", "pass123", "patient", "Juan Dela Cruz"},
        {"u006", "patient2", "pass123", "patient", "Maria Santos"},
        {"u007", "pharmacist1", "pass123", "pharmacist", "Pharmacist John"}
    };

    public static String[][] patients = new String[50][9];
    public static int patientCount = 0;

    public static String[][] prescriptions = new String[100][7];
    public static int prescriptionCount = 0;

    public static String[][] orders = new String[100][7];
    public static int orderCount = 0;

    public static String[][] medicines = new String[100][7];
    public static int medicineCount = 0;

    // ID Counters
    public static int patientIdCounter = 1;
    public static int prescriptionIdCounter = 1;
    public static int orderIdCounter = 1;
    public static int medicineIdCounter = 1;

    public DataStore() {
        initializeSampleMedicines();
        patients[0] = new String[]{"P001", "Juan Dela Cruz", "45", "Male", "Ward A", "Diabetes"};
        patients[1] = new String[]{"P002", "Maria Santos", "32", "Female", "Ward B", "Hypertension"};
        patientCount = 2;

        prescriptions[0] = new String[]{
            "RX001", "P001", "Dr. Juan Santos", "Paracetamol", "500mg",
            "1 tablet every 6 hours", "2026-04-28", "Pending"
        };

        prescriptions[1] = new String[]{
            "RX002", "P002", "Dr. Marla Reyes", "Amoxicillin", "250mg",
            "3x a day after meals", "2026-04-28", "Completed"
        };

        prescriptionCount = 2;
    }

    private void initializeSampleMedicines() {
        medicines[0] = new String[]{"MED001", "Aspirin", "100", "5.50", "2026-12-31", "Bayer Inc", "Pain reliever"};
        medicines[1] = new String[]{"MED002", "Paracetamol", "150", "3.25", "2027-06-30", "GSK", "Fever reducer"};
        medicines[2] = new String[]{"MED003", "Amoxicillin", "80", "12.00", "2026-08-15", "Pfizer", "Antibiotic"};
        medicines[3] = new String[]{"MED004", "Ibuprofen", "120", "4.75", "2027-03-20", "J&J", "Anti-inflammatory"};

        medicineCount = 4;
        medicineIdCounter = 5;
    }
}