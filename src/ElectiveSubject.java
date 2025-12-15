// This class represents optional subjects students can choose
public class ElectiveSubject extends Subject {
    // Private field specific to ElectiveSubject
    private boolean mandatory;  // Always false for elective subjects

    // This constructor calls parent constructor using 'super' keyword
    public ElectiveSubject(String subjectName, String subjectCode) {
        super(subjectName, subjectCode);  // Calls parent constructor
        this.mandatory = false;  // Elective subjects are not mandatory
    }

    // Overriding abstract method to display subject details
    @Override
    public void displaySubjectDetails() {
        System.out.println("Subject: " + getSubjectName() + " (" + getSubjectType() + ")");
    }

    // Overriding abstract method to return "Elective"
    @Override
    public String getSubjectType() {
        return "Elective";
    }

    // This method checks if elective is mandatory (always false)
    public boolean isMandatory() {
        return false;
    }
}

