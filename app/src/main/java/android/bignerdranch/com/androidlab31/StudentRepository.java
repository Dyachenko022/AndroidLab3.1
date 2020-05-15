package android.bignerdranch.com.androidlab31;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static StudentRepository instance;
    SQLiteDatabase database;
    List<Student> students = new ArrayList<>();
    DBHelper helper;
    private StudentRepository(Context context) {
        helper = new DBHelper(context);
        database = helper.getWritableDatabase();
        String order = "ID ASC";
        Cursor cursor = database.query("Students", null,null, null, null, null, order, null);
        if(cursor.moveToFirst()) {
            int idColumn = cursor.getColumnIndex("ID");
            int nameColumn = cursor.getColumnIndex("FullName");
            int dateColumn = cursor.getColumnIndex("AddingDate");
            do {
                Student student = new Student();
                student.setId(cursor.getInt(idColumn));
                student.setFullName(cursor.getString(nameColumn));
                student.setAddingDate(cursor.getString(dateColumn));
                students.add(student);
            }while(cursor.moveToNext());
        }
        helper.close();
    }
    public static StudentRepository createInstance(Context context) {
        if(instance == null) {
            instance = new StudentRepository(context);
            return instance;
        }
        return instance;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void notifyDBChanged() {
        students.clear();
        database = helper.getWritableDatabase();
        String order = "ID ASC";
        Cursor cursor = database.query("Students", null,null, null, null, null, order, null);
        if(cursor.moveToFirst()) {
            int idColumn = cursor.getColumnIndex("ID");
            int nameColumn = cursor.getColumnIndex("FullName");
            int dateColumn = cursor.getColumnIndex("AddingDate");
            do {
                Student student = new Student();
                student.setId(cursor.getInt(idColumn));
                student.setFullName(cursor.getString(nameColumn));
                student.setAddingDate(cursor.getString(dateColumn));
                students.add(student);
            }while(cursor.moveToNext());
        }
        helper.close();
    }
}