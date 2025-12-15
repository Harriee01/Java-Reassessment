// This class manages all grades in the system; uses composition
public class GradeManager {
    // Private fields
    private Grade[] grades;          // Array to store all grades
    private int gradeCount;          // Current number of grades
    private static final int MAX_GRADES = 200;  // Maximum capacity

    // This constructor initializes a new GradeManager object
    public GradeManager() {
        grades = new Grade[MAX_GRADES];  // Initialize array
        gradeCount = 0;  // Start with zero grades
    }

    //This method adds a grade to the array
    public void addGrade(Grade grade) {
        if (gradeCount < MAX_GRADES) {
            grades[gradeCount] = grade;  // Add grade
            gradeCount++;  // Increment count
        } else {
            System.out.println("Cannot add more grades. Maximum capacity reached.");
        }
    }

    //This method gets all grades for a specific student
    public Grade[] viewGradesByStudent(String studentId) {
        // First, count how many grades this student has
        int count = 0;
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId().equals(studentId)) {
                count++;
            }
        }

        // Create array of exact size needed
        Grade[] studentGrades = new Grade[count];
        int index = 0;

        // Fill the array with student's grades
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId().equals(studentId)) {
                studentGrades[index] = grades[i];
                index++;
            }
        }

        return studentGrades;  // Return array of student's grades
    }

    //This method calculates the average of core subject grades
    public double calculateCoreAverage(String studentId) {
        double total = 0;  // Sum of all core grades
        int count = 0;     // Number of core grades

        // Loop through all grades
        for (int i = 0; i < gradeCount; i++) {
            // Check if grade belongs to this student
            if (grades[i].getStudentId().equals(studentId)) {
                // Check if it is a core subject
                if (grades[i].getSubject() instanceof CoreSubject) {
                    total += grades[i].getGrade();  // Add to total
                    count++;  // Increment count
                }
            }
        }

        // Avoid division by zero
        if (count == 0) return 0.0;
        return total / count;  // Return average
    }

    // This method calculates the average of elective subject grades
    public double calculateElectiveAverage(String studentId) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId().equals(studentId)) {
                if (grades[i].getSubject() instanceof ElectiveSubject) {
                    total += grades[i].getGrade();
                    count++;
                }
            }
        }

        if (count == 0) return 0.0;
        return total / count;
    }

    // This method calculates the overall average (all subjects)
    public double calculateOverallAverage(String studentId) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId().equals(studentId)) {
                total += grades[i].getGrade();
                count++;
            }
        }

        if (count == 0) return 0.0;
        return total / count;
    }

    //This method gets the count of grades for a specific student
    public int getGradeCountForStudent(String studentId) {
        int count = 0;
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId().equals(studentId)) {
                count++;
            }
        }
        return count;
    }

    //This method gets the total number of grades
    public int getGradeCount() {
        return gradeCount;
    }
}