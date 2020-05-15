package android.bignerdranch.com.androidlab31;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
    int id;
    String fullName;
    String addingDate;

    public Student(int id, String fullName, String addingDate) {
        this.id = id;
        this.fullName = fullName;
        this.addingDate = addingDate;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(String addingDate) {
        this.addingDate = addingDate;
    }
}