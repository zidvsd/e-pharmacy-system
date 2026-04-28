# E-Pharmacy System - Codebase Description

## Project Overview

This is a **Java Swing-based E-Pharmacy System** with role-based access control (RBAC). The system manages patient records, medical prescriptions, medicine orders, and pharmacy operations across five user roles: Doctor, Nurse, Patient, Pharmacist, and Admin.

---

## Technology Stack

- **Language**: Java
- **UI Framework**: Swing (JFrame, JPanel, JTable, JButton, etc.)
- **IDE**: NetBeans
- **Build Tool**: Ant (NetBeans build system)
- **Data Storage**: In-memory arrays (no database)

---

## File Structure

```
EPharmacySystem/
├── build.xml                          # Ant build configuration
├── manifest.mf                        # JAR manifest
├── src/epharmacysystem/
│   ├── EPharmacySystem.java          # Main entry point
│   ├── DataStore.java                # Central data repository (arrays)
│   ├── LoginFrame.java               # Login UI + RBAC router
│   ├── LoginFrame.form               # NetBeans form file
│   ├── MainFrame.java                # Doctor's dashboard
│   ├── MainFrame.form                # Form file
│   ├── DoctorFrame.java              # Doctor-specific features
│   ├── DoctorFrame.form              # Form file
│   ├── NurseFrame.java               # Nurse-specific features
│   ├── NurseFrame.form               # Form file
│   ├── PatientFrame.java             # Patient portal
│   ├── PatientFrame.form             # Form file
│   ├── PharmacistFrame.java          # Pharmacist dashboard
│   ├── PharmacistFrame.form          # Form file
│   ├── *.png                         # UI icons (login-icon, remove, image-gallery, etc.)
├── nbproject/                         # NetBeans project configuration
└── test/                              # Test directory (empty)
```

---

## Current Implementation Status

### ✅ Completed

- **DataStore.java**: Data arrays structure initialized
  - Users array (7 sample users: 2 doctors, 2 nurses, 2 patients, 1 pharmacist)
  - Patients array (capacity: 50 records)
  - Prescriptions array (capacity: 100 records)
  - Orders array (capacity: 100 records)
  - ID counters for auto-increment

- **LoginFrame.java**: Basic login UI created
  - Username/password fields
  - Login button
  - Sample credentials pre-filled

- **Frame Stubs**: All role-based frames created with minimal placeholders
  - MainFrame, DoctorFrame, NurseFrame, PatientFrame, PharmacistFrame

### ⚠️ Partially Implemented

- MainFrame: Patient input form (Name, Email, Phone, Address)
  - Add/Clear/Delete buttons visible
  - Table structure for displaying patients
  - Logic not connected

### ❌ Not Yet Implemented

- Login validation logic
- RBAC routing (directing users to correct frame)
- Data persistence methods
- All frame-specific functionalities
- Patient CRUD operations
- Prescription creation/management
- Order management
- Medicine inventory (new for Pharmacist)
- Order approval workflow

---

## Data Structures (Arrays in DataStore)

### 1. Users Array (users[][])

```
Column 0: User ID        (String) e.g., "u001"
Column 1: Username       (String) e.g., "drjuan"
Column 2: Password       (String) e.g., "pass123"
Column 3: Role           (String) e.g., "doctor", "nurse", "patient", "pharmacist"
Column 4: Full Name      (String) e.g., "Dr. Juan Santos"
```

### 2. Patients Array (patients[][])

```
Column 0: Patient ID        (String)
Column 1: Name              (String)
Column 2: Age               (String)
Column 3: Gender            (String)
Column 4: Email             (String)
Column 5: Phone             (String)
Column 6: Address           (String)
Column 7: Medical History   (String)
Column 8: Created By (Doctor ID) (String)
```

### 3. Prescriptions Array (prescriptions[][])

```
Column 0: Prescription ID    (String)
Column 1: Patient ID        (String)
Column 2: Doctor ID         (String)
Column 3: Medicine Name     (String)
Column 4: Dosage            (String)
Column 5: Quantity          (String)
Column 6: Instructions      (String)
Column 7: Date              (String)
Column 8: Status            (String) e.g., "active", "completed"
```

### 4. Orders Array (orders[][])

```
Column 0: Order ID          (String)
Column 1: Prescription ID   (String)
Column 2: Nurse ID          (String)
Column 3: Ordered By ID     (String) e.g., "u003" (nurse or doctor)
Column 4: Order Date        (String)
Column 5: Status            (String) e.g., "pending", "approved", "delivered"
Column 6: Approval Date     (String)
```

### 5. Medicines Array (NEW - needed for Pharmacist)

```
Column 0: Medicine ID       (String)
Column 1: Medicine Name     (String)
Column 2: Stock Quantity    (String)
Column 3: Unit Price        (String)
Column 4: Expiry Date       (String)
Column 5: Manufacturer      (String)
Column 6: Description       (String)
```

---

## Role-Based Features

### 👨‍⚕️ **Doctor** (drjuan / drmarla)

- View patient list
- Create/edit patient records
- Create prescriptions for patients
- View own prescriptions
- Approve/reject medicine orders

### 👩‍⚕️ **Nurse** (nurseana / nursebob)

- View patient list
- Place medicine orders (from prescriptions)
- Track order status
- Mark orders as delivered

### 👤 **Patient** (patient1 / patient2)

- View own profile
- View own medical history
- View own prescriptions
- Track medicine order status

### 💊 **Pharmacist** (pharmacist1) [NEW ROLE]

- **Medicine Management (CRUD)**
  - Add new medicines to inventory
  - Edit medicine details
  - Delete medicines from inventory
  - View medicine stock levels
  - Track expiry dates
- **Order Approval**
  - View pending medicine orders
  - Approve/reject orders from nurses/doctors
  - Update order status
  - Generate dispensing records

---

## Component Dependencies

```
LoginFrame
  └─> DataStore (validation + routing)
      └─> DoctorFrame / NurseFrame / PatientFrame / PharmacistFrame / MainFrame
          └─> DataStore (read/write operations)
```

All frames depend on **DataStore** for:

- User authentication
- Reading patient/prescription/order data
- Writing new records
- Updating existing records

---

## Additional Frames Needed (Not Yet Created)

1. **AddEditPatientFrame** - Modal for doctor to add/edit patients
2. **CreatePrescriptionFrame** - Modal for doctor to create prescriptions
3. **PlaceOrderFrame** - Modal for nurse to place medicine orders
4. **MedicineFrame** - Modal for pharmacist to manage medicine inventory
5. **ApproveOrderFrame** - Modal for pharmacist to approve/reject orders

---

## Build Plan (With Pharmacist Role)

**Recommended build order for team division:**

### Phase 1: Foundation (Do Together)

1. **DataStore.java** ⭐ **CRITICAL - Do First**
   - Add medicines array for Pharmacist CRUD
   - Implement CRUD methods for all entities
   - Test data population

### Phase 2: Authentication & Routing

2. **LoginFrame** + Login Logic
   - Validate credentials against users array
   - Route to correct frame based on role
   - Handle failed login

### Phase 3: Role-Specific Features (Parallel)

3. **DoctorFrame** + **AddEditPatientFrame** + **CreatePrescriptionFrame** (1-2 people)
   - Doctor's dashboard
   - Patient add/edit modal
   - Prescription creation modal
   - View patient list & prescriptions

4. **NurseFrame** + **PlaceOrderFrame** (1 person)
   - Nurse's dashboard
   - Order placement modal
   - View order status

5. **PatientFrame** (1 person)
   - Patient portal
   - View medical history
   - View prescriptions & orders

6. **PharmacistFrame** + **MedicineFrame** + **ApproveOrderFrame** (1-2 people) ⭐ **NEW**
   - Pharmacist's dashboard
   - Medicine inventory CRUD modal
   - Order approval modal
   - Medicine stock management

### Phase 4: Integration & Testing

7. Complete data flow between all frames
8. Test RBAC routing
9. Test all CRUD operations
10. Integrate approval workflows

---

## Key Notes for Development

### Important Rules:

- **DataStore is the single source of truth** - All changes must go through it
- **ID generation** - Use the incrementing counters (patientIdCounter, prescriptionIdCounter, etc.)
- **No database** - All data is in memory (volatile - resets on app close)
- **Swing UI** - NetBeans generates the .form files; edit in GUI Builder when possible
- **RBAC** - LoginFrame determines which role frame to open

### Testing Tips:

- Use the pre-defined test users in DataStore
- Test each role separately (login with different credentials)
- Add print statements to track data flow
- Test edge cases (empty fields, duplicate names, etc.)

### Future Enhancements (Post-MVP):

- Implement database persistence (MySQL/SQL Server)
- Add user registration/signup
- Implement password hashing (MD5/BCrypt)
- Add audit logging
- Implement transaction rollback
- Add search/filter functionality
- Email notifications for orders
- Report generation

---

## Development Workflow

1. **Team Coordination**: Use DataStore as the shared interface
2. **Integration**: Test between frames regularly
3. **Testing**: Each person tests their own role first, then cross-team testing
4. **Git/Version Control**: Commit after each major feature
5. **Documentation**: Keep method signatures consistent across team
