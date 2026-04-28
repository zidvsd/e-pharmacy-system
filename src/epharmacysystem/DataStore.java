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
 
     int patientIdCounter     = 1;
    int prescriptionIdCounter= 1;
    int orderIdCounter       = 1;
 
}

