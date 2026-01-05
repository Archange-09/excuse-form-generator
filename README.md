# TSU Excuse Letter Generator

A Java Swing desktop application designed for **Tarlac State University (TSU)** students to automate the creation of official excuse letters. The system ensures that document formatting, university branding, and specific academic policies are consistently applied.

OOP CASE STUDY V2

## 🛠 Technical Stack

* **Language:** Java (JDK 8 or higher)
* **Library:** Swing & AWT (Abstract Window Toolkit)
* **Rendering:** HTML/CSS integration via `JTextPane` for document styling.
* **Layouts:** `BorderLayout` with "Symmetry Struts" for precise header alignment.

## 📂 Project Structure

* **`InputForm.java`**: The main user interface for data entry. It includes fields for student details, duration of absence, and nature of the request.
* **`OutputForm.java`**: The document preview engine. It renders the information into a formal letterhead with TSU's official Maroon and Gold colors.
* **`StudentInfo.java`**: A data transfer object (DTO) that carries student data between the input and output windows.

## 🎨 Official Branding Specifications

The application strictly adheres to TSU’s visual identity:

* **Maroon:** `RGB(128, 0, 0)` / `#800000`
* **Gold:** `RGB(252, 186, 3)` / `#FCBA03`
* **Logo Proportion:** The system scales the official  px seal to a crisp  px header icon.

## 🚀 Setup & Installation

### 1. File Path Configuration

To display the university seal, ensure your image is named:
`Tarlac_State_University_Seal.png`

### 2. Compilation

Compile all source files from your project root:

```bash
javac StudentInfo.java InputForm.java OutputForm.java

```

### 3. Run Application

```bash
java InputForm

```

## 📝 Usage

1. **Input Data:** Fill in the student's name, ID number, and program details.
2. **Date Selection:** Use the dropdown menus to select the "From" and "To" dates of absence.
3. **Nature of Absence:** Choose the category (Health, School-Related, or Miscellaneous) to trigger specific university policy instructions.
4. **Preview & Print:** Click **Generate Official Excuse Form**. In the preview window, use **Print Document** to send the letter to a physical printer or save it as a PDF.

## ⚖️ Features & Logic

* **Dynamic Document Titles:** Automatically switches between "MEDICAL EXCUSE LETTER" and "OFFICIAL EXCUSE LETTER" based on user selection.
* **Reference Tracking:** Generates a unique `REF-YYYYMMDD-###` code for every document.
* **Symmetrical Header:** Utilizes a hidden horizontal strut logic to ensure university text remains perfectly centered regardless of the logo's width.
* **Official Seal Area:** Includes a dashed Maroon border for physical registrar stamping.

