// Represents an honors student with higher standards
public class HonorsStudent extends Student {
    // Private fields specific to honors students
    private double passingGrade;      // Minimum grade to pass (60%)
    private boolean honorsEligible;   // Whether student qualifies for honors

    // This constructor calls the parent constructor with the 'super()' keyword
    public HonorsStudent(String name, int age, String email, String phone) {
        super(name, age, email, phone);  // Initialize parent fields
        this.passingGrade = 60.0;  // Honors students need 60% to pass
        this.honorsEligible = false;  // Initially not eligible until proven
    }

    // Overriding abstract methods
    @Override
    public void displayStudentDetails() {
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getStudentType());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("Passing Grade: " + getPassingGrade() + "%");
        System.out.println("Honors Eligible: " + (honorsEligible ? "Yes" : "No"));
        System.out.println("Status: " + getStatus());
    }

    @Override
    public String getStudentType() {
        return "Honors";
    }

    @Override
    public double getPassingGrade() {
        return passingGrade;
    }

//    @Override
//    public double calculateAverageGrade() {
//        // Check if gradeManager reference exists
//        if (gradeManager == null) {
//            return 0.0;  // No grade manager available
//        }
//        // Use GradeManager to calculate overall average
//        return gradeManager.calculateOverallAverage(getStudentId());
//    }

    @Override
    public boolean isPassing() {
        double average = calculateAverageGrade();
        return average >= passingGrade;  // True if average >= 60%
    }

    // Method to check honors eligibility (average >= 85%)
    public boolean checkHonorsEligibility() {
        double average = calculateAverageGrade();
        honorsEligible = average >= 85.0;  // Update eligibility status
        return honorsEligible;
    }

    // Getter for honors eligibility
    public boolean isHonorsEligible() {
        return honorsEligible;
    }
}
