package android.bignerdranch.com.androidlab31;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    StudentRepository repository;
    LayoutInflater inflater;
    public StudentAdapter(Context context) {
        repository = StudentRepository.createInstance(context);
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = repository.getStudents().get(position);
        holder.addingDate.setText(student.getAddingDate());
        holder.fullName.setText(student.toString());
    }

    @Override
    public int getItemCount() {
        return repository.getStudents().size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        public StudentViewHolder(View view) {
            super(view);
            fullName = view.findViewById(R.id.fullName);
            addingDate = view.findViewById(R.id.addingDate);
        }
        TextView fullName;
        TextView addingDate;
    }
}