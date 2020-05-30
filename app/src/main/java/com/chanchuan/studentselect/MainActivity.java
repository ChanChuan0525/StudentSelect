package com.chanchuan.studentselect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.chanchuan.bean.Student;
import com.chanchuan.greendao.MyApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sNumber)
    EditText sNumber;
    @BindView(R.id.sName)
    EditText sName;
    @BindView(R.id.hobby)
    Spinner hobby;
    @BindView(R.id.sClass)
    EditText sClass;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.select)
    Button select;
    @BindView(R.id.delete)
    Button delete;
    private String zhuanye;
    private String number;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        hobby.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zhuanye = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String studentClass = sClass.getText().toString();
                number = sNumber.getText().toString();
                name = sName.getText().toString();
                ;
                Student student = new Student();
                student.setNumber(number);
                student.setName(name);
                student.setSpecialty(zhuanye);
                student.setSClass(studentClass);
                MyApp.insert(student);
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                String string = sNumber.getText().toString();
                if (string .equals("")) {
                    intent.putExtra("number", "1");
                    startActivity(intent);
                } else {
                    intent.putExtra("number", string);
                    startActivity(intent);
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = sNumber.getText().toString();
                MyApp.deleteStudent(string);
            }
        });
    }
}
