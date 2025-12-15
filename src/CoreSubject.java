// This class inherits from Subject and represents mandatory subjects

public class CoreSubject extends Subject {
    // Private field specific to CoreSubject
    private boolean mandatory;  // Always true for core subjects

    // This constructor calls parent constructor using 'super' keyword
    public CoreSubject(String subjectName, String subjectCode) {
        super(subjectName, subjectCode);  // Calls Subject constructor
        this.mandatory = true;  // Core subjects are always mandatory
    }

    // Overriding the abstract method from Subject class
    @Override
    public void displaySubjectDetails() {
        // Prints subject information
        System.out.println("Subject: " + getSubjectName() + " (" + getSubjectType() + ")");
    }

    // Overriding the abstract method to return "Core"
    @Override
    public String getSubjectType() {
        return "Core";
    }

    // Method specific to CoreSubject to check if it is mandatory
    public boolean isMandatory() {
        return true;  // Core subjects are always mandatory
    }
}