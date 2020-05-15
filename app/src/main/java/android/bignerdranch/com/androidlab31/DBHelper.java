package android.bignerdranch.com.androidlab31;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, int version) {
        super(context,"Students.db" ,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Students (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FullName TEXT," +
                "AddingDate TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("CREATE TABLE Students1 (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "LastName TEXT," +
                "FirstName TEXT," +
                "MiddleName TEXT," +
                "AddingDate TEXT);");
        db.execSQL("DROP TABLE Students;");
        db.execSQL("ALTER TABLE Students1 RENAME TO Students;");
    }
}
