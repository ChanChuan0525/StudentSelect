package com.chanchuan.studentselect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chanchuan.adapter.SelectAdapter;
import com.chanchuan.bean.Student;
import com.chanchuan.greendao.MyApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private SelectAdapter selectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initData() {

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        if (number.equals("1")) {
            List<Student> select = MyApp.select();
            selectAdapter.setStudents(select);
        } else {
            Student student = MyApp.selectOne(number);
            if (student == null) {
                Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
            }else {
                List<Student> students = new ArrayList<>();
                students.add(student);
                selectAdapter.setStudents(students);
            }
        }
    }

    private void initView() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        selectAdapter = new SelectAdapter(this);
        recycler.setAdapter(selectAdapter);
    }
}
