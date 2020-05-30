package com.chanchuan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chanchuan.bean.Student;
import com.chanchuan.studentselect.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAdapter extends RecyclerView.Adapter {
    Context context;
    List<Student> students = new ArrayList<>();

    public SelectAdapter(Context context) {
        this.context = context;
    }

    public void setStudents(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View root = LayoutInflater.from(context).inflate(R.layout.student_item, viewGroup, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Student student = students.get(i);
        ((ViewHolder) viewHolder).name.setText(student.getName());
        ((ViewHolder) viewHolder).number.setText(student.getName());
        ((ViewHolder) viewHolder).hobby.setText(student.getSpecialty());
        ((ViewHolder) viewHolder).sClass.setText(student.getSClass());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.number)
        TextView number;
        @BindView(R.id.hobby)
        TextView hobby;
        @BindView(R.id.sClass)
        TextView sClass;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
