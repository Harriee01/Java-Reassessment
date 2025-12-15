// This interface defines what it means for something to be "gradable"
// Any class that implements this interface must provide these two methods
// An example of abstraction

public interface Gradable {
    // Method to record a grade for a student
    boolean recordGrade(double grade);// Returns true if grade was recorded successfully, false otherwise

    // Method to check if a grade is valid (between 0 and 100)
    boolean validateGrade(double grade);// Returns true if valid, false if not
}