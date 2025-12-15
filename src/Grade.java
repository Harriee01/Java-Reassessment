// This class represents a single grade record for a student in a subject
public class Grade {
    // Static field shared by all Grade objects (used for generating unique IDs)
    private static int gradeCounter = 0;

    // Private fields - specific to each Grade object
    private String gradeId;      // Unique identifier (e.g., "GRD001")
    private String studentId;    // ID of the student who earned this grade
    private Subject subject;     // The subject this grade is for
    private double grade;        // The numerical grade (0-100)
    private String date;         // Date the grade was recorded

    // This constructor creates a new Grade object
    public Grade(String studentId, Subject subject, double grade) {
        gradeCounter++;  // Increment the counter for each new grade
        // Format the grade ID with leading zeros (e.g., GRD001, GRD002)
        this.gradeId = String.format("GRD%03d", gradeCounter);
        this.studentId = studentId;
        this.subject = subject;
        this.grade = grade;
        // Get current date in format: MM-dd-yyyy
        this.date = new java.text.SimpleDateFormat("MM-dd-yyyy").format(new java.util.Date());
    }

    // Getter methods for all private fields
    public String getGradeId() {
        return gradeId;
    }

    public String getStudentId() {
        return studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }

    // This method displays all grade information in a formatted way
    public void displayGradeDetails() {
        System.out.println("Grade ID: " + gradeId);
        System.out.println("Student: " + studentId);
        System.out.println("Subject: " + subject.getSubjectName() + " (" + subject.getSubjectType() + ")");
        System.out.println("Grade: " + grade + "%");
        System.out.println("Date: " + date);
    }

    //This method converts numerical grade to letter grade
    public String getLetterGrade() {
        // Uses if-else chain to determine letter grade
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
}
