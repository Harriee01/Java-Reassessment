// This is the base class for all student types
// It implements the Gradable interface

public abstract class Student implements Gradable {
    // Static field; a shared counter for generating unique student IDs
    private static int studentCounter = 0;

    // PRIVATE fields - basic student information
    private String studentId;    // Unique ID (e.g., "STU001")
    private String name;         // Student's full name
    private int age;            // Student's age
    private String email;       // Student's email address
    private String phone;       // Student's phone number
    private String status;      // Current status (Active, Inactive, etc.)

    // Reference to GradeManager - needed to calculate averages
    // This will be set from the Main class
  //  protected GradeManager gradeManager;

    // This constructor initializes a new Student object
    public Student(String name, int age, String email, String phone) {
        studentCounter++;  // Increment counter for new student
        // Format student ID with leading zeros
        this.studentId = String.format("STU%03d", studentCounter);
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.status = "Active";  // New students start as Active
    }

    // Getter methods to read private fields
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    // Setter methods allow other classes to modify private fields
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to set the GradeManager reference
//    public void setGradeManager(GradeManager gm) {
//        this.gradeManager = gm;
//    }

    // Implementing interface method to validate if a grade is between 0 and 100
    @Override
    public boolean validateGrade(double grade) {
        return grade >= 0 && grade <= 100;  // Returns true if valid, false otherwise
    }

    // Implementing interface method to record a grade
    @Override
    public boolean recordGrade(double grade) {
        // Check if grade is valid before recording
        if (validateGrade(grade)) {
            return true;  // Grade is valid and can be recorded
        }
        return false;  // Grade is invalid
    }

    // Abstract methods that must be implemented by child classes
    public abstract void displayStudentDetails();  // Shows student info
    public abstract String getStudentType();       // Returns type (Regular/Honors)
    public abstract double getPassingGrade();      // Returns minimum passing grade
    public abstract double calculateAverageGrade(); // Calculates average of all grades
    public abstract boolean isPassing();           // Checks if student is passing
}

