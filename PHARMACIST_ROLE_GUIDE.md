# Pharmacist Role Implementation Guide

## What the Pharmacist Can Do

The Pharmacist has two main responsibilities:

### 1. **Medicine Inventory Management (CRUD)**

- **Create** new medicines (add to stock)
- **Read** medicines (view inventory, check stock levels)
- **Update** medicine details (price, dosage, expiry date, stock quantity)
- **Delete** medicines from inventory

### 2. **Order Approval System**

- View all **pending** medicine orders from Doctors and Nurses
- **Approve** orders (status changes from "pending" to "approved")
- **Reject** orders (with optional reason)
- Track approved orders and their **delivery status**

---

## Required Changes to DataStore

### Add This to DataStore.java:

```java
// Medicine Inventory Array
String[][] medicines = new String[100][7];
int medicineCount = 0;
int medicineIdCounter = 1;

// Sample medicines data
public void initializeMedicines() {
    medicines[0] = {"MED001", "Aspirin", "100", "5.50", "2026-12-31", "Bayer Inc", "Pain reliever"};
    medicines[1] = {"MED002", "Paracetamol", "150", "3.25", "2027-06-30", "GSK", "Fever reducer"};
    medicines[2] = {"MED003", "Amoxicillin", "80", "12.00", "2026-08-15", "Pfizer", "Antibiotic"};
    medicineCount = 3;
}
```

### Array Structure for Medicines:

```
Column 0: Medicine ID        (String) e.g., "MED001"
Column 1: Medicine Name      (String) e.g., "Aspirin"
Column 2: Stock Quantity     (String) e.g., "100"
Column 3: Unit Price         (String) e.g., "5.50"
Column 4: Expiry Date        (String) e.g., "2026-12-31"
Column 5: Manufacturer       (String) e.g., "Bayer Inc"
Column 6: Description        (String) e.g., "Pain reliever"
```

---

## PharmacistFrame Components Needed

### Main Dashboard:

- **Top Section**: Welcome label with pharmacist name
- **Two Tab Panels or Side Navigation**:
  1. **Inventory Management Tab**
     - Table showing all medicines
     - Search/filter by medicine name
     - Buttons: Add, Edit, Delete, View Details
  2. **Order Approval Tab**
     - Table showing pending orders (status = "pending")
     - Columns: Order ID, Patient Name, Medicine, Quantity, Ordered By, Date
     - Buttons: Approve, Reject, View Details

---

## Additional Frames to Create

### 1. **MedicineFrame** (Add/Edit Modal)

**Purpose**: Add new medicine or edit existing medicine

**Components**:

- Medicine Name (TextField)
- Stock Quantity (TextField)
- Unit Price (TextField)
- Expiry Date (JDateChooser)
- Manufacturer (TextField)
- Description (TextArea)
- Buttons: Save, Cancel

**Logic**:

- If editing: pre-fill current values
- Generate Medicine ID automatically
- Update stock when saved
- Validate expiry date > today

---

### 2. **ApproveOrderFrame** (Approval Modal)

**Purpose**: Review and approve/reject orders

**Components**:

- Order Details (read-only display)
  - Order ID
  - Patient Name
  - Medicine Name
  - Quantity Requested
  - Ordered By (Doctor/Nurse name)
  - Order Date
- Medicine Stock Check
  - Current Stock Display (auto-populated from medicines array)
  - "Stock Sufficient?" indicator (green/red)
- Approval Section
  - Radio buttons: Approve / Reject
  - Notes TextArea (optional reason for rejection)
  - Buttons: Submit, Cancel

**Logic**:

- Check if medicine stock >= quantity requested
- If approved: decrement medicine stock, set order status = "approved"
- If rejected: set order status = "rejected", store reason
- Log approval date/time

---

## Workflow Examples

### Scenario 1: Add Medicine to Inventory

1. Pharmacist clicks "Add Medicine" button
2. MedicineFrame opens (empty form)
3. Fills in details: Aspirin, 100 units, $5.50, 2026-12-31, Bayer, "Pain reliever"
4. Clicks "Save"
5. New medicine added to medicines array with auto-generated ID
6. Table refreshes to show new medicine
7. MedicineFrame closes

### Scenario 2: Approve Medicine Order

1. Pharmacist sees pending order in "Order Approval" tab
2. Order: 50x Aspirin for Patient Juan (ordered by Dr. Juan)
3. Pharmacist clicks "Approve" button
4. ApproveOrderFrame opens showing:
   - Order details
   - Current Aspirin stock: 100 units
   - "Stock Sufficient? YES" (green)
5. Pharmacist clicks "Approve" and "Submit"
6. System updates:
   - Order status = "approved"
   - Aspirin stock decreases from 100 to 50
   - Approval timestamp recorded
7. Order moves to "Approved" view (or disappears from "Pending")

### Scenario 3: Reject Medicine Order

1. Nurse orders 200x Medicine X
2. Pharmacist checks inventory
3. Only 50 units available
4. Pharmacist clicks "Reject" button
5. Enters reason: "Insufficient stock, available: 50/200"
6. Clicks "Submit"
7. Order status = "rejected" with reason stored
8. Nurse sees order as "rejected" in their dashboard

---

## Integration Points with Other Roles

### Doctor → Pharmacist

- Doctor creates prescription for Patient
- Nurse sees prescription and places order
- Pharmacist approves order and dispenses medicine

### Nurse → Pharmacist

- Nurse places medicine order from prescription
- Pharmacist reviews and approves
- Nurse sees approval and logs delivery

### Patient → Pharmacist

- Patient can view order status
- Can see when medicine is approved and ready

---

## Testing Checklist for Pharmacist Role

- [ ] Add medicine to inventory
- [ ] Edit medicine details
- [ ] Delete medicine from inventory
- [ ] View all medicines with stock levels
- [ ] Search/filter medicines by name
- [ ] Approve order (sufficient stock)
- [ ] Approve order (insufficient stock - reject)
- [ ] Reject order with reason
- [ ] Stock decreases when order approved
- [ ] Expiry date validation works
- [ ] Auto-generated Medicine IDs are unique
- [ ] Can view order details
- [ ] Login routes Pharmacist correctly to PharmacistFrame
- [ ] All operations persist during session (until app close)
