package android.bignerdranch.com.androidlab31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    StudentRepository repository;
    SQLiteDatabase database;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper helper = new DBHelper(getApplicationContext());
        database = helper.getWritableDatabase();
        database.delete("Students", null, null);
        final Random random = new Random();
        for(int i = 0; i < 5; i++) {
            ContentValues values = new ContentValues();
            values.put("FullName", random.nextInt());
            values.put("AddingDate", Calendar.getInstance().getTime().toString());
            database.insert("Students", null, values);
        }
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        studentAdapter = new StudentAdapter(getApplicationContext());
        recyclerView.setAdapter(studentAdapter);
        repository = StudentRepository.createInstance(getApplicationContext());
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("FullName", random.nextInt());
                values.put("AddingDate", Calendar.getInstance().getTime().toString());
                database.insert("Students", null, values);
                repository.notifyDBChanged();
                studentAdapter.notifyDataSetChanged();
            }
        });
        Button changeButton = findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("FullName", "Иванов Иван Иваныч");
                String selection = "ID = " + repository.getStudents()
                        .get(repository.getStudents().size() - 1).getId();
                database.update("Students", values, selection, null);
                repository.notifyDBChanged();
                studentAdapter.notifyDataSetChanged();
            }
        });
    }
}
