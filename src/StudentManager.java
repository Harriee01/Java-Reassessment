// This class manages all students in the system; uses composition
public class StudentManager {
    // Private fields for managing students
    private Student[] students;      // Array to store all students
    private int studentCount;        // Current number of students
    private static final int MAX_STUDENTS = 50;  // Maximum capacity

    // REFERENCE to GradeManager - needed for calculating averages
    private GradeManager gradeManager;

    // This constructor creates empty student array
    public StudentManager() {
        students = new Student[MAX_STUDENTS];  // Initialize array with max size
        studentCount = 0;  // Start with zero students
    }

    //This method sets GradeManager reference
    public void setGradeManager(GradeManager gm) {
        this.gradeManager = gm;
    }

    //This method adds a student to the array
    public void addStudent(Student student) {
        // Check if array is not full
        if (studentCount < MAX_STUDENTS) {
            students[studentCount] = student;  // Add student at next available position
            // Set the gradeManager reference for this student
            student.setGradeManager(gradeManager);
            studentCount++;  // Increment count
        } else {
            System.out.println("Cannot add more students. Maximum capacity reached.");
        }
    }

    // Method to find a student by their ID
    public Student findStudent(String studentId) {
        // Loop through all students
        for (int i = 0; i < studentCount; i++) {
            // Check if current student's ID matches
            if (students[i].getStudentId().equals(studentId)) {
                return students[i];  // Found! Return the student
            }
        }
        return null;  // Not found, return null
    }

    // Method to display all students
    public void viewAllStudents() {
        // Check if there are any students
        if (studentCount == 0) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("\nSTUDENT LISTING");
        System.out.println("───────────────────────────────────────────────────────────────────────────────");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s%n",
                "STU ID", "NAME", "TYPE", "AVG GRADE", "STATUS");
        System.out.println("───────────────────────────────────────────────────────────────────────────────");

        // Loop through and display each student
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            // Calculate actual average grade for this student
            double avgGrade = student.calculateAverageGrade();
            // Determine status based on passing grade
            String statusText = avgGrade == 0 ? "Active" : (student.isPassing() ? "Passing" : "Failing");

            System.out.printf("%-10s | %-20s | %-10s | %-10.1f%% | %-10s%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getStudentType(),
                    avgGrade,
                    statusText);

            // Show additional info for Honors students
            if (student instanceof HonorsStudent) {
                HonorsStudent honorsStudent = (HonorsStudent) student;  // Type casting
                // Count enrolled subjects (grades) for this student
                int enrolledSubjects = gradeManager.getGradeCountForStudent(student.getStudentId());
                System.out.println("           | Enrolled Subjects: " + enrolledSubjects +
                        " | Passing Grade: " + student.getPassingGrade() + "% | Honors Eligible");
            } else {
                // Count enrolled subjects for regular student
                int enrolledSubjects = gradeManager.getGradeCountForStudent(student.getStudentId());
                System.out.println("           | Enrolled Subjects: " + enrolledSubjects +
                        " | Passing Grade: " + student.getPassingGrade() + "%");
            }
            System.out.println("───────────────────────────────────────────────────────────────────────────────");
        }

        System.out.println("\nTotal Students: " + studentCount);
        System.out.println("Average Class Grade: " + String.format("%.1f%%", getAverageClassGrade()));
    }

    // Method to calculate average grade of all students
    public double getAverageClassGrade() {
        // Check if there are no students
        if (studentCount == 0) {
            return 0.0;
        }

        double totalAverage = 0.0;  // Sum of all student averages
        int studentsWithGrades = 0;  // Count of students who have grades

        // Loop through all students and sum their averages
        for (int i = 0; i < studentCount; i++) {
            double studentAvg = students[i].calculateAverageGrade();
            // Only count students who have at least one grade
            if (studentAvg > 0) {
                totalAverage += studentAvg;
                studentsWithGrades++;
            }
        }

        // Avoid division by zero
        if (studentsWithGrades == 0) {
            return 0.0;
        }

        // Return the average of all student averages
        return totalAverage / studentsWithGrades;
    }

    // Method to get total number of students
    public int getStudentCount() {
        return studentCount;
    }
}
