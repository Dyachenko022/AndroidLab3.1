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
        DBHelper helper = new DBHelper(getApplicationContext(), 2);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        studentAdapter = new StudentAdapter(getApplicationContext());
        recyclerView.setAdapter(studentAdapter);
        repository = StudentRepository.createInstance(getApplicationContext());
        database = helper.getWritableDatabase();
        final Random random = new Random();
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("FirstName", random.nextInt());
                values.put("LastName", random.nextInt());
                values.put("MiddleName", random.nextInt());
                values.put("AddingDate", Calendar.getInstance().getTime().toString());
                database.insert("Students", null, values);
                repository.updateRepository();
                studentAdapter.notifyDataSetChanged();
            }
        });
        Button changeButton = findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("FirstName", "Иван");
                values.put("LastName", "Иванов");
                values.put("MiddleName", "Иванович");
                String selection = "ID = " + repository.getStudents()
                        .get(repository.getStudents().size() - 1).getId();
                database.update("Students", values, selection, null);
                repository.updateRepository();
                studentAdapter.notifyDataSetChanged();
            }
        });
    }
}