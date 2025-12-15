public class Main {
    // Main method - this is where program execution begins
    public static void main(String[] args) {
        // Create a Scanner object to read user input from console
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Create manager objects to handle students and grades
        StudentManager studentManager = new StudentManager();
        GradeManager gradeManager = new GradeManager();

        // Connect the managers so they can work together
        studentManager.setGradeManager(gradeManager);

        // Create arrays of available subjects
        CoreSubject[] coreSubjects = {
                new CoreSubject("Mathematics", "MATH101"),
                new CoreSubject("English", "ENG102"),
                new CoreSubject("Science", "SCI103")
        };

        ElectiveSubject[] electiveSubjects = {
                new ElectiveSubject("Music", "MUS101"),
                new ElectiveSubject("Art", "ART102"),
                new ElectiveSubject("Physical Education", "PE103")
        };

        // Variable to control main menu loop
        boolean running = true;

        // Main program loop - continues until user chooses to exit
        while (running) {
            // Display main menu
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║   STUDENT GRADE MANAGEMENT - MAIN MENU               ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Record Grade");
            System.out.println("4. View Grade Report");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter choice: ");

            // Read user's menu choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Use switch statement to handle menu choices
            switch (choice) {
                case 1:  // ADD STUDENT
                    System.out.println("\n═══════════════════════════════════════════════════");
                    System.out.println("ADD STUDENT");
                    System.out.println("═══════════════════════════════════════════════════");
                    System.out.println();

                    // Get student information from user
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter student phone: ");
                    String phone = scanner.nextLine();

                    System.out.println();
                    System.out.println("Student type:");
                    System.out.println("1. Regular Student (Passing grade: 50%)");
                    System.out.println("2. Honors Student (Passing grade: 60%, honors recognition)");
                    System.out.println();
                    System.out.print("Select type (1-2): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    // Create appropriate student type based on choice
                    Student newStudent;
                    if (type == 1) {
                        newStudent = new RegularStudent(name, age, email, phone);
                    } else {
                        newStudent = new HonorsStudent(name, age, email, phone);
                    }

                    // Add student to manager
                    studentManager.addStudent(newStudent);

                    // Display confirmation
                    System.out.println();
                    System.out.println("✓ Student added successfully!");
                    System.out.println("  Student ID: " + newStudent.getStudentId());
                    System.out.println("  Name: " + newStudent.getName());
                    System.out.println("  Type: " + newStudent.getStudentType());
                    System.out.println("  Age: " + newStudent.getAge());
                    System.out.println("  Email: " + newStudent.getEmail());
                    System.out.println("  Passing Grade: " + newStudent.getPassingGrade() + "%");
                    System.out.println("  Status: " + newStudent.getStatus());
                    System.out.println();
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 2:  // VIEW STUDENTS
                    System.out.println();
                    System.out.print("Enter choice: 2");
                    System.out.println();
                    // Calling the viewAllStudents method to display all students
                    studentManager.viewAllStudents();
                    System.out.println();
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 3:  // RECORD GRADE
                    System.out.println();
                    System.out.print("Enter choice: 3");
                    System.out.println();
                    System.out.println();
                    System.out.println("═══════════════════════════════════════════════════");
                    System.out.println("RECORD GRADE");
                    System.out.println("═══════════════════════════════════════════════════");
                    System.out.println();

                    // Get student ID from user
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();

                    // Find the student using StudentManager
                    Student student = studentManager.findStudent(studentId);

                    // Check if student exists
                    if (student == null) {
                        System.out.println("Error: Student not found.");
                        System.out.print("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    // Display student details
                    System.out.println();
                    System.out.println("Student Details:");
                    System.out.println("Name: " + student.getName());
                    System.out.println("Type: " + student.getStudentType() + " Student");
                    System.out.println("Current Average: " + String.format("%.1f%%",
                            gradeManager.calculateOverallAverage(studentId)));
                    System.out.println("Status: " + student.getStatus());
                    System.out.println();

                    // Ask for subject type
                    System.out.println("Subject type:");
                    System.out.println("1. Core Subject (Mathematics, English, Science)");
                    System.out.println("2. Elective Subject (Music, Art, Physical Education)");
                    System.out.println();
                    System.out.print("Select type (1-2): ");
                    int subjectType = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.println();
                    Subject selectedSubject = null;

                    // Handle core subjects
                    if (subjectType == 1) {
                        // Show available core subjects
                        System.out.println("Available Core Subjects:");
                        for (int i = 0; i < coreSubjects.length; i++) {
                            System.out.println((i + 1) + ". " + coreSubjects[i].getSubjectName());
                        }
                        System.out.println();
                        System.out.print("Select subject (1-" + coreSubjects.length + "): ");
                        int subjectChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        // Get the selected subject from array (subtract 1 for zero-based index)
                        selectedSubject = coreSubjects[subjectChoice - 1];
                    } else {
                        // Handle elective subjects
                        // Show available elective subjects
                        System.out.println("Available Elective Subjects:");
                        for (int i = 0; i < electiveSubjects.length; i++) {
                            System.out.println((i + 1) + ". " + electiveSubjects[i].getSubjectName());
                        }
                        System.out.println();
                        System.out.print("Select subject (1-" + electiveSubjects.length + "): ");
                        int subjectChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        // Get the selected subject from array
                        selectedSubject = electiveSubjects[subjectChoice - 1];
                    }

                    // Get grade value from user
                    System.out.println();
                    System.out.print("Enter grade (0-100): ");
                    double gradeValue = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    // Validate the grade using the student's validateGrade method
                    if (!student.validateGrade(gradeValue)) {
                        System.out.println("Error: Invalid grade. Grade must be between 0 and 100.");
                        System.out.print("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    // Display grade confirmation before recording
                    System.out.println();
                    System.out.println("GRADE CONFIRMATION");
                    System.out.println("───────────────────────────────────────────────────");
                    System.out.println();
                    System.out.println("Grade ID: " + String.format("GRD%03d", gradeManager.getGradeCount() + 1));
                    System.out.println("Student: " + studentId + " - " + student.getName());
                    System.out.println("Subject: " + selectedSubject.getSubjectName() + " (" + selectedSubject.getSubjectType() + ")");
                    System.out.println("Grade: " + gradeValue + "%");
                    // Get current date
                    String currentDate = new java.text.SimpleDateFormat("MM-dd-yyyy").format(new java.util.Date());
                    System.out.println("Date: " + currentDate);
                    System.out.println("───────────────────────────────────────────────────");
                    System.out.println();

                    // Ask for confirmation
                    System.out.print("Confirm grade? (Y/N): ");
                    String confirmation = scanner.nextLine();

                    // Check if user confirmed
                    if (confirmation.equalsIgnoreCase("Y")) {
                        // Create a new Grade object
                        Grade newGrade = new Grade(studentId, selectedSubject, gradeValue);
                        // Add the grade to GradeManager
                        gradeManager.addGrade(newGrade);

                        System.out.println();
                        System.out.println("✓ Grade recorded successfully!");
                    } else {
                        System.out.println();
                        System.out.println("Grade recording cancelled.");
                    }

                    System.out.println();
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 4:  // VIEW GRADE REPORT
                    System.out.println();
                    System.out.print("Enter choice: 4");
                    System.out.println();
                    System.out.println();
                    System.out.println("═══════════════════════════════════════════════════");
                    System.out.println("VIEW GRADE REPORT");
                    System.out.println("───────────────────────────────────────────────────");
                    System.out.println();

                    // Get student ID from user
                    System.out.print("Enter Student ID: ");
                    String reportStudentId = scanner.nextLine();

                    // Find the student
                    Student reportStudent = studentManager.findStudent(reportStudentId);

                    // Check if student exists
                    if (reportStudent == null) {
                        System.out.println("Error: Student not found.");
                        System.out.print("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    // Display student header information
                    System.out.println();
                    System.out.println("Student: " + reportStudentId + " - " + reportStudent.getName());
                    System.out.println("Type: " + reportStudent.getStudentType() + " Student");

                    // Calculate current average
                    double currentAvg = gradeManager.calculateOverallAverage(reportStudentId);
                    System.out.println("Current Average: " + String.format("%.1f%%", currentAvg));

                    // Determine and display passing status
                    String passingStatus;
                    if (currentAvg == 0) {
                        passingStatus = "No grades recorded";
                    } else if (reportStudent.isPassing()) {
                        passingStatus = "PASSING ✓";
                    } else {
                        passingStatus = "FAILING ✗";
                    }
                    System.out.println("Status: " + passingStatus);
                    System.out.println();

                    // Get all grades for this student
                    Grade[] studentGrades = gradeManager.viewGradesByStudent(reportStudentId);

                    // Check if student has any grades
                    if (studentGrades.length == 0) {
                        System.out.println("No grades recorded for this student.");
                        System.out.println("───────────────────────────────────────────────────");
                        System.out.println();
                        System.out.print("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    // Display grade history in table format
                    System.out.println("GRADE HISTORY");
                    System.out.println("───────────────────────────────────────────────────────────────────────────────");
                    System.out.printf("%-10s | %-12s | %-20s | %-10s | %-10s%n",
                            "GRD ID", "DATE", "SUBJECT", "TYPE", "GRADE");
                    System.out.println("───────────────────────────────────────────────────────────────────────────────");

                    // Loop through grades in reverse order (newest first)
                    for (int i = studentGrades.length - 1; i >= 0; i--) {
                        Grade grades = studentGrades[i];
                        System.out.printf("%-10s | %-12s | %-20s | %-10s | %-10.1f%%%n",
                                grades.getGradeId(),
                                grades.getDate(),
                                grades.getSubject().getSubjectName(),
                                grades.getSubject().getSubjectType(),
                                grades.getGrade());
                    }
                    System.out.println("───────────────────────────────────────────────────────────────────────────────");

                    // Calculate and display averages by category
                    System.out.println();
                    System.out.println("Total Grades: " + studentGrades.length);

                    // Calculate core subjects average
                    double coreAvg = gradeManager.calculateCoreAverage(reportStudentId);
                    System.out.println("Core Subjects Average: " + String.format("%.1f%%", coreAvg));

                    // Calculate elective subjects average
                    double electiveAvg = gradeManager.calculateElectiveAverage(reportStudentId);
                    System.out.println("Elective Subjects Average: " + String.format("%.1f%%", electiveAvg));

                    // Display overall average
                    System.out.println("Overall Average: " + String.format("%.1f%%", currentAvg));
                    System.out.println();

                    // Display performance summary
                    System.out.println("Performance Summary:");

                    // Check if passing all core subjects
                    if (coreAvg >= reportStudent.getPassingGrade()) {
                        System.out.println(" Passing all core subjects");
                    } else if (coreAvg > 0) {
                        System.out.println(" Not passing core subjects (need " +
                                reportStudent.getPassingGrade() + "%)");
                    }

                    // Check overall passing status
                    if (currentAvg >= reportStudent.getPassingGrade()) {
                        System.out.println(" Meeting passing grade requirement (" +
                                reportStudent.getPassingGrade() + "%)");
                    } else if (currentAvg > 0) {
                        System.out.println(" Below passing grade requirement (" +
                                reportStudent.getPassingGrade() + "%)");
                    }

                    // For honors students, check honors eligibility
                    if (reportStudent instanceof HonorsStudent) {
                        HonorsStudent honorsStudents = (HonorsStudent) reportStudent;
                        // Update honors eligibility
                        honorsStudents.checkHonorsEligibility();
                        if (honorsStudents.isHonorsEligible()) {
                            System.out.println("Eligible for honors recognition (85%+)");
                        } else if (currentAvg > 0) {
                            System.out.println("Not eligible for honors (need 85%+)");
                        }
                    }

                    System.out.println();
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 5:  // EXIT
                    System.out.println();
                    System.out.print("Enter choice: 5");
                    System.out.println();
                    System.out.println();
                    // Display goodbye message
                    System.out.println("Thank you for using Student Grade Management System!");
                    System.out.println("Goodbye!");
                    // Set running to false to exit the loop
                    running = false;
                    break;

                default:  // INVALID CHOICE
                    // Handle invalid menu selections
                    System.out.println();
                    System.out.println("Invalid choice. Please select 1-5.");
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    break;
            }
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }


}