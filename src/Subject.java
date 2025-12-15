// This is an abstract class that serves as a template for all subjects
public abstract class Subject {
    // PRIVATE fields - only accessible within this class; encapsulation is applied here
    private String subjectName;  // Name of the subject
    private String subjectCode;  // Code of the subject

    // Constructor; a special method called when creating a new Subject object
    //it takes two parameters and initializes the private fields
    public Subject(String subjectName, String subjectCode) {
        this.subjectName = subjectName;  // 'this' refers to the current object
        this.subjectCode = subjectCode;
    }

    // Getter methods - allow other classes to read private fields
    public String getSubjectName() {
        return subjectName;  // Returns the value of subjectName
    }

    public String getSubjectCode() {
        return subjectCode;  // Returns the value of subjectCode
    }

    // Setter methods allow other classes to modify private fields
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;  // Updates the subjectName field
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;  // Updates the subjectCode field
    }

    // Abstract methods that must be implemented by child classes

    // This method displays the details of the subject
    public abstract void displaySubjectDetails();

    //This method returns the type of subject (Core or Elective)
    public abstract String getSubjectType();
}
