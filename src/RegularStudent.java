// Represents a regular student with standard grading requirements
public class RegularStudent extends Student {
    // Private field specific to regular students
    private double passingGrade;  // Minimum grade to pass (50%)

    // This constructor calls the parent constructor with the 'super()' keyword
    public RegularStudent(String name, int age, String email, String phone) {
        super(name, age, email, phone);  // Initialize parent class fields
        this.passingGrade = 50.0;  // Set passing grade to 50%
    }

    // Overriding abstract methods from Student class
    @Override
    public void displayStudentDetails() {
        // Print all student information
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getStudentType());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("Passing Grade: " + getPassingGrade() + "%");
        System.out.println("Status: " + getStatus());
    }

    @Override
    public String getStudentType() {
        return "Regular";
    }

    @Override
    public double getPassingGrade() {
        return passingGrade;  // Returns 50.0
    }

    // Calculate average grade using GradeManager
    @Override
    public double calculateAverageGrade() {
        // Check if gradeManager reference exists
        if (gradeManager == null) {
            return 0.0;  // No grade manager available
        }
        // Use GradeManager to calculate overall average
        return gradeManager.calculateOverallAverage(getStudentId());
    }

    // Checking if student is passing based on average
    @Override
    public boolean isPassing() {
        double average = calculateAverageGrade();
        return average >= passingGrade;  // True if average >= 50%
    }
}
