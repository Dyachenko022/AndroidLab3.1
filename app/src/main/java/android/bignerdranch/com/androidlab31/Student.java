package android.bignerdranch.com.androidlab31;

public class Student {
    int id;
    String firstName;
    String lastName;
    String middleName;
    String addingDate;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String middleName, String addingDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.addingDate = addingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(String addingDate) {
        this.addingDate = addingDate;
    }

    @Override
    public String toString() {
        return "Student " + getFirstName() + " " + getMiddleName() + " "
                + getLastName();
    }
}