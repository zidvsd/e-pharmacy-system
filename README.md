# E-Pharmacy System

A role-based healthcare management system built with Java Swing that facilitates communication between doctors, nurses, patients, and pharmacists for managing medical prescriptions, patient records, and medicine inventory.

## What the Project Does

The **E-Pharmacy System** is a desktop application designed to streamline pharmacy operations and healthcare workflows. It provides a secure, role-based interface where different users (doctors, nurses, patients, pharmacists, and administrators) can collaborate on patient care, prescription management, and medicine inventory control.

### Key Capabilities

- **Patient Management**: Create, view, and update patient medical records
- **Prescription Management**: Generate and manage medical prescriptions with dosage instructions
- **Medicine Orders**: Process orders from healthcare providers with approval workflows
- **Inventory Control**: Manage medicine stock, pricing, and expiry dates
- **Role-Based Access Control**: Secure authentication with five distinct user roles
- **Order Approval System**: Pharmacists review and approve/reject medicine orders

## Why Use This Project

### For Healthcare Providers

- Centralized patient information accessible to authorized doctors and nurses
- Streamlined prescription workflow from creation to fulfillment
- Real-time medicine availability and order status tracking

### For Pharmacists

- Complete medicine inventory management with stock tracking
- Structured order approval process with visibility into medication requests
- Automated order status management

### For Patients

- Secure access to personal medical history and prescriptions
- View current medicine orders and their status
- Central hub for healthcare information

## Features by Role

### Doctor

- Create and manage patient records (name, age, gender, contact, address)
- Write medical prescriptions with medicine, dosage, and instructions
- View patient medical history and existing prescriptions

### Nurse

- Place medicine orders based on prescriptions
- Track order status and availability
- Manage patient order requests

### Patient

- View personal medical record and medical history
- Access active prescriptions and medicine orders
- Monitor order delivery status

### Pharmacist

- Manage medicine inventory (add, edit, delete, view stock)
- Approve or reject incoming medicine orders
- Update medicine pricing, expiry dates, and stock quantities
- Track medicine manufacturer information

### Administrator

- Manage all user accounts (create, edit, delete)
- Access system-wide reports and audit logs
- Override system operations if needed

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- NetBeans IDE 8.0 or higher (or Apache Ant for command-line builds)
- Windows, macOS, or Linux operating system

### Installation

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd EPharmacySystem
   ```

2. **Build the project**

   **Using NetBeans:**
   - Open the project in NetBeans IDE
   - Right-click the project and select "Build"
   - Or press `Shift+F11`

   **Using Ant (command line):**

   ```bash
   ant build
   ```

3. **Run the application**

   **Using NetBeans:**
   - Right-click the project and select "Run"
   - Or press `F6`

   **Using Ant:**

   ```bash
   ant run
   ```

   **Or run the compiled JAR:**

   ```bash
   java -jar dist/EPharmacySystem.jar
   ```

### Sample Login Credentials

The system comes with pre-configured sample users for testing:

| Role       | Username   | Password | Full Name        |
| ---------- | ---------- | -------- | ---------------- |
| Doctor     | drjuan     | pass123  | Dr. Juan Santos  |
| Doctor     | drmaria    | pass456  | Dr. Maria Garcia |
| Nurse      | nursealex  | pass789  | Nurse Alex       |
| Nurse      | nursepaul  | pass123  | Nurse Paul       |
| Patient    | patjohn    | pass123  | John Smith       |
| Patient    | patmary    | pass456  | Mary Johnson     |
| Pharmacist | pharmsarah | pass123  | Sarah Williams   |
| Admin      | admin      | admin123 | System Admin     |

### Usage Workflow Example

#### Doctor Workflow

1. Log in with doctor credentials
2. Create a new patient record or select existing patient
3. Write a medical prescription with medicine details
4. Submit prescription to system

#### Nurse Workflow

1. Log in with nurse credentials
2. View available prescriptions requiring orders
3. Place medicine order based on prescription
4. Monitor order approval status in pharmacist

#### Pharmacist Workflow

1. Log in with pharmacist credentials
2. Review pending medicine orders
3. Check medicine inventory for availability
4. Approve orders (deduct from stock) or reject if unavailable
5. Manage medicine inventory (add, update stock, adjust prices)

## Project Structure

```
EPharmacySystem/
├── src/
│   └── epharmacysystem/
│       ├── main/
│       │   └── EPharmacySystem.java         # Application entry point
│       ├── data/
│       │   └── DataStore.java               # Central data repository
│       └── ui/
│           ├── auth/
│           │   ├── LoginFrame.java          # Authentication & RBAC routing
│           │   └── LoginFrame.form          # NetBeans form file
│           ├── dashboard/
│           │   ├── AdminFrame.java          # Admin dashboard
│           │   ├── DoctorFrame.java         # Doctor dashboard
│           │   ├── NurseFrame.java          # Nurse dashboard
│           │   ├── PatientFrame.java        # Patient portal
│           │   ├── PharmacistFrame.java     # Pharmacist dashboard
│           │   └── *.form                   # NetBeans form files
│           ├── dialogs/
│           │   ├── AddMedicineDialog.java   # Medicine creation modal
│           │   ├── AddPatientDialog.java    # Patient creation modal
│           │   ├── AddPrescriptionDialog.java
│           │   ├── AddUserDialog.java
│           │   ├── EditMedicineDialog.java
│           │   ├── EditPatientDialog.java
│           │   ├── EditPrescriptionDialog.java
│           │   ├── ChangePasswordDialog.java
│           │   └── *.form                   # NetBeans form files
│           └── panels/
│               ├── AdminUsersPanel.java     # User management
│               ├── AdminOrdersPanel.java    # Order management
│               ├── AdminPrescriptionsPanel.java
│               ├── DoctorsOrdersPanel.java
│               ├── DoctorsPatientsPanel.java
│               ├── MyOrdersPanel.java
│               └── *.form                   # NetBeans form files
├── build.xml                                # Ant build configuration
├── manifest.mf                              # JAR manifest file
└── README.md                                # This file
```

## Data Storage

The system uses in-memory arrays for data storage (no external database). All data is initialized with sample records and persists during the application session only.

### Core Data Structures

**Users** - System accounts with role-based access

- User ID, Username, Password, Role, Full Name

**Patients** - Patient medical records

- Patient ID, Name, Age, Gender, Email, Phone Address, Medical History, Created By

**Prescriptions** - Medical prescriptions issued by doctors

- Prescription ID, Patient ID, Doctor ID, Medicine, Dosage, Quantity, Instructions, Date, Status

**Orders** - Medicine orders placed by nurses

- Order ID, Prescription ID, Nurse ID, Ordered By, Date, Status, Approval Date

**Medicines** - Pharmacy inventory

- Medicine ID, Name, Stock Quantity, Unit Price, Expiry Date, Manufacturer, Description

## Development & Architecture

### Technology Stack

- **Language**: Java 8+
- **UI Framework**: Java Swing (JFrame, JPanel, JTable, etc.)
- **IDE**: NetBeans IDE
- **Build Tool**: Apache Ant
- **Data Storage**: In-memory arrays (no database)
- **GUI Builder**: NetBeans GUI Builder (auto-generates .form files)

### Key Architecture Patterns

1. **Role-Based Access Control (RBAC)**: LoginFrame validates credentials and routes users to appropriate dashboard
2. **Centralized Data Repository**: DataStore provides single source of truth for all application data
3. **Array-Based Data Models**: Simple, lightweight data structures for sample/educational purposes
4. **Frame-Based Navigation**: Each role has its own main dashboard frame with specialized panels

### Authentication Flow

```
User Login → LoginFrame Validation → Role Lookup → Route to Appropriate Frame
                                         ↓
                    Doctor → DoctorFrame
                    Nurse → NurseFrame
                    Patient → PatientFrame
                    Pharmacist → PharmacistFrame
                    Admin → AdminFrame
```

## Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

When contributing:

- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Add comments for complex logic
- Maintain the existing code structure and folder organization
- Test thoroughly with all user roles before submitting

## Future Enhancements

The following features are planned for future releases:

- Database persistence (replacing in-memory arrays)
- Email notifications for order status changes
- Advanced search and filtering capabilities
- Medicine interactions and allergy warnings
- Prescription refill requests
- Insurance integration
- Audit trail and compliance reporting
- Multi-language support
- Mobile companion app

## Getting Help

### Documentation

- See [CODEBASE_DESCRIPTION.md](CODEBASE_DESCRIPTION.md) for detailed technical information about the project structure and current implementation status
- See [PHARMACIST_ROLE_GUIDE.md](PHARMACIST_ROLE_GUIDE.md) for information specific to pharmacist features

### Common Issues

**Build fails in NetBeans:**

- Ensure Java compiler version matches project configuration
- Check NetBeans project properties: Right-click project → Properties → Sources

**Application won't start:**

- Verify Java is properly installed: `java -version`
- Check for errors in the Output window in NetBeans

**Login credentials not working:**

- Use the exact sample credentials provided in the Installation section above
- Check that the DataStore is properly initialized in the main application

## Project Status

This project is in **active development**. The following components are complete:

- Application skeleton and basic UI
- Role-based frame structure
- Sample data initialization
- NetBeans form files for all UI components

The following components are **in progress or not yet implemented**:

- Full CRUD operations for all entities
- Login validation and RBAC routing
- Order approval workflow
- Medicine inventory management logic
- Form data binding and validation
- Error handling and user feedback

## Author

Created by **Zid** as an educational pharmacy management system demonstrating role-based desktop application design patterns.

## License

This project is provided as-is for educational purposes. See [LICENSE](LICENSE) file for details (if applicable).

---

**Last Updated**: May 2026

For the latest project updates and issues, please visit the [project repository](#).
