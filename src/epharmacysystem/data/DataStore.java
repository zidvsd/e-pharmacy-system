package epharmacysystem.data;

public class DataStore {

    // ================= SESSION =================
    public static String currentUserName;
    public static String currentUserId;
    public static String currentRole;

    // ================= USERS =================
    public static String[][] users = {
        {"u001", "drjuan", "pass123", "doctor", "Dr. Juan Santos"},
        {"u002", "drmarla", "pass123", "doctor", "Dr. Marla Reyes"},
        {"u003", "patient1", "pass123", "patient", "Juan Dela Cruz"},
        {"u004", "patient2", "pass123", "patient", "Maria Santos"},
        {"u005", "pharmacist1", "pass123", "pharmacist", "Pharmacist John"}
    };
 
    // ================= DATA TABLES =================
    public static String[][] patients = new String[50][9];
    public static int patientCount = 0;

    public static String[][] prescriptions = new String[100][8];
    public static int prescriptionCount = 0;

    public static String[][] medicines = new String[100][7];
    public static int medicineCount = 0;

    // ================= ID COUNTERS =================
    public static int patientIdCounter = 1;
    public static int prescriptionIdCounter = 1;
    public static int medicineIdCounter = 1;
    public static DataStore instance;

    // ================= INITIAL DATA BLOCK =================
    static {
        initializeSampleData();
    }

    private static void initializeSampleData() {

        patients[0] = new String[]{"P001", "Juan Dela Cruz", "45", "Male", "Ward A", "Diabetes", "u001"};
        patients[1] = new String[]{"P002", "Maria Santos", "32", "Female", "Ward B", "Hypertension", "u002"};
        patientCount = 2;

        patientIdCounter = 3; 

        prescriptions[0] = new String[]{
            "RX001", "P001", "u001", "Paracetamol", "500mg",
            "20", "2026-04-28", "Pending", "1 tablet every 6 hours"
        };

        prescriptions[1] = new String[]{
            "RX002", "P002", "u002", "Amoxicillin", "250mg",
            "12", "2026-04-28", "Completed", "3x a day after meals"
        };

        prescriptionCount = 2;
        prescriptionIdCounter = 3;

        initializeSampleMedicines();
    }

    private static void initializeSampleMedicines() {

        medicines[0] = new String[]{"MED001", "Aspirin", "100", "5.50", "2026-12-31", "Bayer", "Pain reliever"};
        medicines[1] = new String[]{"MED002", "Paracetamol", "150", "3.25", "2027-06-30", "GSK", "Fever reducer"};
        medicines[2] = new String[]{"MED003", "Amoxicillin", "80", "12.00", "2026-08-15", "Pfizer", "Antibiotic"};
        medicines[3] = new String[]{"MED004", "Ibuprofen", "120", "4.75", "2027-03-20", "J&J", "Anti-inflammatory"};

        medicineCount = 4;
        medicineIdCounter = 5;
    }
}